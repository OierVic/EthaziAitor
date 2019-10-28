package kontroladorea;

import eredua.Enplegatua;
import eredua.KonexioaMariaDB;
import eredua.konexioa;
import leihoak.OngiEtorria;
import leihoak.Kudeaketa;

public class Nagusia {

	public static void main(String[] args) {
		
		konexioa konexioa = new konexioa("ethazi");
		//KonexioaMariaDB konexioamariaDB = new KonexioaMariaDB();
		//konexioamariaDB.konektatu();
		
		OngiEtorria ongEtor = new OngiEtorria();
		ongEtor.setVisible(true);	

		Kudeaketa kudeaketa = new Kudeaketa();
		kudeaketa.setVisible(true);
//		ArrayList<Enplegatua> arrayEnplegatu = new ArrayList<Enplegatua>();
//		arrayEnplegatu = Enplegatua.CSVEnplegatuakIrakurri();
//		Enplegatua.EnplegatuakIgo(arrayEnplegatu);
		
		
	}

}
