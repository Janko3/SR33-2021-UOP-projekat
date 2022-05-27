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
import models.Primerak;

public class PrimerciProzor extends JFrame {
		
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private Biblioteka biblioteka;
	
	

	public PrimerciProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Primerci");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		// TODO Auto-generated constructor stub
	}
	
private void initView() {
		
		
		mainToolBar.add(addBtn);
		mainToolBar.add(editBtn);
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Knjiga","Broj Strana","Godina stampanja","ID","Jezik","Tip poveza"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisaniPrimerci().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniPrimerci().size();i++) {
			Primerak primerak = biblioteka.neobrisaniPrimerci().get(i);
			sadrzaj[i][0] = primerak.getKnjiga().getNaslov();
			sadrzaj[i][1] = primerak.getBrojStrana();
			sadrzaj[i][2] = primerak.getGodinaStampanja();
			sadrzaj[i][3] = primerak.getId();
			sadrzaj[i][4] = primerak.getJezik();
			sadrzaj[i][5] = primerak.getPovez();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		add(scrollPane,BorderLayout.CENTER);
}

}
