package leihoak;

import java.awt.SystemColor; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kontroladorea.Kontroladorea;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OngiEtorria extends JFrame {


	private static final long serialVersionUID = 1L;
	private JButton btnDepartamentuak = new JButton("Departamentuak");
	private JButton btnEnplegatuak = new JButton("Enplegatuak");
	private JButton btnTxostena = new JButton("Formularioa edo txostena");
	
	//Leihoak
	private Kontroladorea kontroladorea;
	

	public OngiEtorria() {

		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		btnDepartamentuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String DepartamentuaDa="Departamentuak";
				kontroladorea.fitxategiakaukeratuDepartLeihoa();
				
				
			}
		});
		
		btnDepartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDepartamentuak.setBounds(140, 29, 381, 90);
		getContentPane().add(btnDepartamentuak);
		btnTxostena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Txostena
				
				JOptionPane.showMessageDialog(null, "Ez du ezer egiten");
				
			}
		});
		
		btnTxostena.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTxostena.setBounds(140, 378, 381, 73);
		getContentPane().add(btnTxostena);
		
		btnEnplegatuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				kontroladorea.fitxategiakaukeratuEnplegLeihoa();
				
				
			}
		});
		btnEnplegatuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnplegatuak.setBounds(140, 196, 381, 79);
		getContentPane().add(btnEnplegatuak);

	}
	
	
	//Para que las ventanas aparezcan

		public void Kontroladorea(Kontroladorea kontroladorea) {
			this.kontroladorea = kontroladorea;
		}
}