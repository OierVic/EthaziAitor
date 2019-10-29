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
	
	private static ArrayList<Departamentua> depArrayList = new ArrayList<Departamentua>();
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Departamentua> read(String json)
	
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
            
            
            
            employeeList.forEach( emp -> {
				try {
					parsedepartObject( (JSONObject) emp );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} );
            
          

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
			
		
		return depArrayList;
	}

	
	public static void Gordearrayan(Departamentua dep) throws IOException {
		Departamentua departamentua = new Departamentua(0, null, null);

		departamentua.setKodea(dep.getKodea());
		departamentua.setIzena(dep.getIzena());
		departamentua.setKokapena(dep.getKokapena());
	
		depArrayList.add(departamentua);
	}
	


	private static void parsedepartObject(JSONObject employee) throws IOException{
		Departamentua dep = new Departamentua(0, null, null);
		//Get employee object within list
		JSONObject departamentua = (JSONObject) employee.get("departamentua");
		int Kodea=0;
		String Izena= "";
		String Kokapena = "";
		
		if(departamentua != null) {
		Kodea = Integer.parseInt((String) departamentua.get("Kodea"));
		Izena = (String) departamentua.get("Izena");	
		Kokapena = (String) departamentua.get("Kokapena");
		}

		dep.setKodea(Kodea);
		dep.setIzena(Izena);
		dep.setKokapena(Kokapena);
		Gordearrayan(dep);
	
	}
}
