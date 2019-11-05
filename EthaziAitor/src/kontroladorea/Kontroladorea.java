package kontroladorea;

import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent;
import java.io.File;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import Oier.Kudeaketa;
import eredua.Departamentua;
import eredua.Enplegatua;
import leihoak.DepartamentuakMenu;
import leihoak.EnplegatuakMenu;
import leihoak.FitxategiaAukeratuDepartamentuak;
import leihoak.FitxategiaAukeratuEnplegatuak;
import leihoak.OngiEtorria;

public class Kontroladorea {
	
	//Leihoa deklaratu
	private OngiEtorria ongietorria ;
	
	private FitxategiaAukeratuDepartamentuak fitxategiaukeratuDepartamentuak;
	private FitxategiaAukeratuEnplegatuak fitxategiaukeratuEnplegatuak;
	
	private DepartamentuakMenu departamentuakmenu;
	private EnplegatuakMenu enplegatuakmenu;
	
	
	private File Fitxategia;
	private ArrayList<Departamentua> departamentuak = new ArrayList<Departamentua>();
	private ArrayList<Enplegatua> enplegatuak = new ArrayList<Enplegatua>();
	
	
	protected Object[][] datos;
	//Para que las ventanas aparezcan
	
		public void ateraOngietorria(OngiEtorria ongietorria) {
			this.ongietorria=ongietorria;
		}
		
		public void ateraFitxategiaAukeratuDepartamentuak(FitxategiaAukeratuDepartamentuak fitxategiaukeratuDepartamentuak) {
			this.fitxategiaukeratuDepartamentuak=fitxategiaukeratuDepartamentuak;
		}
		public void ateraFitxategiaAukeratuEnplegatuak(FitxategiaAukeratuEnplegatuak fitxategiaukeratuEnplegatuak) {
			this.fitxategiaukeratuEnplegatuak=fitxategiaukeratuEnplegatuak;
		}
		
		public void ateraDepartamentumenu(DepartamentuakMenu departamentuakmenu) {
			this.departamentuakmenu = departamentuakmenu;
		}
		public void ateraEnplegatuakmenu(EnplegatuakMenu enplegatuakmenu) {
			this.enplegatuakmenu = enplegatuakmenu;
		}
//------------------------------------------------------------------------------------------------
		//Leihotik pasatzeko
		public void fitxategiakaukeratuDepartLeihoa() {
			ongietorria.setVisible(false);
			fitxategiaukeratuDepartamentuak.setVisible(true);
			
		}
		public void fitxategiakaukeratuEnplegLeihoa() {
			ongietorria.setVisible(false);
			fitxategiaukeratuEnplegatuak.setVisible(true);
			
		}
		
		public void depatamentuMenura() {
			fitxategiaukeratuDepartamentuak.setVisible(false);
			departamentuakmenu.setVisible(true);
			departamentuak = Departamentua.DepartamentuakSelect();
			//departamentuakmenu.arrayDepartamentuaArtu(this.departamentuak);
			
			departamentuakmenu.sortuTaula(this.departamentuak);
			//departamentuakmenu.objectBidimensionaToDepartamentuak(this.departamentuak);
			//departamentuakmenu.taulaBete(this.departamentuak);
		}
		
		public void enplegatuMenura() {
			fitxategiaukeratuEnplegatuak.setVisible(false);
			enplegatuakmenu.setVisible(true);
		}
		
		
		
		public void AteraOngietorria() {

			ongietorria.setVisible(true);
			
		}
		
		public void AtzeraFitxategiakDepart() {
			fitxategiaukeratuDepartamentuak.setVisible(true);
		}
		public void AtzeraFitxategiakEnpleg() {
			fitxategiaukeratuEnplegatuak.setVisible(true);
		}
		
//------------------------------------------------------------------------------------------------

		public void fitxategiaGorde(File fitxategia) {
			this.Fitxategia = fitxategia;
			
		}
		
//		public void JtableSortu() {
//			
//			departamentuakmenu.taulaBete(departamentuak);
//		}
		
		//Esto en una ventana de una ventana
//		public ArrayList<Departamentua> returnDepartamentu(){
//			this.departamentuak = Departamentua.DepartamentuakSelect();
//			return this.departamentuak;
//		}
		
//		public Object[][] datuakSartu(){
//			this.departamentuak = Departamentua.DepartamentuakSelect();
//			return departamentuakmenu.objectBidimensionaToDepartamentuak(this.departamentuak);
//		}
		
		
		
		
		public void fitxategiaIgoDepartamentua(File fitxategiaLehioa) {
			
			//File fitxategia = this.Fitxategia;
			File fitxategia = fitxategiaLehioa;
			String nombreArchivo = fitxategia.getName();
			System.out.println(nombreArchivo);
			
			//String [] array = nombreArchivo.split(".");
			StringTokenizer st = new StringTokenizer(nombreArchivo, ".");
			String [] array = new String[2];
			array[0] = st.nextToken();
			array[1] = st.nextToken();
			System.out.println(array[0]);
			System.out.println(array[1]);

			String extension = array[1];
			
			if (extension.equals("csv")) {
				
				this.departamentuak = Departamentua.CSVDepartamentuakIrakurri(this.Fitxategia);
				Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(this.departamentuak);

			}
			else if (extension.equals("xml")) {
				
				this.departamentuak = Departamentua.XMLDepartamentuakIrakurri(this.Fitxategia);
				Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(this.departamentuak);


			}
			else if (extension.equals("json")) {
				
				//this.departamentuak = Departamentua.JSONDepartamentuakIrakurri();
				//Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(departamentuak);


			}
			
		}
		
		
		public void fitxategiaIgoEnplegatuak() {
			
			File fitxategia = this.Fitxategia;
			String nombreArchivo = fitxategia.getName();
			String [] array = nombreArchivo.split(".");
			String extension = array[array.length - 1];
			
			if (extension.equals("csv")) {
				
				this.enplegatuak = Enplegatua.CSVEnplegatuakIrakurri(fitxategia);
				Enplegatua.EnplegatuakIgo(this.enplegatuak);
			}
			else if (extension.equals("xml")) {
				
				this.enplegatuak = Enplegatua.XMLEnplegatuakIrakurri(fitxategia);
				Enplegatua.EnplegatuakIgo(this.enplegatuak);

			}
			else if (extension.equals("json")) {
				
				//this.enplegatuak = Enplegatua.JSONDepartamentuakIrakurri();
				//Enplegatua.EnplegatuakIgo(this.enplegatuak);

			}
			
		}
		
		
}
