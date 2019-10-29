package Diego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eredua.Departamentua;

public class ReadJSON
{
	
	private static Departamentua depart = new Departamentua(0, null, null);
	private static ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();
	
	@SuppressWarnings("unchecked")
	public static void read(String json)
	
	{
		
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader(json))
		{
			//Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
            //Iterate over employee array
            
            
            
            employeeList.forEach( emp -> parsedepartObject( (JSONObject) emp ) );
            
          

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		System.out.println("hola buenas");
		for(int x=0;x<depArrayList.size();x++) {
			  System.out.println(depArrayList.get(x));
			}		
		
		
	}

	

	

	private static void parsedepartObject(JSONObject employee){
		
		//Get employee object within list
		JSONObject departamentua = (JSONObject) employee.get("employee");
		int Kodea=0;
		String Izena= "";
		String Kokapena = "";
		
		//Get employee first name
		if(departamentua != null) {
			
		System.out.println("hola");
		Kodea = (int) departamentua.get("Kodea");
		
		System.out.println(Kodea);
		
		
		//Get employee last name
		Izena = (String) departamentua.get("Izena");	
		
		System.out.println(Izena);
		
		//Get employee website name
		Kokapena = (String) departamentua.get("Kokapena");
		
		System.out.println(Kokapena);
		
		
		for(int x=0;x<depArrayList.size();x++) {
			  System.out.println(depArrayList.get(x));
			}	
		
		
		
		}
		System.out.println("________________________________________________________________________________________________________________________________");
		depart.setKodea(Kodea);
		depart.setIzena(Izena);
		depart.setKokapena(Kokapena);
		depArrayList.add(depart);
	}
}
