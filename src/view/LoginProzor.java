package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Administratori;
import models.Biblioteka;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class LoginProzor extends JFrame {
	private JLabel lblGreeting = new JLabel("Dobrodosli. Molimo da se prijavite.");
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblPassword = new JLabel("Sifra");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	Biblioteka biblioteka;
	

	public LoginProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300,300);
		initGUI();
		initActions();
		pack();
		
		
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		txtKorisnickoIme.setText("jr3");
		pfPassword.setText("lozinka3");
		getRootPane().setDefaultButton(btnOk);

}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
				
			}
		});
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfPassword.getPassword()).trim();
				
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Molimo, unesite sve podatke za prijavu");
					
				}else {
					Zaposleni prijavljeniZaposleni = biblioteka.loginZaposleni(korisnickoIme, sifra);
					if(prijavljeniZaposleni == null) {
						JOptionPane.showMessageDialog(null,"Pogresno uneti podaci, pokusajte ponovo","GRESKA",JOptionPane.WARNING_MESSAGE);
					}else {
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						MainWindow mw = new MainWindow(biblioteka, prijavljeniZaposleni);
						mw.setVisible(true);
					}
				}
				
			}
		});
	}
}
