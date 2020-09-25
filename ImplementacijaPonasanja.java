
public class ImplementacijaPonasanja extends Ponasanja {

	public void dodavanjeDizajnera() {

		String imeDizajnera;
		do {
			System.out.println("Unesite ime dizajnera");
			try {
				imeDizajnera = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String prezimeDizajnera;
		do {
			System.out.println("Unesite prezime dizajnera");
			try {
				prezimeDizajnera = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String passwordDizajnera;
		do {
			System.out.println("Unesite password");
			try {
				passwordDizajnera = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		String imeZadatka;
		do {
			System.out.println("Unesite ime zadatka dodijeljenog dizajneru");
			try {
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);
		imeZadatka = unos.next();

		String podrucjeDizajnera;
		do {
			System.out.println("Za koje podrucje je dizajner specijaliziran?");
			try {
				podrucjeDizajnera = unos.next();
			} catch (Exception e) {
				unos.nextLine();
				System.out.println(e.getMessage());
				continue;
			}
			break;
		} while (true);

		int brojac = 99999;
		for (int i = 0; i < zadaci.size(); i++) {
			if (imeZadatka.equals(zadaci.get(i).getNazivZadatka()))
				brojac = i;
		}

		if (brojac == 99999) {
			System.out.println("Zadatak kojeg ste unijeli ne postoji");
			Main.meni();
		}

		Dizajner dizajner = new Dizajner(imeDizajnera, prezimeDizajnera, passwordDizajnera, zadaci.get(brojac),
				podrucjeDizajnera);

		dizajneri.add(dizajner);

	}

}
