package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.Biblioteka;
import models.Iznajmljivanje;

public class IznajmljivanjaProzor extends JFrame{
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjaTabela;
	
	private Biblioteka biblioteka;

	public IznajmljivanjaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanja");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();

	}
	
private void initView() {
		
		
		mainToolBar.add(addBtn);
		mainToolBar.add(editBtn);
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[] zaglavlja = new String[] {"Datum iznajmljivanja","Datum vracanja","Primerak","Clan","Zaposleni"};
		Object[][]sadrzaj = new Object[biblioteka.getSvaIznamljivanja().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.getSvaIznamljivanja().size();i++) {
			Iznajmljivanje iznajmljivanje = biblioteka.getSvaIznamljivanja().get(i);
			sadrzaj[i][0] = iznajmljivanje.getDatumIznajmljivanje();
			sadrzaj[i][1] = iznajmljivanje.getDatumVracanja();
			sadrzaj[i][2] = iznajmljivanje.getPrimerakKnjige().getKnjiga().getId();
			sadrzaj[i][3] = iznajmljivanje.getClan().getBrClanskeKarte();
			sadrzaj[i][4] = iznajmljivanje.getZaposleni().getId();
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

}
