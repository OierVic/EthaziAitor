package eredua;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Enplegatua {
	
	private int zenbaki;
	private String izena;
	private String abizenak;
	private int soldata;
	private String ardura;
	private String alta;
	private String depKod;
	
	
	public Enplegatua(int zenbaki, String izena, String abizenak, int soldata, String ardura, String alta,String depKod) {
		
		this.zenbaki = zenbaki;
		this.izena = izena;
		this.abizenak = abizenak;
		this.soldata = soldata;
		this.ardura = ardura;
		this.alta = alta;
		this.depKod = depKod;
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
	public int getSoldata() {
		return soldata;
	}
	public void setSoldata(int soldata) {
		this.soldata = soldata;
	}
	public String getArdura() {
		return ardura;
	}
	public void setArdura(String ardura) {
		this.ardura = ardura;
	}
	public String getAlta() {
		return alta;
	}
	public void setAlta(String alta) {
		this.alta = alta;
	}
	public String getDepKod() {
		return depKod;
	}
	public void setDepKod(String depKod) {
		this.depKod = depKod;
	}

	@Override
	public String toString() {
		return "Enplegatua [zenbaki=" + zenbaki + ", izena=" + izena + ", abizenak=" + abizenak + ", soldata=" + soldata
				+ ", ardura=" + ardura + ", alta=" + alta + ", depKod=" + depKod + "]";
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
		String abizena=null;
		String soldata_string=null;
		int soldata_int=0;
		String ardura=null;
		String alta=null;
		String depKod=null;

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
				abizena = datos[2];
				soldata_string = datos[3];
				ardura = datos[4];
				alta = datos[5];
				depKod = datos[6];

				//Imprime datos.
				System.out.println(datos[0] + " " + datos[1] + " " + datos[2]);

				zenbaki_int = Integer.parseInt(zenbaki_string);
				soldata_int = Integer.parseInt(soldata_string);

				Enplegatua enplegatua = new Enplegatua(zenbaki_int, izena, abizena, soldata_int, ardura, alta, depKod);
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

	
	public static ArrayList<Enplegatua> XMLEnplegatuaIrakurri() {

		//Bariableak
		ArrayList<Enplegatua> arrayEnplegatuaXML = new ArrayList<Enplegatua>();
		String zenbaki_string=null;
		int zenbaki_int=0;
		String izena=null;
		String abizena=null;
		String soldata_string=null;
		int soldata_int=0;
		String ardura=null;
		String alta=null;
		String depKod=null;
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
					abizena = document.getElementsByTagName("abizena").item(temp).getTextContent();
					soldata_string = document.getElementsByTagName("soldata").item(temp).getTextContent();
					ardura = document.getElementsByTagName("ardura").item(temp).getTextContent();
					alta = document.getElementsByTagName("alta").item(temp).getTextContent();
					depKod = document.getElementsByTagName("depKod").item(temp).getTextContent();


					zenbaki_int = Integer.parseInt(zenbaki_string);
					soldata_int = Integer.parseInt(soldata_string);

					Enplegatua enplegatua = new Enplegatua(zenbaki_int, izena, abizena, soldata_int, ardura, alta, depKod);
					
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
	
	
	
	
	
	
	


}
