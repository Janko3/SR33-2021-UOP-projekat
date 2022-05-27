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
import models.TipClanarine;

public class TipoviProzor extends JFrame{
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable tipoviTabela;
	
	private Biblioteka biblioteka;

	public TipoviProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Tipovi clanarine");
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
		
		String[]zaglavlja = new String[] {"ID","Opis","Cena"};
		Object[][]sadrzaj= new Object[biblioteka.neobrisaniTipovi().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniTipovi().size();i++) {
			TipClanarine tip = biblioteka.neobrisaniTipovi().get(i);
			sadrzaj[i][0] = tip.getId();
			sadrzaj[i][1] = tip.getOpis();
			sadrzaj[i][2] = tip.getCena();
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		tipoviTabela = new JTable(tableModel);
		
		tipoviTabela.setRowSelectionAllowed(true);
		tipoviTabela.setColumnSelectionAllowed(false);
		tipoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tipoviTabela.setDefaultEditor(Object.class, null);
		tipoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(tipoviTabela);
		add(scrollPane,BorderLayout.CENTER);
}

}
