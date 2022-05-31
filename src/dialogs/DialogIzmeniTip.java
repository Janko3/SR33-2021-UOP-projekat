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
import models.TipClanarine;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.TipoviProzor;

public class DialogIzmeniTip extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	private int index;
	
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblCena = new JLabel("Cena");
	private JTextField txtCena = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(10);
	
	public DialogIzmeniTip(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.index = index;
		setTitle("Izmeni Clana");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
	public void initGUI(){
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblOpis);
		add(txtOpis);
		add(lblCena);
		add(txtCena);
		add(lblId);
		add(txtId);
		add(btnSave);
		add(btnCncl);
		TipClanarine t = biblioteka.neobrisaniTipovi().get(index);
		txtOpis.setText(t.getOpis());
		txtCena.setText(String.valueOf(t.getCena()));
		txtId.setText(t.getId());
		txtId.setEditable(false);
		
		

}
	
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmeniTip.this.dispose();
				DialogIzmeniTip.this.setVisible(false);

			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtOpis.getText().equals("")||txtCena.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostDouble(txtCena.getText())== false) {
					JOptionPane.showMessageDialog(rootPane,"Platu morate uneti u formatu 0.00");
					return;
				}
				prijavljeniZaposleni.updateTip(txtId.getText(), txtOpis.getText().trim(), Double.parseDouble(txtCena.getText().trim()));
				dispose();
				TipoviProzor tp = new TipoviProzor(biblioteka, prijavljeniZaposleni);
				tp.setVisible(true);
				
			}
		});
	}
	}
