package Diego;

import java.util.ArrayList;

import eredua.Departamentua;

public class pruebaJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String json = "C:\\Diego Gomez\\Aitor\\Ethazi\\Depart.json";
		
		Departamentua dep = new Departamentua(0, null, null);
		ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();

		 
		ReadJSON.read(json);
		
//		WriteJSON.write(json);
//		
//		ReadJSON.read(json);

	}

}
