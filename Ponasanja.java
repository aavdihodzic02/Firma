import java.util.ArrayList;
import java.util.Scanner;

public class Ponasanja {

	static ArrayList<Developer> developeri = new ArrayList<Developer>();
	static ArrayList<Dizajner> dizajneri = new ArrayList<Dizajner>();
	static ArrayList<Zadatak> zadaci = new ArrayList<Zadatak>();

	static Scanner unos = new Scanner(System.in);

	public Ponasanja() {

	}

	public void dodavanjeDevelopera() {

		String imeDevelopera = "";
		do {
			System.out.println("Unesite ime developera");
			try {
				imeDevelopera = unos.next();
				if (imeDevelopera.length() < 4)
					throw new ImeNedovoljnoException();
			} catch (ImeNedovoljnoException e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String prezimeDevelopera = "";
		do {
			System.out.println("Unesite prezime developera");
			try {
				prezimeDevelopera = unos.next();
				if (prezimeDevelopera.length() < 4)
					throw new PrezimeNedovoljnoException();
			} catch (PrezimeNedovoljnoException e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String passwordDevelopera = "";
		do {
			System.out.println("Unesite password");
			try {
				passwordDevelopera = unos.next();
				if (provjeraLetters(passwordDevelopera) == false)
					throw new PasswordNedovoljanException();
			} catch (PasswordNedovoljanException e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String imeZadatka;
		do {
			System.out.println("Unesite ime zadatka dodijeljenog developeru, ako nema zadatka upisite '.'");
			try {
				imeZadatka = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String programskiJezik;
		do {
			System.out.println("Za koji programski jezik je developer specijaliziran?");
			try {
				programskiJezik = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		Integer brojac = null;
		if (!imeZadatka.equals(".")) {
			for (int i = 0; i < zadaci.size(); i++) {
				if (imeZadatka.equals(zadaci.get(i).nazivZadatka)) {
					brojac = i;
					break;
				}
			}

			if (brojac == null) {
				System.out.println("Zadatak kojeg ste unijeli ne postoji");
				Main.meni();
			}
		}

		Developer developer = new Developer();

		if (imeZadatka.equals(".")) {
			developer.ime = imeDevelopera;
			developer.prezime = prezimeDevelopera;
			developer.password = passwordDevelopera;
			developer.zadatak = null;
			developer.programskiJezik = programskiJezik;
		} else {
			developer.ime = imeDevelopera;
			developer.prezime = prezimeDevelopera;
			developer.password = passwordDevelopera;
			developer.zadatak = zadaci.get(brojac);
			developer.programskiJezik = programskiJezik;
		}

		developeri.add(developer);

	}

	public void dodavanjeZadatka() {

		String imeZadatka;
		do {
			System.out.println("Unesite ime zadatka");
			try {
				imeZadatka = unos.next();

				for (int i = 0; i < zadaci.size(); i++) {
					if (imeZadatka.equals(zadaci.get(i).nazivZadatka))
						throw new IstoImeException();
				}

			} catch (IstoImeException e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String programiranjeUpotreba;
		do {
			System.out.println("Da li zadatak zahtijeva upotrebu programiranja? (da/ne)");
			try {
				programiranjeUpotreba = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String dizajnUpotreba;
		do {
			System.out.println("Da li zadatak zahtijeva upotrebu dizajna? (da/ne)");
			try {
				dizajnUpotreba = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		boolean dizajnUpotrebaB;
		boolean programiranjeUpotrebaB;
		String nadredenost;
		do {
			System.out.println("Da li zadatak ima nadredenog ili ga treba dodijeliti? (da/ne)");
			try {
				nadredenost = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		boolean nadredenostB;

		if (programiranjeUpotreba.equals("da"))
			programiranjeUpotrebaB = true;
		else
			programiranjeUpotrebaB = false;

		if (dizajnUpotreba.equals("da"))
			dizajnUpotrebaB = true;
		else
			dizajnUpotrebaB = false;

		if (nadredenost.equals("da"))
			nadredenostB = true;
		else
			nadredenostB = false;

		Zadatak zadatak = new Zadatak(imeZadatka, dizajnUpotrebaB, programiranjeUpotrebaB, nadredenostB);

		zadaci.add(zadatak);

		System.out.println("Zadatak je dodan");

		Main.meni();

	}

	public void dodjeljivanjeZadatka() {
		String imeZadatka;
		do {
			System.out.println("Unesi ime zadatka");
			try {
				imeZadatka = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String radnik;
		do {
			System.out.println("Da li zadatak zahtijeva developera ili dizajnera?(dev/diz)");
			try {
				radnik = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		boolean radnikB;
		if (radnik.equals("dev"))
			radnikB = true;
		else
			radnikB = false;

		if (radnikB = true)
			System.out.println("Unesite ime developera");
		else
			System.out.println("Unesite ime dizajnera");

		String imeRadnika = unos.next();

		Developer dev = new Developer();
		Dizajner diz = new Dizajner();

		Integer brojac = null;
		for (int i = 0; i < zadaci.size(); i++) {
			if (imeZadatka.equals(zadaci.get(i).nazivZadatka))
				brojac = i;
		}

		if (brojac == null) {
			System.out.println("Zadatak nije pronaden");
			Main.meni();
		}

		if (radnikB == true) {
			for (int i = 0; i < developeri.size(); i++) {
				if (imeRadnika.equals(developeri.get(i).ime)) {
					dev.ime = developeri.get(i).ime;
					dev.prezime = developeri.get(i).prezime;
					dev.password = developeri.get(i).password;
					dev.programskiJezik = developeri.get(i).programskiJezik;
					dev.zadatak = zadaci.get(brojac);
				}
			}
		}

		if (radnikB == false) {
			for (int i = 0; i < dizajneri.size(); i++) {
				if (imeRadnika.equals(dizajneri.get(i).ime)) {
					diz.ime = dizajneri.get(i).ime;
					diz.prezime = dizajneri.get(i).prezime;
					diz.password = dizajneri.get(i).password;
					diz.vrstaDizajnera = dizajneri.get(i).vrstaDizajnera;
					diz.zadatak = zadaci.get(brojac);
				}
			}
		}

	}

	private boolean provjeraLetters(String string) {
		boolean hasUppercase = !string.equals(string.toLowerCase());
		boolean hasLowercase = !string.equals(string.toUpperCase());

		boolean vracanje;

		if (hasUppercase == true && hasLowercase == true)
			vracanje = true;
		else
			vracanje = false;
		return vracanje;
	}

}
