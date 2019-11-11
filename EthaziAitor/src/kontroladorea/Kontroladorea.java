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

import eredua.*;
import leihoak.*;
import kontroladorea.*;

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
	private ArrayList<String> ardurak = new ArrayList<String>();
	
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
			this.departamentuak = Departamentua.DepartamentuakSelect();
			this.departamentuakmenu.sortuTaulaDepart(departamentuak);
			
			this.fitxategiaukeratuDepartamentuak.setVisible(false);
			this.departamentuakmenu.setVisible(true);
			
			//departamentuakmenu.arrayDepartamentuaArtu(this.departamentuak);
			
			
			//departamentuakmenu.objectBidimensionaToDepartamentuak(this.departamentuak);
			//departamentuakmenu.taulaBete(this.departamentuak);
		}
		
		public void enplegatuMenura() {
			
			this.enplegatuak = Enplegatua.EnplegatuakSelect();
			this.enplegatuakmenu.sortuTaulaEnple(enplegatuak);
			
			this.fitxategiaukeratuEnplegatuak.setVisible(false);
			this.enplegatuakmenu.setVisible(true);
		}
		
		
		
		public void AteraOngietorria() {

			this.ongietorria.setVisible(true);
			
		}
		
		public void AtzeraFitxategiakDepart() {
			this.fitxategiaukeratuDepartamentuak.setVisible(true);
		}
		public void AtzeraFitxategiakEnpleg() {
			this.fitxategiaukeratuEnplegatuak.setVisible(true);
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
				System.out.println(fitxategia);
				this.departamentuak = Departamentua.CSVDepartamentuakIrakurri(this.Fitxategia);
				
				for (int i = 0; i < this.departamentuak.size()-1; i++) {
					System.out.println(this.departamentuak.get(i).toString());
				}
				
				Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(this.departamentuak);

			}
			else if (extension.equals("xml")) {
				System.out.println(fitxategia);
				this.departamentuak = Departamentua.XMLDepartamentuakIrakurri(this.Fitxategia);
				
				for (int i = 0; i < this.departamentuak.size()-1; i++) {
					System.out.println(this.departamentuak.get(i).toString());
				}
				
				Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(this.departamentuak);


			}
			else if (extension.equals("json")) {
				System.out.println(fitxategia);
				this.departamentuak = Departamentua.JSONDepartamentuakIrakurri(departamentuak,fitxategia);
				
				for (int i = 0; i < this.departamentuak.size()-1; i++) {
					System.out.println(this.departamentuak.get(i).toString());
				}
				
				Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.JSONDepartamentuakIrakurri();
				//Departamentua.DepartamentuakIgo(this.departamentuak);
				//this.departamentuak = Departamentua.DepartamentuakSelect();
				//departamentuakmenu.taulaBete(departamentuak);


			}
			
		}
		
		
		public void fitxategiaIgoEnplegatuak() {
			
			File fitxategia = this.Fitxategia;
			String nombreArchivo = fitxategia.getName();
			
			StringTokenizer st = new StringTokenizer(nombreArchivo, ".");
			String [] array = new String[2];
			array[0] = st.nextToken();
			array[1] = st.nextToken();
			System.out.println(array[0]);
			System.out.println(array[1]);

			String extension = array[1];
			
			if (extension.equals("csv")) {
				System.out.println(fitxategia);
				this.enplegatuak = Enplegatua.CSVEnplegatuakIrakurri(fitxategia);
				
				for (int i = 0; i < this.enplegatuak.size()-1; i++) {
					System.out.println(this.enplegatuak.get(i).toString());
				}
				
				Enplegatua.EnplegatuakIgo(this.enplegatuak);
			}
			else if (extension.equals("xml")) {
				System.out.println(fitxategia);
				this.enplegatuak = Enplegatua.XMLEnplegatuakIrakurri(fitxategia);
				
				for (int i = 0; i < this.enplegatuak.size()-1; i++) {
					System.out.println(this.enplegatuak.get(i).toString());
				}
				
				Enplegatua.EnplegatuakIgo(this.enplegatuak);

			}
			else if (extension.equals("json")) {
				System.out.println(fitxategia);
				this.enplegatuak = Enplegatua.JSONEnplegatuakIrakurri(fitxategia,enplegatuak);
				
				for (int i = 0; i < this.enplegatuak.size()-1; i++) {
					System.out.println(this.enplegatuak.get(i).toString());
				}
				
				Enplegatua.EnplegatuakIgo(this.enplegatuak);
				//this.enplegatuak = Enplegatua.JSONDepartamentuakIrakurri();
				//Enplegatua.EnplegatuakIgo(this.enplegatuak);

			}
			
		}
		
		//KONTSULTAK
		
		//DEPARTAMENTUAK
		public ArrayList<Departamentua> DepartamentuakSelect() {
			return Departamentua.DepartamentuakSelect();
		}
		public void DepartamentuaKendu(int kodea) {
			Departamentua.DepartamentuBatBakarrikEzabatu(kodea);
		}
		public void DepartamentuaIgo(Departamentua departamentua) {
			Departamentua.DepartamentuBatBakarrikIgo(departamentua);
		}
		public int DepartamentuKodeaAltuena() {
			return Departamentua.KodeAltuenaAtera();
		}
		
		//ENPLEGATUAK
		
		public void EnplegatuaIgo(Enplegatua enplegatua) {
			Enplegatua.EnplegatuBatIgo(enplegatua);
		}
		public int EnplegatuKodeaAltuena() {
			return Enplegatua.KodeAltuenaAtera();
		}
		public void EnplegatuEzabatu(int Zenbaki) {
			Enplegatua.EnplegatuBatBakarrikEzabatu(Zenbaki);
		}
//		public ArrayList<String> ArdurakLista() {
//			ardurak = Enplegatua.ardurakSelect();
//			return ardurak;
//		}
//		public ArrayList<String> ardurakLista(){
//			ardurak = Enplegatua.ardurakSelect();
//			
//			return ardurak;
//		}
		public ArrayList<String> ardurakLista(){
			//ardurak = Enplegatua.ardurakSelect();
			
			return Enplegatua.ardurakSelect();
		}
		
		
}
