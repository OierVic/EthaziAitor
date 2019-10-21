package eredua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DepEmpleKudeatu {
	
	//static Departamentua oharrak = new Departamentua();
	static String fichero = "C:\\Diego\\Depart.txt";
	
	public static ArrayList<Departamentua> IrakurriDepartamentua() throws IOException { // 1. Fitxategia irakurtzen da eta arrayList-ean sartzen dira oharrak, arrayList-a berrabiarasten da
		  String katea;
	      String[] kateArray = new String[7];
	      int kant=1;
	  
	      FileReader f = new FileReader(fichero);
	      BufferedReader b = new BufferedReader(f);
	      ArrayList<Departamentua> DepartList = new ArrayList<Departamentua>();
	  
	      while((katea = b.readLine())!=null) {
	    	  if(katea != "") {
	        kateArray[kant] = katea.substring(katea.indexOf(":")+1);  //Nahi diren datuak arrtzeko eta array-ean saratzeko
	        
	        if(kant > 5 && (katea = b.readLine())!=null) {  //Bloke oso artzerakoan, ArrayListean
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
