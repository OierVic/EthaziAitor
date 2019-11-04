package leihoak;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import eredua.Departamentua;
import kontroladorea.Kontroladorea;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class DepartamentuakMenu extends JFrame {
	
	private Kontroladorea kontroladorea;
	int lerroAukeratu;
	String[] a�adir = {null, null, null}; // Cantidad de columnas de la tabla
    /**************** ATRIBUTOS ***************************/
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DEFINICI�N DE LAS ETIQUETAS
    private JLabel lblKodea;
    private JLabel lblIzena;
    private JLabel lblKokapena;
 
    //DEFINICI�N DE LOS CUADROS DE TEXTO
    protected JTextField txtKodea;
    protected JTextField txtIzena;
    protected JTextField txtKokapena;
 
    //DEFINICI�N DE LOS BOTONES
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
 
    //DEFINICI�N DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Uni�n de la cabecera y la tabla
    protected JTable tabla; //Tabla propiamente dicha
 
    /**************** M�TODOS ***************************/
    //CONSTRUCTOR
    public DepartamentuakMenu(){
        //M�todos de la JFrame
    	setBounds(525,200,700,600);//Definir las dimensiones de la ventana
        //setTitle("GESTI�N DE CLIENTES - KADUM");    //Barra de t�tulo
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acci�n al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y A�ADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //INDICAR QUE SE QUIERE USAR SPRINGLAYOUT
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        //Vamos al l�o
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        //ETIQUETA NOMBRE
        lblKodea = new JLabel("Kodea:");  //Crear el objeto
        contenedor.add(lblKodea);      //A�adirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblKodea, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblKodea,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA APELLIDOS
        lblIzena = new JLabel("Izena:");
        contenedor.add(lblIzena);
        sp.putConstraint(SpringLayout.NORTH, lblIzena, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblIzena,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA NIF
        lblKokapena = new JLabel("Kokapena:");
        contenedor.add(lblKokapena);
        sp.putConstraint(SpringLayout.NORTH, lblKokapena, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblKokapena,  10,
                        SpringLayout.WEST, contenedor);
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtKodea       = new JTextField();
        contenedor.add(txtKodea);
        sp.putConstraint(SpringLayout.NORTH, txtKodea, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtKodea, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtKodea, 300,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL NIF
        txtIzena = new JTextField();
        contenedor.add(txtIzena);    //a�adir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtIzena, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtIzena, 100,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtIzena, 300,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LOS APELLIDOS
        txtKokapena = new JTextField();
        contenedor.add(txtKokapena);
        sp.putConstraint(SpringLayout.NORTH, txtKokapena, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtKokapena, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtKokapena, 300, SpringLayout.WEST, contenedor);
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF TABLA  vvvvvvvvvvvvvvvvvvvv **/
        datos = objectBidimensionaToDepartamentuak();
        //datos = objectBidimensionaToDepartamentuak(null);
        scroll      = new JScrollPane();
        cabecera    = new String[] {"Kodea","Izena","Kokapena"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //y ahora se coloca el scrollpane...
        contenedor.add(scroll); //a�adir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 120,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10,
                        SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,
                        SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,
                        SpringLayout.SOUTH, contenedor);
        /**************** EOF TABLA ^^^^^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
        //BOT�N A�ADIR
        btnAdd = new JButton("A�adir");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		a�adir[0] = txtKodea.getText();
        		a�adir[1] = txtIzena.getText();
        		a�adir[2] = txtKokapena.getText();
        		((DefaultTableModel)tabla.getModel()).addRow(a�adir);


        	}
        });
        sp.putConstraint(SpringLayout.EAST, btnAdd, 161, SpringLayout.WEST, contenedor);
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10,
                        SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnAdd,   60,
                        SpringLayout.WEST, contenedor);
        //BOT�N BORRAR
        btnDel          = new JButton("Borrar");
        btnDel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lerroAukeratu = tabla.getSelectedRow();
        		((DefaultTableModel)tabla.getModel()).removeRow(lerroAukeratu);
        	}
        });
        sp.putConstraint(SpringLayout.WEST, btnDel, 151, SpringLayout.EAST, btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10, SpringLayout.SOUTH, contenedor);
        contenedor.add(btnDel);
        //BOT�N MODIFICAR
        btnUpd          = new JButton("Editar");
        sp.putConstraint(SpringLayout.EAST, btnDel, -133, SpringLayout.WEST, btnUpd);
        sp.putConstraint(SpringLayout.WEST, btnUpd, -138, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST, btnUpd, -37, SpringLayout.EAST, contenedor);
        contenedor.add(btnUpd);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        //setVisible(true);
 
    }
    
    
    public Object[][] objectBidimensionaToDepartamentuak (){
    	ArrayList<Departamentua > arrayDepartamentuak = new ArrayList<Departamentua>();
		 arrayDepartamentuak = Departamentua.DepartamentuakSelect();
		 Object[][] datos = new Object[arrayDepartamentuak.size()][3] ;
		 
	    	for (int i = 0; i < arrayDepartamentuak.size(); i++) {
				datos[i][0]= Integer.toString(arrayDepartamentuak.get(i).getKodea());
				datos[i][1]= arrayDepartamentuak.get(i).getIzena();
				datos[i][2]= arrayDepartamentuak.get(i).getKokapena();
//				datos[i][0]= "pepe";
//				datos[i][1]= "pepito";
//				datos[i][2]= "pedro";
			}
	    	
	    	return datos;
	    }
    
    
    
  //Para que las ventanas aparezcan

	public void Kontroladorea(Kontroladorea kontroladorea) {
		this.kontroladorea = kontroladorea;
	}
}
 