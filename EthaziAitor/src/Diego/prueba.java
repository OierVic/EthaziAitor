   package Diego;

import java.util.ArrayList;

import eredua.DepKonexio;
import eredua.Departamentua;
import eredua.Enplegatua;
import eredua.konexioa;

public class prueba {

	public static void main(String[] args) {
		
		konexioa konexioa = new konexioa("ethazi");
		DepKonexio.kontsulaArdurak();
		
		
		//Departamentua prueba con arrayList--------------------------------------------------------------------
		Departamentua p = new Departamentua(11, "Dieg", "dawad");
		Departamentua p2 = new Departamentua(12, "Jua", "adeasfera");
		Departamentua p3 = new Departamentua(13, "Pedrp", "fsefsefs");
		
		ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();
		
		depArrayList.add(p);
		depArrayList.add(p2);
		depArrayList.add(p3);
		
		//DepKonexio.gordeDepart(depArrayList);
		//Enplegatua prueba con arrayList--------------------------------------------------------------------
		
		Enplegatua e = new Enplegatua(11, "Diego", "Gomez", 1234, "2018-04-21", 3, "z_ikasketaBurua");
		Enplegatua e2 = new Enplegatua(12, "Pepe", "Gomez", 1234, "2018-04-20", 5, "z_ikasketaBurua");
		Enplegatua e3 = new Enplegatua(13, "Hulk", "Gomez", 1234, "2018-04-23", 7, "z_ikasketaBurua");

		ArrayList<Enplegatua> enpArrayList = new ArrayList<Enplegatua>();
		
		enpArrayList.add(e);
		enpArrayList.add(e2);
		enpArrayList.add(e3);
		
		
		
		DepKonexio.gordeEnple(enpArrayList);
	

	}

}
