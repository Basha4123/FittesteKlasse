import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Controller_Main implements IViewController {

	View_Main			view;
	DBControllerImpl	dbController;
	ResultSetConverter	resultSetConverter;

	String[]			klassen	= null;
	String[]			disziplinen = null;

	public Controller_Main(View_Main v, String path) {
		resultSetConverter = new ResultSetConverter();
		dbController = new DBControllerImpl();
		try {
			dbController.openConnection(path);
			view = v;
			connectListenerToView();
		}
		catch (SQLException e) {
			view.showErrorMessage(e);
		}
		
		connectListenerToView();

		try {
			this.klassen = resultSetConverter
					.toStringArray(
							dbController.executeSelectSqlLite(
									"SELECT DISTINCT bezeichnung FROM klasse"),
							"bezeichnung");
		}
		catch (SQLException e1) {
			view.showErrorMessage(e1);
		}
		view.setComboBoxKlasse(klassen);
		
		try {
			this.disziplinen = resultSetConverter
					.toStringArray(
							dbController.executeSelectSqlLite(
									"SELECT DISTINCT bezeichnung FROM disziplin"),
							"bezeichnung");
		}
		catch (SQLException e1) {
			view.showErrorMessage(e1);
		}
		view.setComboBoxDisziplin(disziplinen);
	}

	private void connectListenerToView() {
		view.setBtnOkListener(new BtnOkListener());
	}

	class BtnOkListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String query =  getQuery(view.getSelectedKlasse(), view.getSelectedDisziplin());

			if (query != null) {
				ResultSet rs = null;
				try {
					rs = dbController.executeSelectSqlLite(query);
					
					Klasse klasse = DBUtils.resultSetToKlasse(rs);
					
					System.out.println(klasse.toString());
					
					view.showKlasse(klasse);

				}
				catch (SQLException e1) {
					view.showErrorMessage(e1);
				}
			}
			else {
				view.showMessage("ACHTUNG: Du hast keine Auswahl getroffen!");
			}

		}

		private String getQuery(String klasse, String disziplin) {

			String query = null;
			query = "SELECT s.vorname AS Vorname, s.name AS Nachname, s.klasse AS Klasse, l.wert AS Leistungswert FROM schueler s, leistung l WHERE s.id = l.sid AND s.klasse ='"
					+ klasse + "' AND l.disziplin ='" + disziplin + "'";
//			System.out.println(query);
			return query;

		}
	}

	@Override
	public void resetView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		View_Main window = new View_Main();
		
		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
		chooser.setDialogTitle("Wähle die Datenbank!");
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Datenbank", 
	            "db"));
		int returnVal = chooser.showDialog(window, "OK");
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName());
            System.out.println("Opening: " + file.getAbsolutePath());
            
            Controller_Main controller = new Controller_Main(window,file.getAbsolutePath());
    		
    		window.setVisible(true);
            
        } else {
        	System.out.println("Open command cancelled by user.");
        }
		
		
	}

}
