package fr.eni.tp.filmotheque.bll;

import fr.eni.tp.filmotheque.bo.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FilmService {

    List<Film> consulterFilms();

    Film consulterFilmParId(long id);

    List<Genre> consulterGenres();

    List<Participant> consulterParticipants();

    Genre consulterGenreParId(long id);

    Participant consulterParticipantParId(long id);

    void creerFilm(Film film);
    void updateFilm(Film film);

    void add(Film film);

}
