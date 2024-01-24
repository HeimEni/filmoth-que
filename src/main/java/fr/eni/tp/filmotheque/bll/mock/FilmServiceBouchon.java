package fr.eni.tp.filmotheque.bll.mock;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;



@Service
@SessionAttributes("userSession")
public class FilmServiceBouchon implements FilmService {
	private static List<Film> lstFilms = new ArrayList<>();

	private static List<Genre> lstGenres = new ArrayList<>();
	private static List<Participant> lstParticipants = new ArrayList<>();
	private static long indexFilms = 1;

	private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
			"Drame" };

	public FilmServiceBouchon() {
		simulationCoucheDALetDB();
	}

	@Override
	public List<Film> consulterFilms() {
		return lstFilms;
	}

	/**
	 * @return film si id correspond
	 * @return null si inconnu
	 */
	@Override
	public Film consulterFilmParId(long id) {
		return lstFilms.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	@Override
	public List<Genre> consulterGenres() {
		return lstGenres;
	}

	@Override
	public List<Participant> consulterParticipants() {
		return lstParticipants;
	}

	@Override
	public Genre consulterGenreParId(long id) {
		return lstGenres.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	/**
	 * @return participant si id correspond
	 * @return null si inconnu
	 */
	@Override
	public Participant consulterParticipantParId(long id) {
		return lstParticipants.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	@Override
	public void creerFilm(Film film) {
		// Sauvegarde du film
		film.setId(indexFilms++);
		lstFilms.add(film);
	}

	@Override
	public void updateFilm(@ModelAttribute("Film") Film film) {
		System.out.println("ID : " + film.getId());
		var actual = consulterFilmParId(film.getId());
		actual.setAnnee(film.getAnnee());
		actual.setTitre(film.getTitre());
		actual.setSynopsis(film.getSynopsis());
	}

	@Override
	public void add(Film film) {
		if(consulterFilms().stream().filter(f -> f.getTitre().equals(film.getTitre())).toList().isEmpty()){
			creerFilm(film);
		}
	}

	/**
	 * Cette méthode permet de simuler le stockage en base de données et la remontée
	 * d'information
	 */
	public void simulationCoucheDALetDB() {
		// Création de la liste des genres
		for (int index = 0; index < genres.length; index++) {
			lstGenres.add(new Genre(index + 1, genres[index]));
		}

		// Création de la liste des participants aux films (acteurs et réalisateurs)
		// 3 réalisateurs dont 1 pour 2 films et 1 réalisateurs qui est aussi un acteur
		lstParticipants.add(new Participant(1, "Spielberg", "Steven"));
		lstParticipants.add(new Participant(2, "Cronenberg", "David"));
		lstParticipants.add(new Participant(3, "Boon", "Dany"));

		// 2 acteurs par film et l'un d'eux dans 2 films
		lstParticipants.add(new Participant(4, "Attenborough", "Richard"));
		lstParticipants.add(new Participant(5, "Goldblum", "Jeff"));
		lstParticipants.add(new Participant(6, "Davis", "Geena"));
		lstParticipants.add(new Participant(7, "Rylance", "Mark"));
		lstParticipants.add(new Participant(8, "Barnhill", "Ruby"));
		lstParticipants.add(new Participant(9, "Merad", "Kad"));
		lstParticipants.add(new Participant(10, "DiCaprio", "Leonardo"));
		lstParticipants.add(new Participant(11, "Blunt", "Emily"));
		lstParticipants.add(new Participant(12, "Smith", "Will"));
		lstParticipants.add(new Participant(13, "Winslet", "Kate"));
		lstParticipants.add(new Participant(14, "Hanks", "Tom"));
		lstParticipants.add(new Participant(15, "Portman", "Natalie"));

		Film jurassicPark = new Film(indexFilms++, "Jurassic Park", 1993, 128,
				"Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
		jurassicPark.setGenre(lstGenres.get(1));
		jurassicPark.setRealisateur(consulterParticipantParId(1));
		// Associer les acteurs
		jurassicPark.getActeurs().add(consulterParticipantParId(4));
		jurassicPark.getActeurs().add(consulterParticipantParId(5));
		lstFilms.add(jurassicPark);

		Film theFly = new Film(indexFilms++, "The Fly", 1986, 95,
				"Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
		theFly.setGenre(lstGenres.get(1));
		theFly.setRealisateur(consulterParticipantParId(2));
		// Associer les acteurs
		theFly.getActeurs().add(consulterParticipantParId(5));
		theFly.getActeurs().add(consulterParticipantParId(6));
		lstFilms.add(theFly);

		Film film1 = new Film(indexFilms++, "The Shawshank Redemption", 1994, 142, "Description...");
		film1.setGenre(lstGenres.get(0)); // Replace with the correct genre
		film1.setRealisateur(consulterParticipantParId(1)); // Replace with the correct director
		film1.getActeurs().add(consulterParticipantParId(3)); // Replace with the correct actor
		film1.getActeurs().add(consulterParticipantParId(4)); // Replace with the correct actor
		lstFilms.add(film1);

		Film film2 = new Film(indexFilms++, "The Godfather", 1972, 175, "Description...");
		film2.setGenre(lstGenres.get(0)); // Replace with the correct genre
		film2.setRealisateur(consulterParticipantParId(2)); // Replace with the correct director
		film2.getActeurs().add(consulterParticipantParId(5)); // Replace with the correct actor
		film2.getActeurs().add(consulterParticipantParId(6)); // Replace with the correct actor
		lstFilms.add(film2);

		Film film24 = new Film(indexFilms++, "The Silence of the Lambs", 1991, 118, "Description...");
		film24.setGenre(lstGenres.get(3)); // Replace with the correct genre
		film24.setRealisateur(consulterParticipantParId(5)); // Replace with the correct director
		film24.getActeurs().add(consulterParticipantParId(12)); // Replace with the correct actor
		film24.getActeurs().add(consulterParticipantParId(14)); // Replace with the correct actor
		lstFilms.add(film24);

		Film film25 = new Film(indexFilms++, "Fight Club", 1999, 139, "Description...");
		film25.setGenre(lstGenres.get(1)); // Replace with the correct genre
		film25.setRealisateur(consulterParticipantParId(6)); // Replace with the correct director
		film25.getActeurs().add(consulterParticipantParId(13)); // Replace with the correct actor
		film25.getActeurs().add(consulterParticipantParId(15)); // Replace with the correct actor
		lstFilms.add(film25);

		Film film39 = new Film(indexFilms++, "Inception", 2010, 148, "Description...");
		film39.setGenre(lstGenres.get(1)); // Replace with the correct genre
		film39.setRealisateur(consulterParticipantParId(10)); // Replace with the correct director
		film39.getActeurs().add(consulterParticipantParId(13)); // Replace with the correct actor
		film39.getActeurs().add(consulterParticipantParId(14)); // Replace with the correct actor
		lstFilms.add(film39);

		Film film40 = new Film(indexFilms++, "The Dark Knight", 2008, 152, "Description...");
		film40.setGenre(lstGenres.get(1)); // Replace with the correct genre
		film40.setRealisateur(consulterParticipantParId(10)); // Replace with the correct director
		film40.getActeurs().add(consulterParticipantParId(13)); // Replace with the correct actor
		film40.getActeurs().add(consulterParticipantParId(15)); // Replace with the correct actor
		lstFilms.add(film40);

		Film theBFG = new Film(indexFilms++, "The BFG", 2016, 117,
				"Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
		theBFG.setGenre(lstGenres.get(4));
		theBFG.setRealisateur(consulterParticipantParId(1));
		// Associer les acteurs
		theBFG.getActeurs().add(consulterParticipantParId(7));
		theBFG.getActeurs().add(consulterParticipantParId(8));
		lstFilms.add(theBFG);

		Film bienvenueChezLesChtis = new Film(indexFilms++, "Bienvenue chez les Ch'tis", 2008, 106,
				"Philippe Abrams est directeur de la poste de Salon-de-Provence. Il est marié à Julie, dont le caractère dépressif lui rend la vie impossible. Pour lui faire plaisir, Philippe fraude afin d'obtenir une mutation sur la Côte d'Azur. Mais il est démasqué: il sera muté à Bergues, petite ville du Nord.");
		bienvenueChezLesChtis.setGenre(lstGenres.get(4));
		bienvenueChezLesChtis.setRealisateur(consulterParticipantParId(3));
		// Associer les acteurs
		bienvenueChezLesChtis.getActeurs().add(consulterParticipantParId(3));
		bienvenueChezLesChtis.getActeurs().add(consulterParticipantParId(9));
		lstFilms.add(bienvenueChezLesChtis);

		// Création d'un membre et un avis
		Membre membre1 = new Membre(1, "Baille", "Anne-Lise", "abaille@campus-eni.fr", false);
		Avis avis = new Avis(1, 4, "On rit du début à la fin", membre1);
		bienvenueChezLesChtis.getAvis().add(avis);
	}
}
