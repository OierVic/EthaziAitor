package eredua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Departamentua {
	
	private int Kodea;
	private String Izena;
	private String Kokapena;
		
	public Departamentua(int kodea, String izena, String kokapena) {
		Kodea = kodea;
		Izena = izena;
		Kokapena = kokapena;
	}

	
	public int getKodea() {
		return Kodea;
	}
	public void setKodea(int kodea) {
		Kodea = kodea;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getKokapena() {
		return Kokapena;
	}
	public void setKokapena(String kokapena) {
		Kokapena = kokapena;
	}
	
	public static Departamentua gordeDepart(int kod, String izen, String kokapen) {
		Departamentua d = new Departamentua(kod,izen,kokapen);
		return d;
	}

	@Override
	public String toString() {
		return "Departamentua [Kodea=" + Kodea + ", Izena=" + Izena + ", Kokapena=" + Kokapena + "]";
	}
	
	
	public static ArrayList<Departamentua> IrakurriDepartamentua() throws IOException { // 1. Fitxategia irakurtzen da eta arrayLis. DepartList Gorde.
		  String katea;
	      String[] kateArray = new String[7];
	      int kant=1;

	      FileReader f = new FileReader(".\\src\\Depart.txt");
	      BufferedReader b = new BufferedReader(f);
	      ArrayList<Departamentua> DepartList = new ArrayList<Departamentua>();
	  
	      while((katea = b.readLine())!=null) {
	    	  if(katea != "") {
	        kateArray[kant] = katea.substring(katea.indexOf(":")+1);  //Nahi diren datuak arrtzeko eta array-ean saratzeko
	        
	        if(kant > 2 && (katea = b.readLine())!=null) {  //Bloke oso artzerakoan, ArrayListean
	        	DepartList.add(Departamentua.gordeDepart(Integer.parseInt(kateArray[1]), kateArray[2], kateArray[3]));

	        	 kant=0;
	        }
	        kant++;
	    	  }
	      }   
	      b.close();  
	      
	    
	    	  System.out.println(DepartList);
	    	 
	    	
	     

	      return DepartList;
	}
	

}
