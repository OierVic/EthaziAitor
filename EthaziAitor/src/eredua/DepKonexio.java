package eredua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;



public class DepKonexio {


	
//	public static ArrayList<Departamentua> geltokiGeltokiak(){
//		ArrayList <Departamentua> Depart = new ArrayList<Departamentua>();
//		Connection conexion = konexioa.getConnection();
//		try {
//			Statement s = conexion.createStatement();
//	        
//	        // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
//	        String query = "select * from departamentu";
//	        
//	        ResultSet rs = s.executeQuery(query);
//	        
//	        // Se recorre el ResultSet, mostrando por pantalla los resultados.
//	        while (rs.next()) {
//	        	int Kodea=rs.getInt(1);
//	        	 String Izena=rs.getString(2);
//	        	 String Kokapena=rs.getString(3);
//	        	 
//	        	 System.out.println(Kodea + " " + Izena + " " +Kokapena);
//	        	
////	        	 Geltokia biltegi=new Geltokia(cod_Parada,izena,kalea,latitudea,longitudea);
////	        	 geltokiDatuak.add(biltegi);
////	        	
//	        	 }
//			
//	    } catch (SQLException e) {
//	        System.out.println(e.getMessage());
//		}
//		return null;}
	
	
	public static void prueba(){ //funciona
		Connection conexion = (Connection) konexioa.getConnection();
		try {
			Statement s = conexion.createStatement();
	        
			s.executeUpdate("INSERT INTO `departamentu` (`kodea`, `izena`, `kokapena`) VALUES"
					+ " ('3', 'PEPO', 'CUlA')");
			
			s.close();
			
			System.out.println("Konexioa Eginda");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
		}
		}
	


}
