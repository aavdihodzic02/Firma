
public class Korisnik extends Ponasanja {

	String ime;
	String prezime;
	private String password;
	String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Korisnik(String ime, String prezime, String password, String username) {
		this.ime = ime;
		this.prezime = prezime;
		this.password = password;
		this.username = username;
	}

	public void provjeraKorisnika(Korisnik korisnik) {
		int brojac = 0;
		int brojac2 = 0;
		System.err.println("Pocinjemo provjeru");
		System.out.println();
		if (korisnik.ime.equals("admin"))
			if (korisnik.prezime.equals("admin"))
				if (korisnik.password.equals("admin"))
					if (korisnik.username.equals("admin")) {
						System.out.println(
								"_________________________________________________________________________________________________________________________________________________________________________________-");
						System.out.println("Dobro dosli, administrator");
						Main.meni();
						brojac++;
					}

		for (int i = 0; i < developeri.size(); i++) {
			if (developeri.get(i).ime.equals(ime))
				if (developeri.get(i).prezime.equals(prezime))
					if (developeri.get(i).password.equals(password)) {
						System.out.println(
								"_________________________________________________________________________________________________________________________________________________________________________________-");
						System.out.println("Dobro dosli");
						Main.meni();
						brojac++;
					}
		}

		do {
			if (brojac != 0) {
				Main.meni();
			}
			if (brojac == brojac2)
				break;
		} while (true);

		System.out.println("Unos pogresan");
		System.out.println();
		System.out.println("......");
		Main.registracijaKorisnika();
	}

}
