import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner unos = new Scanner(System.in);

	public static void main(String[] args) {
		
		try {
			File file = new File("Firma.txt");
			if (!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		registracijaKorisnika();

	}

	public static void registracijaKorisnika() {

		System.out.println("Unesite vase ime");
		String ime = unos.next();
		System.out.println("Unesite vase prezime");
		String prezime = unos.next();
		System.out.println("Unesite vas username (ako imate jedan, ako nemate upisite .)");
		String username = unos.next();
		System.out.println("Unesite vas password");
		String password = unos.next();

		if (username.equals("."))
			username = "";

		Korisnik korisnik = new Korisnik(ime, prezime, password, username);

		korisnik.provjeraKorisnika(korisnik);
	}

	public static void meni() {

		int opcija = 0;
		do {
			System.out.println("Odaberite jednu od opcija:");
			System.out.println("1 - Dodajte developera;");
			System.out.println("2 - Dodajte zadatak;");
			System.out.println("3 - Dodijelite zadatak;");
			System.out.println("4 - Dodajte dizajnera");

			try {
				opcija = unos.nextInt();

			} catch (Exception e) {
				unos.nextLine();
				System.out.println("Pogresan unos");
				continue;
			}
			break;
		} while (true);
		Ponasanja opcije = new Ponasanja();
		ImplementacijaPonasanja ponasanja = new ImplementacijaPonasanja();

		switch (opcija) {
		case 1:
			opcije.dodavanjeDevelopera();
			break;
		case 2:
			opcije.dodavanjeZadatka();
			break;
		case 3:
			opcije.dodjeljivanjeZadatka();
			break;
		case 4:
			ponasanja.dodavanjeDizajnera();
			;
			break;

		}

	}

}
