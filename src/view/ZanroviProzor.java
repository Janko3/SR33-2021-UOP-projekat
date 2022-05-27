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
import models.Zanr;

public class ZanroviProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private Biblioteka biblioteka;

	public ZanroviProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Zanrovi");
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
		
		String[]zaglavlja = new String[] {"Opis","ID","Oznaka"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisaniZanrovi().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniZanrovi().size();i++) {
			Zanr zanr = biblioteka.neobrisaniZanrovi().get(i);
			sadrzaj[i][0] = zanr.getOpis();
			sadrzaj[i][1] = zanr.getId();
			sadrzaj[i][2] = zanr.getOznaka();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		add(scrollPane,BorderLayout.CENTER);
}

}
