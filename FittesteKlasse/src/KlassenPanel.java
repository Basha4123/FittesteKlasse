import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class KlassenPanel extends JPanel {
	
	JTextField textField;

	public KlassenPanel(){
		super();
		
		this.setBackground(new Color(255, 255, 255));
		this.setBorder(null);
		GridBagLayout gbl_panelBearbeitung = new GridBagLayout();
		gbl_panelBearbeitung.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelBearbeitung.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelBearbeitung.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelBearbeitung.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		this.setLayout(gbl_panelBearbeitung);
	}
	
	public KlassenPanel(Klasse k){
		super();
		
		GridBagLayout gbl_panelBearbeitung = new GridBagLayout();
		gbl_panelBearbeitung.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelBearbeitung.rowHeights = new int[]{0, 0, 0};
		gbl_panelBearbeitung.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		
		double[] rowWei = new double[k.getSize()+2];
		for (int i = 0; i < rowWei.length; i++) {
			rowWei[i]=0.0;
		}
		rowWei[k.getSize()+1]=1.0;
		
		gbl_panelBearbeitung.rowWeights = rowWei;
		
		this.setLayout(gbl_panelBearbeitung);
		this.setBackground(new Color(255, 255, 255));
		
		JLabel lblVornanme = new JLabel("Vorname");
		lblVornanme.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblVornanme = new GridBagConstraints();
		gbc_lblVornanme.insets = new Insets(0, 0, 5, 5);
		gbc_lblVornanme.anchor = GridBagConstraints.WEST;
		gbc_lblVornanme.gridx = 0;
		gbc_lblVornanme.gridy = 0;
		this.add(lblVornanme, gbc_lblVornanme);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblNachname = new GridBagConstraints();
		gbc_lblNachname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNachname.anchor = GridBagConstraints.WEST;
		gbc_lblNachname.gridx = 1;
		gbc_lblNachname.gridy = 0;
		this.add(lblNachname, gbc_lblNachname);
		
		JLabel lblWert = new JLabel("Wert");
		lblWert.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblWert = new GridBagConstraints();
		gbc_lblWert.insets = new Insets(0, 0, 5, 0);
		gbc_lblWert.anchor = GridBagConstraints.WEST;
		gbc_lblWert.gridx = 2;
		gbc_lblWert.gridy = 0;
		this.add(lblWert, gbc_lblWert);
		
		int anzahl = k.getSize();
		
		for(int i=0; i < anzahl; i++){
			
			JLabel lblMax = new JLabel(k.getSchueler(i).getVorname());
			lblMax.setFont(new Font("Lucida Grande", Font.BOLD, 11));
			GridBagConstraints gbc_lblMax = new GridBagConstraints();
			gbc_lblMax.insets = new Insets(0, 0, 0, 5);
			gbc_lblMax.fill = GridBagConstraints.NONE;
			gbc_lblMax.anchor = GridBagConstraints.WEST;
			gbc_lblMax.gridx = 0;
			gbc_lblMax.gridy = i+1;
			this.add(lblMax, gbc_lblMax);
			
			JLabel lblMustermann = new JLabel(k.getSchueler(i).getNachname());
			lblMustermann.setFont(new Font("Lucida Grande", Font.BOLD, 11));
			GridBagConstraints gbc_lblMustermann = new GridBagConstraints();
			gbc_lblMustermann.fill = GridBagConstraints.NONE;
			gbc_lblMustermann.anchor = GridBagConstraints.WEST;
			gbc_lblMustermann.insets = new Insets(0, 0, 0, 5);
			gbc_lblMustermann.gridx = 1;
			gbc_lblMustermann.gridy = i+1;
			this.add(lblMustermann, gbc_lblMustermann);
			
			textField = new JTextField();
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			textField.setText("" + k.getSchueler(i).getWert());
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.anchor = GridBagConstraints.WEST;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = i+1;
			this.add(textField, gbc_textField);
			textField.setColumns(10);
			
		}
		
		JLabel lblLeer = new JLabel("");
		GridBagConstraints gbc_lblLeer = new GridBagConstraints();
		gbc_lblLeer.insets = new Insets(0, 0, 5, 0);
		gbc_lblLeer.anchor = GridBagConstraints.WEST;
		gbc_lblLeer.weighty = 1.0;
		gbc_lblLeer.gridx = 0;
		gbc_lblLeer.gridy = anzahl+2;
		this.add(lblLeer, gbc_lblLeer);
	}
	
}
