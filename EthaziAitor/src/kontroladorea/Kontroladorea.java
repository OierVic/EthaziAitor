package kontroladorea;

import java.io.File;

import Oier.Kudeaketa;
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
		
		
		
		
		
		
}
