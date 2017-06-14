import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class View_Main extends JFrame {

	private JPanel				contentPane;
	private JComboBox<String>	comboBox_Klasse;
	private JComboBox<String>	comboBox_Disziplin;

	private JButton				btn_Ok;
	private JScrollPane			scrollPane;

	private JPanel				panelBearbeitung;
	private JLabel				lblKlasseBearbeiten;
	private JLabel				lblDisziplinBearbeiten;
	private JButton				btnOkBearbeiten;
	private JLabel				lblAuswahlTitel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Main frame = new View_Main();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);

		JPanel panelAuswahl = new JPanel();
		splitPane.setLeftComponent(panelAuswahl);
		GridBagLayout gbl_panelAuswahl = new GridBagLayout();
		gbl_panelAuswahl.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panelAuswahl.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_panelAuswahl.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelAuswahl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelAuswahl.setLayout(gbl_panelAuswahl);

		JLabel lblLeer1 = new JLabel(" ");
		lblLeer1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblLeer1 = new GridBagConstraints();
		gbc_lblLeer1.anchor = GridBagConstraints.WEST;
		gbc_lblLeer1.gridwidth = 3;
		gbc_lblLeer1.fill = GridBagConstraints.VERTICAL;
		gbc_lblLeer1.insets = new Insets(0, 0, 5, 0);
		gbc_lblLeer1.gridx = 0;
		gbc_lblLeer1.gridy = 0;
		panelAuswahl.add(lblLeer1, gbc_lblLeer1);

		lblAuswahlTitel1 = new JLabel("Wähle:");
		lblAuswahlTitel1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblAuswahlTitel1 = new GridBagConstraints();
		gbc_lblAuswahlTitel1.anchor = GridBagConstraints.WEST;
		gbc_lblAuswahlTitel1.gridwidth = 3;
		gbc_lblAuswahlTitel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuswahlTitel1.gridx = 0;
		gbc_lblAuswahlTitel1.gridy = 1;
		panelAuswahl.add(lblAuswahlTitel1, gbc_lblAuswahlTitel1);

		JLabel lblKlasse = new JLabel("Klasse:");
		lblKlasse.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		GridBagConstraints gbc_lblKlasse = new GridBagConstraints();
		gbc_lblKlasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblKlasse.anchor = GridBagConstraints.EAST;
		gbc_lblKlasse.gridx = 0;
		gbc_lblKlasse.gridy = 2;
		panelAuswahl.add(lblKlasse, gbc_lblKlasse);

		comboBox_Klasse = new JComboBox<String>();
		comboBox_Klasse.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_comboKlasse = new GridBagConstraints();
		gbc_comboKlasse.gridwidth = 2;
		gbc_comboKlasse.insets = new Insets(0, 0, 5, 0);
		gbc_comboKlasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboKlasse.gridx = 1;
		gbc_comboKlasse.gridy = 2;
		panelAuswahl.add(comboBox_Klasse, gbc_comboKlasse);

		JLabel lblDisziplin = new JLabel("Disziplin:");
		lblDisziplin.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		GridBagConstraints gbc_lblDisziplin = new GridBagConstraints();
		gbc_lblDisziplin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisziplin.gridx = 0;
		gbc_lblDisziplin.gridy = 3;
		panelAuswahl.add(lblDisziplin, gbc_lblDisziplin);

		comboBox_Disziplin = new JComboBox<String>();
		comboBox_Disziplin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		GridBagConstraints gbc_comboDisziplin = new GridBagConstraints();
		gbc_comboDisziplin.gridwidth = 2;
		gbc_comboDisziplin.insets = new Insets(0, 0, 5, 0);
		gbc_comboDisziplin.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDisziplin.gridx = 1;
		gbc_comboDisziplin.gridy = 3;
		panelAuswahl.add(comboBox_Disziplin, gbc_comboDisziplin);

		btn_Ok = new JButton("Ok");
		btn_Ok.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btn_Ok.setActionCommand("Ok");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 4;
		panelAuswahl.add(btn_Ok, gbc_btnOk);

		JPanel panelBearbeiten = new JPanel();
		splitPane.setRightComponent(panelBearbeiten);
		GridBagLayout gbl_panelBearbeiten = new GridBagLayout();
		gbl_panelBearbeiten.columnWidths = new int[] { 164, 0, 0 };
		gbl_panelBearbeiten.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelBearbeiten.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panelBearbeiten.rowWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		panelBearbeiten.setLayout(gbl_panelBearbeiten);

		lblKlasseBearbeiten = new JLabel("Klasse");
		lblKlasseBearbeiten.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblKlasseBearbeiten = new GridBagConstraints();
		gbc_lblKlasseBearbeiten.anchor = GridBagConstraints.WEST;
		gbc_lblKlasseBearbeiten.insets = new Insets(0, 0, 5, 5);
		gbc_lblKlasseBearbeiten.gridx = 0;
		gbc_lblKlasseBearbeiten.gridy = 0;
		panelBearbeiten.add(lblKlasseBearbeiten, gbc_lblKlasseBearbeiten);

		lblDisziplinBearbeiten = new JLabel("Disziplin");
		lblDisziplinBearbeiten
				.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GridBagConstraints gbc_lblDisziplinBearbeiten = new GridBagConstraints();
		gbc_lblDisziplinBearbeiten.anchor = GridBagConstraints.WEST;
		gbc_lblDisziplinBearbeiten.insets = new Insets(0, 0, 5, 0);
		gbc_lblDisziplinBearbeiten.gridx = 1;
		gbc_lblDisziplinBearbeiten.gridy = 0;
		panelBearbeiten.add(lblDisziplinBearbeiten, gbc_lblDisziplinBearbeiten);

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panelBearbeiten.add(scrollPane, gbc_scrollPane_1);

		panelBearbeitung = new KlassenPanel();
		scrollPane.setViewportView(panelBearbeitung);

		btnOkBearbeiten = new JButton("Ok");
		btnOkBearbeiten.setEnabled(false);
		GridBagConstraints gbc_btnBearbeitungOk = new GridBagConstraints();
		gbc_btnBearbeitungOk.anchor = GridBagConstraints.EAST;
		gbc_btnBearbeitungOk.gridx = 1;
		gbc_btnBearbeitungOk.gridy = 2;
		panelBearbeiten.add(btnOkBearbeiten, gbc_btnBearbeitungOk);
	}

	public void setBtnOkListener(ActionListener listener) {
		btn_Ok.addActionListener(listener);
	}

	public void setComboBoxKlasse(String[] klasse) {
		if (klasse != null) {
			comboBox_Klasse.setModel(new DefaultComboBoxModel<String>(klasse));
		}
	}

	public void setComboBoxDisziplin(String[] klasse) {
		if (klasse != null) {
			comboBox_Disziplin
					.setModel(new DefaultComboBoxModel<String>(klasse));
		}
	}

	public String getSelectedKlasse() {
		String result = "";
		result = (String) comboBox_Klasse.getSelectedItem();
		return result;
	}

	public String getSelectedDisziplin() {
		String result = "";
		result = (String) comboBox_Disziplin.getSelectedItem();
		return result;
	}

	public void showErrorMessage(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage());
	}

	public void showMessage(String insertBetrieb) {
		JOptionPane.showMessageDialog(this, insertBetrieb);
	}

	public void showKlasse(Klasse k) {
		panelBearbeitung = new KlassenPanel(k);
		scrollPane.setViewportView(panelBearbeitung);
		setTitelBearbeiten();
		setBtnOkBearbeitenEnabled(true);
	}

	private void setTitelBearbeiten() {
		lblKlasseBearbeiten.setText((String) comboBox_Klasse.getSelectedItem());
		lblDisziplinBearbeiten
				.setText((String) comboBox_Disziplin.getSelectedItem());
	}
	
	private void setBtnOkBearbeitenEnabled(boolean b){
		btnOkBearbeiten.setEnabled(b);
	}
}