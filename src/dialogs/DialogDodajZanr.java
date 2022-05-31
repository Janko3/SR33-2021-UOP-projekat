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
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.ZanroviProzor;

public class DialogDodajZanr extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblOznaka = new JLabel("Oznaka");
	private JTextField txtOznaka = new JTextField(20);
	
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	

	public DialogDodajZanr(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Dodaj Novi Zanr");
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
		add(btnSave);
		add(btnCncl);
		
	}
	private void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogDodajZanr.this.dispose();
				DialogDodajZanr.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtOpis.getText().equals("")||txtOznaka.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				
				prijavljeniZaposleni.DodajZanr(txtOpis.getText().trim(), txtOznaka.getText().trim());
				dispose();
				ZanroviProzor zp = new ZanroviProzor(biblioteka,prijavljeniZaposleni);
				zp.setVisible(true);
				
			}
		});
	}
	

}
