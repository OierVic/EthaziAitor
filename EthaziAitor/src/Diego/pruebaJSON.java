package Diego;

import java.util.ArrayList;

import eredua.Departamentua;

public class pruebaJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String json = "C:\\Diego Gomez\\Aitor\\Ethazi\\Depart.json";
		
		
		ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();

		 
		depArrayList = ReadJSON.read(json);
		
		
		System.out.println("hola buenas2");
		for(int x=0;x<depArrayList.size();x++) {
			  System.out.println(depArrayList.get(x));
			}	
		
		
	System.out.println("------------------------------------------------------------------");	
	Departamentua d = new Departamentua(4,"Pepo", "Pipo");
	depArrayList.add(d);
		
		//WriteJSON.write(json, depArrayList);
//		
//		ReadJSON.read(json);

	}

}
