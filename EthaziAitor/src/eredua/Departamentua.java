package eredua;

public class Departamentua {
	
	
	public Departamentua(int kodea, String izena, String kokapena) {
		super();
		Kodea = kodea;
		Izena = izena;
		Kokapena = kokapena;
	}
	
	public Departamentua() {
		// TODO Auto-generated constructor stub
	}

	private int Kodea;
	private String Izena;
	private String Kokapena;
	
	
	public int getKodea() {
		return Kodea;
	}
	public void setKodea(int kodea) {
		Kodea = kodea;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public String getKokapena() {
		return Kokapena;
	}
	public void setKokapena(String kokapena) {
		Kokapena = kokapena;
	}
	
	public static Departamentua gordeDepart(int kod, String izen, String kokapen) {
		Departamentua d = new Departamentua(kod,izen,kokapen);
		return d;
	}

}
