
public class Zadatak {

	public String nazivZadatka;
	public boolean dizajn;
	public boolean programiranje;
	public boolean zauzetost;
	
	public Zadatak() {
		
	}
	
	public Zadatak(String nazivZadatka, boolean dizajn, boolean programiranje, boolean zauzetost) {
		this.nazivZadatka = nazivZadatka;
		this.dizajn = dizajn;
		this.programiranje = programiranje;
		this.zauzetost = zauzetost;
	}
	
	public String getNazivZadatka() {
		return nazivZadatka;
	}
	public void setNazivZadatka(String nazivZadatka) {
		this.nazivZadatka = nazivZadatka;
	}
	public boolean isDizajn() {
		return dizajn;
	}
	public void setDizajn(boolean dizajn) {
		this.dizajn = dizajn;
	}
	public boolean isProgramiranje() {
		return programiranje;
	}
	public void setProgramiranje(boolean programiranje) {
		this.programiranje = programiranje;
	}
	public boolean isZauzetost() {
		return zauzetost;
	}
	public void setZauzetost(boolean zauzetost) {
		this.zauzetost = zauzetost;
	}
	
}