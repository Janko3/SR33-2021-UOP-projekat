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
import models.Knjiga;

public class KnjigeProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	
	private Biblioteka biblioteka;
	

	public KnjigeProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Knjige");
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
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[] zaglavlja = new String [] {"Naslov","Originalni naslov","Autor","Godina izdavanja","Opis","ID","Zanr","Jezik"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisaneKnjige().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaneKnjige().size();i++) {
			Knjiga knjiga = biblioteka.neobrisaneKnjige().get(i);
			sadrzaj[i][0] = knjiga.getNaslov();
			sadrzaj[i][1] = knjiga.getOriginalniNaslov();
			sadrzaj[i][2] = knjiga.getPisac();
			sadrzaj[i][3] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][4] = knjiga.getOpis();
			sadrzaj[i][5] = knjiga.getId();
			sadrzaj[i][6] = knjiga.getZanr().getOpis();
			sadrzaj[i][7] = knjiga.getJezik();
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		knjigeTabela = new JTable(tableModel);
		
		knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		add(scrollPane,BorderLayout.CENTER);
		
}

}
