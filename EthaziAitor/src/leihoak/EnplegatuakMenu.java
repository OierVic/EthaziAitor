package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

import kontroladorea.Kontroladorea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class EnplegatuakMenu extends JFrame {
	
	//Leihoak
	private Kontroladorea kontroladorea;
	
	
	private JButton btnAtzera = new JButton("Atzera");
	private JLabel lblEnplegatuak = new JLabel("Enplegatuak");
	private JPanel panel;
	
	public EnplegatuakMenu() {
		
		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAtzera.setBounds(60, 477, 145, 44);
		getContentPane().add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				kontroladorea.AtzeraFitxategiakEnpleg();
				
			}
		});
		
		lblEnplegatuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEnplegatuak.setBounds(204, 21, 206, 56);
		getContentPane().add(lblEnplegatuak);
		
		panel = new JPanel();
		panel.setBounds(39, 89, 601, 300);
		getContentPane().add(panel);
		
		
		
		
	}
	
	
	//Para que las ventanas aparezcan

			public void Kontroladorea(Kontroladorea kontroladorea) {
				this.kontroladorea = kontroladorea;
			}

}
