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

import dialogs.DialogDodajBibliotekara;
import models.Administratori;
import models.Biblioteka;
import models.Bibliotekari;
import models.Zaposleni;


public class BibliotekariProzor extends JFrame{
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	
	public BibliotekariProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Bibliotekari");
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
		
		String[] zaglavlja = new String[] {"Ime","Prezime","JMBG","Adresa","Pol","Korisnicko ime","Lozinka","Plata","ID"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniBibliotekari().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniBibliotekari().size();i++) {
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
	
	private void initActions() {
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DialogDodajBibliotekara db = new DialogDodajBibliotekara(biblioteka,prijavljeniZaposleni);
				db.setVisible(true);
				dispose();
				// TODO Auto-generated method stub
				
			}
		});
deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bibliotekariTabela .getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati bibliotekara za brisanje");
					return;
				}
				int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
				if(a == JOptionPane.YES_OPTION) {
					Administratori admin = (Administratori) prijavljeniZaposleni;
					admin.obrisiBibliotekara(bibliotekariTabela.getModel().getValueAt(bibliotekariTabela.getSelectedRow(),8).toString());
					dispose();
					BibliotekariProzor bp = new BibliotekariProzor(biblioteka, admin);
					bp.setVisible(true);
				}
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
		
	}

