package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

import kontroladorea.Kontroladorea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartamentuakMenu extends JFrame {
	
	//Leihoak
	private Kontroladorea kontroladorea;

	
	private JButton btnAtzera = new JButton("Atzera");
	private JLabel lblDepartamentuak = new JLabel("Departamentuak");

	
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
	
	
	//Para que las ventanas aparezcan

			public void Kontroladorea(Kontroladorea kontroladorea) {
				this.kontroladorea = kontroladorea;
			}
	
}
