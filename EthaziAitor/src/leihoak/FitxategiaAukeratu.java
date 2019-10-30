package leihoak;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import kontroladorea.Kontroladorea;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FitxategiaAukeratu extends JFrame {
	
	private JTextField textfieldFitxategia = new JTextField();
	private JLabel lblFitxategiaZabaldu = new JLabel("Fitxategia zabaldu");
	private JButton btnAukeratu = new JButton("Aukeratu");
	private JButton btnAtzera = new JButton("Atzera");
	//Leihoak
	private Kontroladorea kontroladorea;
	private final JButton btnHurrengoa = new JButton("Hurrengoa");
	private File archivo = new File("");

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
//				try {
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//						| UnsupportedLookAndFeelException e1) {
//					e1.printStackTrace();
//				}
				JFileChooser fc = new JFileChooser(".\\src\\");
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc.setMultiSelectionEnabled(false);
				
				FileNameExtensionFilter filtroCSV = new FileNameExtensionFilter("*.CSV", "csv");
				FileNameExtensionFilter filtroXML = new FileNameExtensionFilter("*.XML", "xml");
				FileNameExtensionFilter filtroJSON = new FileNameExtensionFilter("*.JSON", "json");
				fc.setFileFilter(filtroJSON);
				fc.setFileFilter(filtroXML);
				fc.setFileFilter(filtroCSV);
				

				
				fc.showOpenDialog(fc);
				archivo = fc.getSelectedFile();
				

				if (archivo != null) {
					textfieldFitxategia.setText(archivo.getAbsolutePath());
					btnHurrengoa.setEnabled(true);
				}
				
				
			}
		});
		
		btnAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAukeratu.setBounds(509, 140, 153, 39);
		getContentPane().add(btnAukeratu);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				kontroladorea.AteraOngietorria();
				
			}
		});
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAtzera.setBounds(58, 471, 184, 47);
		getContentPane().add(btnAtzera);
		btnHurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				kontroladorea.fitxategiaGorde(archivo);
				JOptionPane.showMessageDialog(null, "Fitxategia Gorde da ");
				kontroladorea.KudeatuLeihoa();
				
				
			}
		});
		btnHurrengoa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHurrengoa.setBounds(394, 471, 246, 47);
		
		getContentPane().add(btnHurrengoa);
		btnHurrengoa.setEnabled(false);
		
		
		
		
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//						| UnsupportedLookAndFeelException e) {
//					e.printStackTrace();
//				}
//				//new FitxategiaAukeratu().setVisible(true);
//			}
//		});
		

	}
	//Para que las ventanas aparezcan
	
	public void Kontroladorea(Kontroladorea kontroladorea) {
		this.kontroladorea = kontroladorea;
	}
	
	
	
}
