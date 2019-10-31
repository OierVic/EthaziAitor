   package Diego;

import java.util.ArrayList;

import eredua.DepKonexio;
import eredua.Departamentua;
import eredua.Enplegatua;
import eredua.konexioa;

public class prueba {

	public static void main(String[] args) {
		
		konexioa konexioa = new konexioa("ethazi");
		
		ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();
		Departamentua d = new Departamentua(1, "hola", "Kruck");
		depArrayList.add(d);
		
		ArrayList<Enplegatua> enpArrayList = new ArrayList<Enplegatua>();
		Enplegatua en = new Enplegatua(2, "Hol2", "QUe", 3, "2020-04-21", 0, "z_ikasketaBurua");
		Enplegatua en2 = new Enplegatua(3, "Hol3", "QUe", 3, "2020-04-21", 0, "z_ikasketaBurua");
		enpArrayList.add(en);
		enpArrayList.add(en2);
		
		UpdatesDepart.gordeDepart(depArrayList);
		UpdatesEnple.gordeDepart(enpArrayList);
	}

}
