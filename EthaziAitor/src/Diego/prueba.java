   package Diego;

import java.util.ArrayList;

import eredua.DepKonexio;
import eredua.Departamentua;
import eredua.Enplegatua;
import eredua.konexioa;

public class prueba {

	public static void main(String[] args) {
		Departamentua dep = new Departamentua(1, "hl", "hola");
	ArrayList<Departamentua> depArrayList = null;
	ArrayList<Enplegatua> enpArrayList = null;
	String json = null;
	ReadDepartJSON.read(json, depArrayList);
	ReadEnpleJSON.read(json, enpArrayList);
	}

}
