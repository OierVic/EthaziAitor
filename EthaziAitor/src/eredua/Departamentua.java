package eredua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Departamentua {
	
	private int Kodea;
	private String Izena;
	private String Kokapena;
		
	public Departamentua(int kodea, String izena, String kokapena) {
		this.Kodea = kodea;
		this.Izena = izena;
		this.Kokapena = kokapena;
	}

	
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

	@Override
	public String toString() {
		return "Departamentua [Kodea=" + Kodea + ", Izena=" + Izena + ", Kokapena=" + Kokapena + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
