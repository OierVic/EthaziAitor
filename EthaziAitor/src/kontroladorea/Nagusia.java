package kontroladorea;

import Oier.Kudeaketa;
import eredua.Enplegatua;
import eredua.KonexioaMariaDB;
import eredua.konexioa;
import leihoak.OngiEtorria;
import leihoak.DepartamentuakMenu;
import leihoak.EnplegatuakMenu;
import leihoak.FitxategiaAukeratuDepartamentuak;
import leihoak.FitxategiaAukeratuEnplegatuak;

public class Nagusia {

	public static void main(String[] args) {
		
		konexioa konexioa = new konexioa("ethazi");
		
		//Ventanas
		Kontroladorea kontroladorea = new Kontroladorea();
		OngiEtorria ongietorria = new OngiEtorria();
		
		FitxategiaAukeratuDepartamentuak fitxategiaukeratuDepartamentuak = new FitxategiaAukeratuDepartamentuak();
		FitxategiaAukeratuEnplegatuak fitxategiaukeratuEnplegatuak = new FitxategiaAukeratuEnplegatuak();
		
		DepartamentuakMenu departamentuakmenu = new DepartamentuakMenu();
		EnplegatuakMenu enplegatuakmenu = new EnplegatuakMenu();
		
//***********************************************************************************
		kontroladorea.ateraOngietorria(ongietorria);
		ongietorria.Kontroladorea(kontroladorea);
//***********************************************************************************
		kontroladorea.ateraFitxategiaAukeratuDepartamentuak(fitxategiaukeratuDepartamentuak);
		fitxategiaukeratuDepartamentuak.Kontroladorea(kontroladorea);
		
//***********************************************************************************
		kontroladorea.ateraFitxategiaAukeratuEnplegatuak(fitxategiaukeratuEnplegatuak);
		fitxategiaukeratuEnplegatuak.Kontroladorea(kontroladorea);
		
//***********************************************************************************
		kontroladorea.ateraDepartamentumenu(departamentuakmenu);
		departamentuakmenu.Kontroladorea(kontroladorea);
		
//***********************************************************************************
		kontroladorea.ateraEnplegatuakmenu(enplegatuakmenu);
		enplegatuakmenu.Kontroladorea(kontroladorea);
		
//***********************************************************************************


		ongietorria.setVisible(true);
		
//		ArrayList<Enplegatua> arrayEnplegatu = new ArrayList<Enplegatua>();
//		arrayEnplegatu = Enplegatua.CSVEnplegatuakIrakurri();
//		Enplegatua.EnplegatuakIgo(arrayEnplegatu);
		
		
	}

}
