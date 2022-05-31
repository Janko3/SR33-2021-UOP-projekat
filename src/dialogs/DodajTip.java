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
import view.TipoviProzor;

public class DodajTip extends JDialog {
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	
	
	public DodajTip(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Dodaj Novi Tip");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblOpis);
		add(txtOpis);
		add(lblCena);
		add(txtCena);
		add(btnSave);
		add(btnCncl);
		
	}
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajTip.this.dispose();
				DodajTip.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtOpis.getText().equals("")||txtCena.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostDouble(txtCena.getText())== false) {
					JOptionPane.showMessageDialog(rootPane,"Platu morate uneti u formatu 0.00");
					return;
				}
				prijavljeniZaposleni.DodajTip(txtOpis.getText().trim(),Double.parseDouble(txtCena.getText().trim()));
				dispose();
				TipoviProzor tp = new TipoviProzor(biblioteka,prijavljeniZaposleni);
				tp.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		});
	}

}
