package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FitxategiaAukeratu extends JFrame {
	
	private JTextField textfieldFitxategia = new JTextField();
	private JLabel lblFitxategiaZabaldu = new JLabel("Fitxategia zabaldu");
	private JButton btnAukeratu = new JButton("Aukeratu");



	public FitxategiaAukeratu() {


		this.setBounds(525,200,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		lblFitxategiaZabaldu.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblFitxategiaZabaldu.setBounds(184, 24, 280, 60);
		getContentPane().add(lblFitxategiaZabaldu);
		

		textfieldFitxategia.setBounds(0, 140, 499, 39);
		getContentPane().add(textfieldFitxategia);
		textfieldFitxategia.setColumns(10);
		textfieldFitxategia.setEditable(false);
		btnAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(fc);
				 
				
			}
		});
		
		btnAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAukeratu.setBounds(509, 140, 153, 39);
		getContentPane().add(btnAukeratu);



	}
}
