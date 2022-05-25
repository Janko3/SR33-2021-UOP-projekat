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
import models.Bibliotekari;


public class BibliotekariProzor extends JFrame{
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	
	private Biblioteka biblioteka;
	
	
	public BibliotekariProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Bibliotekari");
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
		
		String[] zaglavlja = new String[] {"Ime","Prezime","JMBG","Adresa","Pol","Korisnicko ime","Lozinka","Plata","ID"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniBibliotekari().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniAdmini().size();i++) {
			Bibliotekari bibliotekar = biblioteka.neobrisaniBibliotekari().get(i);
			sadrzaj[i][0] = bibliotekar.getIme();
			sadrzaj[i][1] = bibliotekar.getPrezime();
			sadrzaj[i][2] = bibliotekar.getJMBG();
			sadrzaj[i][3]= bibliotekar.getAdresa();
			sadrzaj[i][4] = bibliotekar.getPol();
			sadrzaj[i][5] = bibliotekar.getKorisnickoIme();
			sadrzaj[i][6] = bibliotekar.getLozinka();
			sadrzaj[i][7] = bibliotekar.getPlata();
			sadrzaj[i][8] = bibliotekar.getId();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		bibliotekariTabela = new JTable(tableModel);
		
		bibliotekariTabela.setRowSelectionAllowed(true);
		bibliotekariTabela.setColumnSelectionAllowed(false);
		bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekariTabela.setDefaultEditor(Object.class, null);
		bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
		add(scrollPane,BorderLayout.CENTER);
		
	}
}
