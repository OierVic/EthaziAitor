package kontroladorea;

import java.io.File;

import leihoak.FitxategiaAukeratu;
import leihoak.Kudeaketa;
import leihoak.OngiEtorria;

public class Kontroladorea {
	
	//Leihoa deklaratu
	private OngiEtorria ongietorria ;
	private FitxategiaAukeratu fitxategiaukeratu;
	private Kudeaketa kudeaketa;
	private File Fitxategia;
	
	//Para que las ventanas aparezcan
	
		public void ateraOngietorria(OngiEtorria ongietorria) {
			this.ongietorria=ongietorria;
		}
		public void ateraFitxategiaAukeratu(FitxategiaAukeratu fitxategiaukeratu) {
			this.fitxategiaukeratu=fitxategiaukeratu;
		}
		public void ateraKudeatu(Kudeaketa kudeaketa) {
			this.kudeaketa=kudeaketa;
		}
//------------------------------------------------------------------------------------------------
		
		public void fitxategiakaukeratuLeihoa() {
			ongietorria.setVisible(false);
			fitxategiaukeratu.setVisible(true);
			
		}
		public void KudeatuLeihoa() {
			fitxategiaukeratu.setVisible(false);
			kudeaketa.setVisible(true);
			
		}
		
		public void fitxategiaGorde(File fitxategia) {
			this.Fitxategia = fitxategia;
			
		}
		
		
		public void AteraOngietorria() {

			ongietorria.setVisible(true);
			
		}
		
		
		
}
