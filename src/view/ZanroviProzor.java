package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dialogs.DialogDodajZanr;
import models.Biblioteka;
import models.Zanr;
import models.Zaposleni;

public class ZanroviProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;

	public ZanroviProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Zanrovi");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		initActions();
		// TODO Auto-generated constructor stub
	}
private void initView() {
		
		
		mainToolBar.add(addBtn);
		mainToolBar.add(editBtn);
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
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
private void initActions() {
	addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DialogDodajZanr dz = new DialogDodajZanr(biblioteka, prijavljeniZaposleni);
			dz.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
}

}
