package leihoak;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
 
public class Kudeaketa extends JFrame {
 
    /**************** ATRIBUTOS ***************************/
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DEFINICIÓN DE LAS ETIQUETAS
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblNIF;
 
    //DEFINICIÓN DE LOS CUADROS DE TEXTO
    protected JTextField txtNombre;
    protected JTextField txtApellido;
    protected JTextField txtNIF;
 
    //DEFINICIÓN DE LOS BOTONES
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
 
    //DEFINICIÓN DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Unión de la cabecera y la tabla
    protected JTable tabla; //Tabla propiamente dicha
 
    /**************** MÉTODOS ***************************/
    public Kudeaketa(){
        //Métodos de la JFrame
        setBounds(525,200,700,600);//Definir las dimensiones de la ventana
        setTitle("GESTIÓN DE CLIENTES - KADUM");    //Barra de título
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acción al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y AÑADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //INDICAR QUE SE QUIERE USAR SPRINGLAYOUT
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        //Vamos al lío
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        //ETIQUETA NOMBRE
        lblNombre = new JLabel("Nombre:");  //Crear el objeto
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add(lblNombre);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA APELLIDOS
        lblApellido = new JLabel("Apellidos:");
        lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add(lblApellido);
        sp.putConstraint(SpringLayout.NORTH, lblApellido, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblApellido,  10,
                        SpringLayout.WEST, contenedor);
        //ETIQUETA NIF
        lblNIF = new JLabel("NIF:");
        lblNIF.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add(lblNIF);
        sp.putConstraint(SpringLayout.NORTH, lblNIF, 90,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNIF,  10,
                        SpringLayout.WEST, contenedor);
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtNombre       = new JTextField();
        sp.putConstraint(SpringLayout.EAST, txtNombre, 365,
                        SpringLayout.WEST, contenedor);
        contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 10,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL NIF
        txtApellido = new JTextField();
        sp.putConstraint(SpringLayout.EAST, txtApellido, 0,
                        SpringLayout.EAST, txtNombre);
        contenedor.add(txtApellido);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtApellido, 50,
                        SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtApellido, 100,
                        SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LOS APELLIDOS
        txtNIF      = new JTextField();
        sp.putConstraint(SpringLayout.EAST, txtNIF, 0, SpringLayout.EAST, txtNombre);
        contenedor.add(txtNIF);
        sp.putConstraint(SpringLayout.NORTH, txtNIF, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNIF, 100, SpringLayout.WEST, contenedor);
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF TABLA  vvvvvvvvvvvvvvvvvvvv **/
        scroll      = new JScrollPane();
        cabecera    = new String[] {"ID","NOMBRE","NIF"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //y ahora se coloca el scrollpane...
        contenedor.add(scroll); //añadir al contenedor
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
        //BOTÓN AÑADIR
        btnAdd          = new JButton("Añadir");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        sp.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, scroll);
        sp.putConstraint(SpringLayout.WEST, btnAdd, 33, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10,
                        SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.EAST, btnAdd, 128, SpringLayout.WEST, contenedor);
        contenedor.add(btnAdd);
        //BOTÓN BORRAR
        btnDel          = new JButton("Borrar");
        sp.putConstraint(SpringLayout.NORTH, btnDel, 6, SpringLayout.SOUTH, scroll);
        sp.putConstraint(SpringLayout.WEST, btnDel, 173, SpringLayout.EAST, btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, 0, SpringLayout.SOUTH, btnAdd);
        btnDel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contenedor.add(btnDel);
        //BOTÓN MODIFICAR
        btnUpd          = new JButton("Editar");
        sp.putConstraint(SpringLayout.EAST, btnDel, -176, SpringLayout.WEST, btnUpd);
        btnUpd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        sp.putConstraint(SpringLayout.NORTH, btnUpd, 6, SpringLayout.SOUTH, scroll);
        sp.putConstraint(SpringLayout.WEST, btnUpd, -120, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, 40, SpringLayout.SOUTH, scroll);
        sp.putConstraint(SpringLayout.EAST, btnUpd, -40, SpringLayout.EAST, contenedor);
        btnUpd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        contenedor.add(btnUpd);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        setVisible(true);
 
    }
 
//    public void conectaControlador(  Controller c  ){
// 
//        btnAdd.addActionListener(c);
//        btnAdd.setActionCommand("INSERTAR");
// 
//        btnDel.addActionListener(c);
//        btnDel.setActionCommand("BORRAR");
// 
//        btnUpd.addActionListener(c);
//        btnUpd.setActionCommand("MODIFICAR");
// 
//        tabla.addMouseListener(c);
//        //sólo se permite pulsar una fila a la vez.
//        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    }
}