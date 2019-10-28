package Diego;


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSON
{
    @SuppressWarnings("unchecked")
	public static void write()
    {
    	//First Employee
    	JSONObject employeeDetails = new JSONObject();
    	employeeDetails.put("firstName", "Lokesh");
    	employeeDetails.put("lastName", "Gupta");
    	employeeDetails.put("website", "howtodoinjava.com");
    	
    	JSONObject employeeObject = new JSONObject(); 
    	employeeObject.put("employee", employeeDetails);
    	
    	//Second Employee
    	JSONObject employeeDetails2 = new JSONObject();
    	employeeDetails2.put("firstName", "Brian2");
    	employeeDetails2.put("lastName", "Schultz");
    	employeeDetails2.put("website", "example.com");
    	
    	JSONObject employeeObject2 = new JSONObject(); 
    	employeeObject2.put("employee", employeeDetails2);
    	
    	//Add employees to list
    	JSONArray employeeList = new JSONArray();
    	employeeList.add(employeeObject);
    	employeeList.add(employeeObject2);
    	
    	//Write JSON file
    	try (FileWriter file = new FileWriter("C:\\Diego\\prueba.json")) {

            file.write(employeeList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
