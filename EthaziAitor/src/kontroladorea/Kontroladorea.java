package kontroladorea;

import leihoak.FitxategiaAukeratu;
import leihoak.OngiEtorria;

public class Kontroladorea {
	
	//Leihoa deklaratu
	private OngiEtorria ongietorria ;
	private FitxategiaAukeratu fitxategiaukeratu;
	
	
	//Para que las ventanas aparezcan
	
		public void ateraOngietorria(OngiEtorria ongietorria) {
			this.ongietorria=ongietorria;
		}
		public void ateraFitxategiaAukeratu(FitxategiaAukeratu fitxategiaukeratu) {
			this.fitxategiaukeratu=fitxategiaukeratu;
		}
//------------------------------------------------------------------------------------------------
		
		public void fitxategiakaukeratu() {
			ongietorria.setVisible(false);
			fitxategiaukeratu.setVisible(true);
			
		}
		
		public void AteraOngietorria() {

			ongietorria.setVisible(true);
			
		}
		
		
		
}
