package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dialogs.DialogDodajIznajmljivanje;
import models.Biblioteka;
import models.Iznajmljivanje;
import models.Zaposleni;

public class IznajmljivanjaProzor extends JFrame{
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjaTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;

	public IznajmljivanjaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Iznajmljivanja");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		initActions();

	}
	
private void initView() {
		
		
		mainToolBar.add(addBtn);
		
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[] zaglavlja = new String[] {"Datum iznajmljivanja","Datum vracanja","Primerak","Clan","Zaposleni","ID"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisanaIznajmljivanja().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisanaIznajmljivanja().size();i++) {
			Iznajmljivanje iznajmljivanje = biblioteka.neobrisanaIznajmljivanja().get(i);
			sadrzaj[i][0] = iznajmljivanje.getDatumIznajmljivanje();
			sadrzaj[i][1] = iznajmljivanje.getDatumVracanja();
			sadrzaj[i][2] = iznajmljivanje.getPrimerakKnjige().getId();
			sadrzaj[i][3] = iznajmljivanje.getClan().getBrClanskeKarte();
			sadrzaj[i][4] = iznajmljivanje.getZaposleni().getId();
			sadrzaj[i][5] = iznajmljivanje.getId();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		iznajmljivanjaTabela = new JTable(tableModel);
		
		iznajmljivanjaTabela.setRowSelectionAllowed(true);
		iznajmljivanjaTabela.setColumnSelectionAllowed(false);
		iznajmljivanjaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjaTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjaTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjaTabela);
		add(scrollPane,BorderLayout.CENTER);
}
private void initActions() {
	addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DialogDodajIznajmljivanje di = new DialogDodajIznajmljivanje(biblioteka, prijavljeniZaposleni);
			di.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
	deleteBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(iznajmljivanjaTabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Morate izabrati iznajmljivanje za brisanje");
				return;
			}
			int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da zelite da obrisete iznajmljivanje?");
			if(a== JOptionPane.YES_OPTION) {
				prijavljeniZaposleni.obrisiIznajmljivanje(iznajmljivanjaTabela.getModel().getValueAt(iznajmljivanjaTabela.getSelectedRow(), 5).toString());
				dispose();
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka, prijavljeniZaposleni);
				ip.setVisible(true);
				
			}
		}
	});
}

}
