package eredua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Departamentua {
	
	private int Kodea;
	private String Izena;
	private String Kokapena;
		
	public Departamentua(int kodea, String izena, String kokapena) {
		this.Kodea = kodea;
		this.Izena = izena;
		this.Kokapena = kokapena;
	}

	
	public int getKodea() {
		return Kodea;
	}
	public void setKodea(int kodea) {
		Kodea = kodea;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getKokapena() {
		return Kokapena;
	}
	public void setKokapena(String kokapena) {
		Kokapena = kokapena;
	}

	@Override
	public String toString() {
		return "Departamentua [Kodea=" + Kodea + ", Izena=" + Izena + ", Kokapena=" + Kokapena + "]";
	}
	
	
	
	
	public static void reiniciarArray (String [] array) {
		for (int i = 0; i < array.length-1; i++) {
			array[i]=null;
		}
	}
	
	
	
	
	//Departamentua CSVtik irakurtzeko
	
	public static ArrayList<Departamentua> CSVDepartamentuakIrakurri (){

		//Bariableak
		ArrayList<Departamentua> arrayDepartamentuakCSV = new ArrayList<Departamentua>();
		String Kodea_string=null;
		int Kodea_int=0;
		String Izena=null;
		String Kokapena=null;

		String csvFile = ".\\src\\Departamentuak.csv";
		BufferedReader br = null;
		String line = "";
		//Se define separador ","
		String cvsSplitBy = ",";
		try {
			br = new BufferedReader(new FileReader(csvFile));
			//Lehengo linea ez irakurtzeko
			br.readLine();
			while ((line = br.readLine()) != null) {                
				String[] datos = line.split(cvsSplitBy);
				Kodea_string = datos[0];
				Izena = datos[1];
				Kokapena = datos[2];

				//Imprime datos.
				System.out.println(datos[0] + " " + datos[1] + " " + datos[2]);

				Kodea_int = Integer.parseInt(Kodea_string);    

				Departamentua departamentua = new Departamentua(Kodea_int, Izena, Kokapena);
				arrayDepartamentuakCSV.add(departamentua);

				reiniciarArray(datos);

			}



		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


		return arrayDepartamentuakCSV;

	}
	
	
	
	
	//Departamentua XMLtik irakurtzeko
	
	public static ArrayList<Departamentua> XMLDepartamentuakIrakurri() {

		//Bariableak
		ArrayList<Departamentua> arrayDepartamentuaXML = new ArrayList<Departamentua>();
		String Kodea_string=null;
		int Kodea_int=0;
		String Izena=null;
		String Kokapena=null;
		//String xmlFile = ".\\src\\Oharrak.xml";
		int count = 0;

		try {

			File archivo = new File(".\\src\\Departamentuak.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
			NodeList listaDepartamentua = document.getElementsByTagName("departamentua");
			for (int temp = 0; temp < listaDepartamentua.getLength(); temp++) {
				Node nodo = listaDepartamentua.item(temp);
				System.out.println("Elemento:" + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;



					Kodea_string = document.getElementsByTagName("kodea").item(temp).getTextContent();
					Izena = document.getElementsByTagName("izena").item(temp).getTextContent();
					Kokapena = document.getElementsByTagName("kokapena").item(temp).getTextContent();


					Kodea_int = Integer.parseInt(Kodea_string);

					Departamentua departamentua = new Departamentua(Kodea_int, Izena, Kokapena);
					System.out.println(departamentua.toString());
					arrayDepartamentuaXML.add(departamentua);
					//count++;






				}
				//if (count==6) break;
				//if (nodo.getNodeName().equals("oharra")) break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayDepartamentuaXML;


	}
	
	
	
	//Departamentua JSONetik irakurtzeko

	
	public static ArrayList<Departamentua> JSONDepartamentuakIrakurri() {
		ArrayList<Departamentua> arrayDepartamentuaJSON = new ArrayList<Departamentua>();

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(".\\src\\Departamentuak.json")) {
			Object obj = jsonParser.parse(reader);
			JSONArray employeeList = (JSONArray) obj;
			employeeList.forEach(emp -> parseDepartamentuakObject((JSONObject) emp,arrayDepartamentuaJSON));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return arrayDepartamentuaJSON;
		
		
	}

	private static void parseDepartamentuakObject(JSONObject employee,ArrayList<Departamentua> arraylist) {

		JSONObject departamentuaObject = (JSONObject) employee.get("departamentua");

		String kodea_string = (String) departamentuaObject.get("kodea");
		String izena = (String) departamentuaObject.get("izena");
		String kokapena = (String) departamentuaObject.get("kokapena");

		int kodea_int = Integer.parseInt(kodea_string);

		//Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);
		Departamentua departamentua = new Departamentua(kodea_int, izena, kokapena);
		arraylist.add(departamentua);
		
		
	}
	
	
	

}
