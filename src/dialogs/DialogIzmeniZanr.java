package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.Biblioteka;
import models.Zanr;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.ZanroviProzor;

public class DialogIzmeniZanr extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	private int index;
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblOznaka = new JLabel("Oznaka");
	private JTextField txtOznaka = new JTextField(20);
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");

	public DialogIzmeniZanr(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.index = index;
		setTitle("Izmeni Zanr");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblOpis);
		add(txtOpis);
		add(lblOznaka);
		add(txtOznaka);
		add(lblId);
		add(txtId);
		add(btnSave);
		add(btnCncl);
		
		Zanr z = biblioteka.neobrisaniZanrovi().get(index);
		txtOpis.setText(z.getOpis());
		txtOznaka.setText(z.getOznaka());
		txtId.setText(z.getId());
		txtId.setEditable(false);
		
		
	}
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmeniZanr.this.dispose();
				DialogIzmeniZanr.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtOpis.getText().equals("")||txtOznaka.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(!biblioteka.neobrisaniZanrovi().get(index).getOpis().equals(txtOpis.getText().trim().toLowerCase())) {
					if(!biblioteka.validnostZanr(txtOpis.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Uneti zanr vec postoji");
						return;
					}
				}
				prijavljeniZaposleni.updateZanr(txtOpis.getText().trim(), txtId.getText(),txtOznaka.getText().trim());
				dispose();
				ZanroviProzor zp = new ZanroviProzor(biblioteka, prijavljeniZaposleni);
				zp.setVisible(true);
			}
		});
	}

}
