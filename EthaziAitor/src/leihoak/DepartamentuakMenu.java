package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import eredua.Departamentua;
import kontroladorea.Kontroladorea;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DepartamentuakMenu extends JFrame {
	
	//Leihoak
	private Kontroladorea kontroladorea;

	
	private JButton btnAtzera = new JButton("Atzera");
	private JLabel lblDepartamentuak = new JLabel("Departamentuak");
	private JTable table;
	
	public DepartamentuakMenu() {
		
		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		//kontroladorea.JtableSortu();
		
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAtzera.setBounds(55, 470, 155, 51);
		getContentPane().add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				kontroladorea.AtzeraFitxategiakDepart();
				
			}
		});
		
		
		lblDepartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDepartamentuak.setBounds(215, 27, 229, 51);
		getContentPane().add(lblDepartamentuak);
		
		
		
		
		
	}
	
	/*
	 * HURRENGO 3 METODOAK JTABLE ERATZEKO DA.
	 */
	public List<String[]> loadtable(ArrayList<Departamentua> depart) {

		// metodo honek egindako bilaketaren kontsultaren emaitza jasotzen du parametroz
		// eta honekin taula betetzen du

		List<String[]> filas = new ArrayList<String[]>();
		Departamentua departametua = new Departamentua(0, null, null);
		for (int i = 0; i < depart.size(); i++) {
			departametua = depart.get(i);

			filas.add(new String[] { Integer.toString(departametua.getKodea()), departametua.getIzena(), departametua.getKokapena() });

		}
		System.out.println(depart.size());
		return filas;
	}
	
	
	private List<String> getColumns() {
		// taulak izango dituen zutabeak arraylit batean gorde
		List<String> columnas = new ArrayList<String>();
		columnas.add("Kodea");
		columnas.add("Izena");
		columnas.add("Kokapena");
		return columnas;
	}
	
	public void taulaBete(ArrayList<Departamentua> depart) {

		List<String[]> filas = loadtable(depart);

		TableModel tableModel = new DefaultTableModel(filas.toArray(new Object[][] {}), getColumns().toArray()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
    
    
    
		table = new JTable(tableModel);
		
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setAutoscrolls(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//Informazioa eskuratu
				final int row = table.rowAtPoint(new Point(e.getX(), e.getY()));
				table.setRowSelectionInterval(row, row);
				int row2 = table.rowAtPoint(e.getPoint());
				/*String prezioa = table.getValueAt(row2, 2).toString();
				String izena = table.getValueAt(row2, 0).toString();
				String Plazak = table.getValueAt(row2, 5).toString();*/
				//Betebehar dena

			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Para que las ventanas aparezcan

			public void Kontroladorea(Kontroladorea kontroladorea) {
				this.kontroladorea = kontroladorea;
			}
}
