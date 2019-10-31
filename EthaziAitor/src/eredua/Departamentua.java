package eredua;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Map.Entry;

import java.io.FileReader; 
import java.io.IOException;
import java.util.Iterator;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

	public static ArrayList<Departamentua> CSVDepartamentuakIrakurri (File fitxategiaDepartamentuak){

		//Bariableak
		ArrayList<Departamentua> arrayDepartamentuakCSV = new ArrayList<Departamentua>();
		String Kodea_string=null;
		int Kodea_int=0;
		String Izena=null;
		String Kokapena=null;

		String csvFile = fitxategiaDepartamentuak.getAbsolutePath();
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

	public static ArrayList<Departamentua> XMLDepartamentuakIrakurri(File fitxategiaDepartamentuak) {

		//Bariableak
		ArrayList<Departamentua> arrayDepartamentuaXML = new ArrayList<Departamentua>();
		String Kodea_string=null;
		int Kodea_int=0;
		String Izena=null;
		String Kokapena=null;
		//String xmlFile = ".\\src\\Oharrak.xml";
		int count = 0;

		try {

			File archivo = new File(fitxategiaDepartamentuak.getAbsolutePath());
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



	public static ArrayList<Departamentua> JSONDepartamentuakIrakurri () {

		ArrayList<Departamentua> arrayDepartamentuaJSON = new ArrayList<Departamentua>();

		JSONParser parser = new JSONParser();

		int count=0;
		String kodea_string=null;
		int kodea_int=0;
		String izena=null;
		String kokapena=null;

		try {

			Object obj = parser.parse(new FileReader(".\\src\\Departamentuak.json"));

			JSONObject jsonObject = (JSONObject) obj;

			// loop array
			JSONArray departamentu = (JSONArray) jsonObject.get("departamentubat");
			Iterator<String> iterator = departamentu.iterator();
			while (iterator.hasNext()) {
				if ((count==0)==true) {
					kodea_string = iterator.next();
					kodea_int = Integer.parseInt(kodea_string);
					count++;
				}if ((count==1)==true) {
					izena = iterator.next();
					count++;
				} 
				if (count==2) {
					kokapena = iterator.next();
					count++;
				}if (count==3) {
					Departamentua departamentua = new Departamentua(kodea_int, izena, kokapena);
					arrayDepartamentuaJSON.add(departamentua);
					count=0;
				}



			}

			departamentu = (JSONArray) jsonObject.get("departamentubi");
			iterator = departamentu.iterator();
			while (iterator.hasNext()) {
				if ((count==0)==true) {
					kodea_string = iterator.next();
					kodea_int = Integer.parseInt(kodea_string);
					count++;
				}if ((count==1)==true) {
					izena = iterator.next();
					count++;
				} 
				if (count==2) {
					kokapena = iterator.next();
					count++;
				}if (count==3) {
					Departamentua departamentua = new Departamentua(kodea_int, izena, kokapena);
					arrayDepartamentuaJSON.add(departamentua);
					count=0;
				}
			}

			departamentu = (JSONArray) jsonObject.get("departamentuhiru");
			iterator = departamentu.iterator();
			while (iterator.hasNext()) {
				if ((count==0)==true) {
					kodea_string = iterator.next();
					kodea_int = Integer.parseInt(kodea_string);
					count++;
				}if ((count==1)==true) {
					izena = iterator.next();
					count++;
				} 
				if (count==2) {
					kokapena = iterator.next();
					count++;
				}if (count==3) {
					Departamentua departamentua = new Departamentua(kodea_int, izena, kokapena);
					arrayDepartamentuaJSON.add(departamentua);
					count=0;
				}

			}


		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}



		return arrayDepartamentuaJSON;
	}







	//	public static ArrayList<Departamentua> JSONDepartamentuakIrakurri() {
	//		ArrayList<Departamentua> arrayDepartamentuaJSON = new ArrayList<Departamentua>();
	//
	//		JSONParser jsonParser = new JSONParser();
	//
	//		try (FileReader reader = new FileReader(".\\src\\Departamentuak.json")) {
	//			Object obj = jsonParser.parse(reader);
	//			JSONArray employeeList = (JSONArray) obj;
	//			employeeList.forEach(emp -> parseDepartamentuakObject((JSONObject) emp,arrayDepartamentuaJSON));
	//		} catch (FileNotFoundException e) {
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		} catch (ParseException e) {
	//			e.printStackTrace();
	//		}
	//
	//		return arrayDepartamentuaJSON;
	//
	//
	//	}
	//
	//	private static void parseDepartamentuakObject(JSONObject employee,ArrayList<Departamentua> arraylist) {
	//
	//		JSONObject departamentuaObject = (JSONObject) employee.get("departamentua");
	//
	//		String kodea_string = (String) departamentuaObject.get("kodea");
	//		String izena = (String) departamentuaObject.get("izena");
	//		String kokapena = (String) departamentuaObject.get("kokapena");
	//
	//		int kodea_int = Integer.parseInt(kodea_string);
	//
	//		//Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);
	//		Departamentua departamentua = new Departamentua(kodea_int, izena, kokapena);
	//		arraylist.add(departamentua);
	//
	//
	//	}


	//	public static void leerjsonDepartamentua () throws java.io.IOException {
	//		
	//		ArrayList<Departamentua> arrayDepartamentuak = new ArrayList<Departamentua>();
	//		JsonParser parser = new JsonParser();
	//		FileReader fr = new FileReader(".\\src\\Departamentuak.json");
	//		JsonElement datos = parser.parse(fr);
	//		arrayDepartamentuak = dumpJSONElement(datos);
	//		for (int i = 0; i < arrayDepartamentuak.size(); i++) {
	//			System.out.println(arrayDepartamentuak.get(i).toString());
	//			
	//		}
	//
	//	}


	//	public static ArrayList<Departamentua> dumpJSONElement(JsonElement elemento) {
	//		ArrayList<Departamentua> arrayDepartamentuak = new ArrayList<Departamentua>();
	//		Departamentua departamentua = new Departamentua(0, null, null);
	//		int count = 0;
	//		if (elemento.isJsonObject()) {
	//			System.out.println("Es objeto");
	//			JsonObject obj = elemento.getAsJsonObject();
	//			java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	//			java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	//			while (iter.hasNext()) {
	//				java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	//				System.out.println("Clave: " + entrada.getKey());
	//				System.out.println("Valor:");
	//				dumpJSONElement(entrada.getValue());
	//			}
	//
	//		} else if (elemento.isJsonArray()) {
	//			JsonArray array = elemento.getAsJsonArray();
	//			System.out.println("Es array. Numero de elementos: " + array.size());
	//			java.util.Iterator<JsonElement> iter = array.iterator();
	//			while (iter.hasNext()) {
	//				JsonElement entrada = iter.next();
	//				dumpJSONElement(entrada);
	//			}
	//		} else if (elemento.isJsonPrimitive()) {
	//			//System.out.println("Es primitiva");
	//			JsonPrimitive valor = elemento.getAsJsonPrimitive();
	////			if (valor.isBoolean()) {
	////				System.out.println("Es booleano: " + valor.getAsBoolean());
	////			}
	//			if (valor.isNumber()) {
	//				System.out.println("Es numero: " + valor.getAsNumber());
	//				departamentua.setKodea((int) valor.getAsNumber());
	//			} else if (valor.isString()) {
	//				count = 0;
	//				System.out.println("Es texto: " + valor.getAsString());
	//				if (count == 0) {
	//					departamentua.setIzena(valor.getAsString());
	//					count++;
	//				}else if (count == 1) {
	//					departamentua.setKokapena(valor.getAsString());
	//					count=0;
	//				}
	//			}
	//		} else if (elemento.isJsonNull()) {
	//			System.out.println("Es NULL");
	//		} else {
	//			System.out.println("Es otra cosa");
	//		}
	//		if (departamentua.getKodea()!=0 && departamentua.getIzena()!=null && departamentua.getKokapena()!=null) {
	//			arrayDepartamentuak.add(departamentua);
	//		}
	//		return arrayDepartamentuak;
	//	}



	public static ArrayList <Departamentua> DepartamentuakSelect() {

		ArrayList <Departamentua> departamentuak = new ArrayList<Departamentua>();
		int kodea=0;
		String izena=null;
		String kokapena=null;


		Connection Conexion = (Connection) konexioa.getConnection();
		Statement s =null;

		try {
			s =(Statement) Conexion.createStatement();

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT kodea,izena,kokapena FROM departamentu");
			while (rs.next()) {
				kodea = rs.getInt("zenbaki");
				izena = rs.getString("izena");
				kokapena = rs.getString("abizena");

				Departamentua departamentua = new Departamentua(kodea, izena, kokapena);
				departamentuak.add(departamentua);


			}
			System.out.println("Conexioa eginda Departamentuak Select");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return departamentuak;

	}

	public static void DepartamentuakIgo(ArrayList<Departamentua> depArrayList){ //Departamentu arrayList sartu bd
		Departamentua p = new Departamentua(0, null, null);
		Connection conexion = (Connection) konexioa.getConnection();
		try {
			Statement s = conexion.createStatement();
			for(int x=0;x<depArrayList.size();x++) {
				p = depArrayList.get(x);
				s.executeUpdate("INSERT INTO `departamentu` (`kodea`, `izena`, `kokapena`) VALUES"
						+ " (" + p.getKodea() + ", '" + p.getIzena() + "', '" + p.getKokapena() + "')");	
			}
			s.close();

			System.out.println("Konexioa Eginda Insert Departamentua");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}




}
