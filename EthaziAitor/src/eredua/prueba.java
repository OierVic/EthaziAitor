package eredua;

import java.io.IOException;
import java.util.ArrayList;

public class prueba {
	
	public static void main(String[] args) throws IOException {
		
		Departamentua.leerjsonDepartamentua();
		ArrayList<Departamentua> arrayDep = new ArrayList<Departamentua>();
		arrayDep = Departamentua.JSONDepartamentuakIrakurri();
		for (int i = 0; i < arrayDep.size(); i++) {
			System.out.println(arrayDep.get(i).toString());
		}
		
	}
}
