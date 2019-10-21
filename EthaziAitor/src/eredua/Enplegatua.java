package eredua;

public class Enplegatua {
	public Enplegatua() {
		super();
	}
	public Enplegatua(int zenbaki, String izena, String abizenak, int soldata, String ardura, String alta,
			String depKod) {
		super();
		this.zenbaki = zenbaki;
		this.izena = izena;
		this.abizenak = abizenak;
		this.soldata = soldata;
		this.ardura = ardura;
		this.alta = alta;
		this.depKod = depKod;
	}
	
	private int zenbaki;
	private String izena;
	private String abizenak;
	private int soldata;
	private String ardura;
	private String alta;
	private String depKod;
	
	
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


}
