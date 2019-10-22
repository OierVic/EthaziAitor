package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;



public class DepKonexio {

	public static void DepartamentuaTxertatu(Departamentua dep) {
		System.out.println("1");
		Connection conexion = konexioa.getConnection();
		System.out.println("2");
		try {
			//Statement s = conexion.createStatement();
			System.out.println("3");
			
			// INSERT INTO departamentu (kodea, izena, kokapena)
			//VALUES (0, "Pepe", "hola")
			
			PreparedStatement s = (PreparedStatement) conexion.prepareStatement("INSERT INTO `aitorbd` (`kodea`, `izena`, `kokapena`)"
					+ " VALUES(1, `Pepa`, `Pepa`)");
			System.out.println("3");
			
			//s.setInt(1,dep.getKodea());
			System.out.println("3");
			s.setString(1,dep.getIzena());
			s.setString(2,dep.getIzena());
			s.setString(3,dep.getKokapena());
		
			System.out.println("4");
			s.executeUpdate();
			System.out.println("5");
			s.close();
			
		}catch(Exception e) {e.getMessage();}
		

	}
	
	public static ArrayList<Departamentua> geltokiGeltokiak(){
		ArrayList <Departamentua> Depart = new ArrayList<Departamentua>();
		Connection conexion = konexioa.getConnection();
		try {
			Statement s = conexion.createStatement();
	        
	        // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
	        String query = "select * from departamentu";
	        
	        ResultSet rs = s.executeQuery(query);
	        
	        // Se recorre el ResultSet, mostrando por pantalla los resultados.
	        while (rs.next()) {
	        	int Kodea=rs.getInt(1);
	        	 String Izena=rs.getString(2);
	        	 String Kokapena=rs.getString(3);
	        	 
	        	 System.out.println(Kodea + " " + Izena + " " +Kokapena);
	        	
//	        	 Geltokia biltegi=new Geltokia(cod_Parada,izena,kalea,latitudea,longitudea);
//	        	 geltokiDatuak.add(biltegi);
//	        	
	        	 }
			
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
		}
		return null;}
	
	public static void pepe() {
		String insertTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
                + "(?,?,?,?)";

        try {
        	Connection conexion = konexioa.getConnection();
        	Statement preparedStatement = conexion.createStatement();
            //dbConnection = getDBConnection();
            preparedStatement = conexion.prepareStatement(insertTableSQL);

            ((PreparedStatement) preparedStatement).setInt(1, 11);
            ((PreparedStatement) preparedStatement).setString(2, "mkyong");
            ((PreparedStatement) preparedStatement).setString(3, "system");
     

            // execute insert SQL stetement
          //  preparedStatement.executeUpdate();

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } 
	}

}
