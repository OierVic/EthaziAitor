package Diego;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import eredua.Departamentua;

public class WriteJSON
{
    @SuppressWarnings("unchecked")
	
   
    public static void write(String json, ArrayList<Departamentua> depArrayList){
    	//First Employee
    	JSONArray employeeList = new JSONArray();
    	
    	for(int x=0;x<depArrayList.size();x++) {
			  System.out.println(depArrayList.get(x));
			
    	JSONObject deptBlokea = new JSONObject();
    	deptBlokea.put("Kodea", depArrayList.get(x).getKodea());
    	deptBlokea.put("Izena", depArrayList.get(x).getIzena());
    	deptBlokea.put("Kokapena", depArrayList.get(x).getKokapena());
    	
    	JSONObject employeeObject = new JSONObject(); 
    	employeeObject.put("departamentua", deptBlokea);
    	
    	
    	//Add employees to list
    	
    	System.out.println(x);
    	employeeList.add(deptBlokea);
    	
    
    	
    	//Write JSON file
    	try (FileWriter file = new FileWriter(json)) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    	}
    }
}
