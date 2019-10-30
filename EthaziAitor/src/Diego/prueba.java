   package Diego;

import java.util.ArrayList;

import eredua.DepKonexio;
import eredua.Departamentua;
import eredua.Enplegatua;
import eredua.konexioa;

public class prueba {

	public static void main(String[] args) {
		String json = "C:\\Diego Gomez\\Aitor\\Ethazi\\prueba.json";
		ArrayList<Departamentua> dA = new ArrayList<Departamentua>();
		
		
		dA = ReadJSON.read(json , dA);
		
		
		System.out.println(dA.size());
		
		
		for(int x=0;x<dA.size();x++) {
			System.out.println(dA.get(x));
			}	
		
		
	}

}
