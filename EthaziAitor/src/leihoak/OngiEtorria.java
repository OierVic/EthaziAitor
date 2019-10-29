package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OngiEtorria extends JFrame {


	private static final long serialVersionUID = 1L;
	private JButton btnDepartamentuak = new JButton("Departamentuak");
	private JButton btnEnplegatuak = new JButton("Enplegatuak");
	private JButton btnTxostena = new JButton("Formularioa edo txostena");


	public OngiEtorria() {

		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		btnDepartamentuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		
		btnDepartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDepartamentuak.setBounds(201, 36, 264, 73);
		getContentPane().add(btnDepartamentuak);
		btnEnplegatuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		
		btnEnplegatuak.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEnplegatuak.setBounds(201, 148, 264, 73);
		getContentPane().add(btnEnplegatuak);
		btnTxostena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Txostena
				
				
				
			}
		});
		
		btnTxostena.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTxostena.setBounds(154, 279, 381, 73);
		getContentPane().add(btnTxostena);

	}
}