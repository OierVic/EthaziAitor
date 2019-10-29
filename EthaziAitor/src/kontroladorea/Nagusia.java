package kontroladorea;

import eredua.Enplegatua;
import eredua.KonexioaMariaDB;
import eredua.konexioa;
import leihoak.OngiEtorria;
import leihoak.FitxategiaAukeratu;
import leihoak.Kudeaketa;

public class Nagusia {

	public static void main(String[] args) {
		
		konexioa konexioa = new konexioa("ethazi");
		
		//Ventanas
		Kontroladorea kontroladorea = new Kontroladorea();
		OngiEtorria ongietorria = new OngiEtorria();
		FitxategiaAukeratu fitxategiaukeratu = new FitxategiaAukeratu();
		
//***********************************************************************************
		kontroladorea.ateraOngietorria(ongietorria);
		ongietorria.Kontroladorea(kontroladorea);
//***********************************************************************************
		kontroladorea.ateraFitxategiaAukeratu(fitxategiaukeratu);
		fitxategiaukeratu.Kontroladorea(kontroladorea);
		
//***********************************************************************************

		
		ongietorria.setVisible(true);
		
//		ArrayList<Enplegatua> arrayEnplegatu = new ArrayList<Enplegatua>();
//		arrayEnplegatu = Enplegatua.CSVEnplegatuakIrakurri();
//		Enplegatua.EnplegatuakIgo(arrayEnplegatu);
		
		
	}

}
