package eredua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Enplegatua {
	
	public Enplegatua() {
		super();
	}



	private int zenbaki;
	private String izena;
	private String abizenak;
	private double soldata;
	private String alta;
	private int depKod;
	private String arduraMota;
	
	
	public Enplegatua(int zenbaki, String izena, String abizenak, double soldata, String alta, int depKod,String arduraMota) {
		
		this.zenbaki = zenbaki;
		this.izena = izena;
		this.abizenak = abizenak;
		this.soldata = soldata;
		this.alta = alta;
		this.depKod = depKod;
		this.arduraMota = arduraMota;
	}

	public int getZenbaki() {
		return zenbaki;
	}

	public void setZenbaki(int zenbaki) {
		this.zenbaki = zenbaki;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizenak() {
		return abizenak;
	}

	public void setAbizenak(String abizenak) {
		this.abizenak = abizenak;
	}

	public double getSoldata() {
		return soldata;
	}

	public void setSoldata(double soldata) {
		this.soldata = soldata;
	}
	
	public String getAlta() {
		return alta;
	}

	public void setAlta(String alta) {
		this.alta = alta;
	}

	public int getDepKod() {
		return depKod;
	}

	public void setDepKod(int depKod) {
		this.depKod = depKod;
	}

	public String getArduraMota() {
		return arduraMota;
	}

	public void setArduraMota(String arduraMota) {
		this.arduraMota = arduraMota;
	}

	@Override
	public String toString() {
		return "Enplegatua [zenbaki=" + zenbaki + ", izena=" + izena + ", abizenak=" + abizenak + ", soldata=" + soldata
				+ ", alta=" + alta + ", depKod=" + depKod + ", arduraMota=" + arduraMota + "]";
	}
	
	
	
	
	public static void reiniciarArray (String [] array) {
		for (int i = 0; i < array.length-1; i++) {
			array[i]=null;
		}
	}
	
	
	
	//Enplegatua CSVtik irakurtzeko
	
	public static ArrayList<Enplegatua> CSVEnplegatuakIrakurri (){

		//Bariableak
		ArrayList<Enplegatua> arrayEnplegatuakCSV = new ArrayList<Enplegatua>();
		String zenbaki_string=null;
		int zenbaki_int=0;
		String izena=null;
		String abizenak=null;
		String soldata_string=null;
		double soldata_double=0.00;
		String ardura=null;
		String alta=null;
		String depKod_string=null;
		int depKod_int=0;

		String csvFile = ".\\src\\Enplegatuak.csv";
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
				zenbaki_string = datos[0];
				izena = datos[1];
				abizenak = datos[2];
				soldata_string = datos[3];
				alta = datos[4];
				depKod_string = datos[5];
				ardura = datos[6];


				//Imprime datos.
				System.out.println(datos[0] + " " + datos[1] + " " + datos[2]+ " " + datos[3]+ " " + datos[4]+ " " + datos[5]+ " " + datos[6]);

				zenbaki_int = Integer.parseInt(zenbaki_string);
				soldata_double = Double.parseDouble(soldata_string);
				depKod_int = Integer.parseInt(depKod_string);
				
				Enplegatua enplegatua = new Enplegatua(zenbaki_int, izena, abizenak, soldata_double, alta, depKod_int, ardura);
				arrayEnplegatuakCSV.add(enplegatua);

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


		return arrayEnplegatuakCSV;

	}
	
	
	//Enplegatua XMLtik irakurtzeko

	
	public static ArrayList<Enplegatua> XMLEnplegatuakIrakurri() {

		//Bariableak
		ArrayList<Enplegatua> arrayEnplegatuaXML = new ArrayList<Enplegatua>();
		String zenbaki_string=null;
		int zenbaki_int=0;
		String izena=null;
		String abizenak=null;
		String soldata_string=null;
		double soldata_double=0.00;
		String ardura=null;
		String alta=null;
		String depKod_string=null;
		int depKod_int=0;
		
		//String xmlFile = ".\\src\\Oharrak.xml";
		int count = 0;

		try {

			File archivo = new File(".\\src\\Enplegatuak.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
			NodeList listaEnplegatua = document.getElementsByTagName("enplegatua");
			for (int temp = 0; temp < listaEnplegatua.getLength(); temp++) {
				Node nodo = listaEnplegatua.item(temp);
				System.out.println("Elemento:" + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;



					zenbaki_string = document.getElementsByTagName("kodea").item(temp).getTextContent();
					izena = document.getElementsByTagName("izena").item(temp).getTextContent();
					abizenak = document.getElementsByTagName("abizena").item(temp).getTextContent();
					soldata_string = document.getElementsByTagName("soldata").item(temp).getTextContent();
					alta = document.getElementsByTagName("alta").item(temp).getTextContent();
					depKod_string = document.getElementsByTagName("depKod").item(temp).getTextContent();
					ardura = document.getElementsByTagName("ardura").item(temp).getTextContent();


					zenbaki_int = Integer.parseInt(zenbaki_string);
					soldata_double = Double.parseDouble(soldata_string);
					depKod_int = Integer.parseInt(depKod_string);
					
					Enplegatua enplegatua = new Enplegatua(zenbaki_int, izena, abizenak, soldata_double, alta, depKod_int, ardura);
					
					System.out.println(enplegatua.toString());
					arrayEnplegatuaXML.add(enplegatua);
					//count++;






				}
				//if (count==6) break;
				//if (nodo.getNodeName().equals("oharra")) break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayEnplegatuaXML;


	}
	
	
	
	
	//Enplegatua JSONtik irakurtzeko
	
	public static ArrayList<Enplegatua> JSONEnplegatuakIrakurri() {
		ArrayList<Enplegatua> arrayEnplegatuakJSON = new ArrayList<Enplegatua>();

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(".\\src\\Enplegatuak.json")) {
			Object obj = jsonParser.parse(reader);
			JSONArray employeeList = (JSONArray) obj;
			employeeList.forEach(emp -> parseEnplegatuakObject((JSONObject) emp,arrayEnplegatuakJSON));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return arrayEnplegatuakJSON;
		
		
	}

	private static void parseEnplegatuakObject(JSONObject employee,ArrayList<Enplegatua> arraylist) {

		JSONObject departamentuaObject = (JSONObject) employee.get("enplegatua");

		String zenbaki_string = (String) departamentuaObject.get("zenbaki");
		String izena = (String) departamentuaObject.get("izena");
		String abizenak = (String) departamentuaObject.get("abizenak");
		String soldata_string = (String) departamentuaObject.get("soldata");
		String alta = (String) departamentuaObject.get("alta");
		String depKod_string = (String) departamentuaObject.get("depKod");
		String ardura = (String) departamentuaObject.get("ardura");
		
		int zenbaki_int = Integer.parseInt(zenbaki_string);
		double soldata_double = Double.parseDouble(soldata_string);
		int depKod_int = Integer.parseInt(depKod_string);

		//Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);
		Enplegatua enplegatu = new Enplegatua(zenbaki_int, izena, abizenak, soldata_double, alta, depKod_int, ardura);
		arraylist.add(enplegatu);
		
		
	}
	
	
	
	public static void EnplegatuakIgo (ArrayList<Enplegatua> arraylistEnplegatua) {

		Connection conexion = (Connection) konexioa.getConnection();
		try {
			Statement s = conexion.createStatement();
			
			for (int i = 0; i < arraylistEnplegatua.size() - 1; i++) {
			
			s.executeUpdate("INSERT INTO `enplegatu` (`zenbaki`, `izena`, `abizena`, `soldata`, `alta`, `departamentu_kodea`, `ardurak_arduraMota`) VALUES"
					+ " ("+ arraylistEnplegatua.get(i).getZenbaki() +", '"+ arraylistEnplegatua.get(i).getIzena() +"', '"+ arraylistEnplegatua.get(i).getAbizenak() +"', "+ arraylistEnplegatua.get(i).getSoldata() +",'"+ arraylistEnplegatua.get(i).getAlta() +"','"+ arraylistEnplegatua.get(i).getDepKod() +"', '"+ arraylistEnplegatua.get(i).getArduraMota() +"')");
					
			}
			s.close();

			System.out.println("Konexioa Eginda");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	}
	
	
	
	
	


}
