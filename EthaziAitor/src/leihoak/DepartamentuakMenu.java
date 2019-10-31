package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;

import eredua.Departamentua;
import kontroladorea.Kontroladorea;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DepartamentuakMenu extends JFrame {
	
	//Leihoak
	private Kontroladorea kontroladorea;

	
	private JButton btnAtzera = new JButton("Atzera");
	private JLabel lblDepartamentuak = new JLabel("Departamentuak");
	private JTable jtable;
	
	public DepartamentuakMenu() {
		
		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		
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
	
	
	//Para que las ventanas aparezcan

			public void Kontroladorea(Kontroladorea kontroladorea) {
				this.kontroladorea = kontroladorea;
			}
}
