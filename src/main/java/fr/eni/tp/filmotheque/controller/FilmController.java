package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"lstGenres", "userSession"})
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/findall")
    public String findAll(@ModelAttribute("userSession") Membre membre, Model model) {
        model.addAttribute("films", filmService.consulterFilms());
        return "view-findall";
    }

    @RequestMapping(name = "findById", method = RequestMethod.GET, path = "/getById/{id}")
    public String findById(Model model, @PathVariable(name = "id") long id) {
        if (filmService.consulterFilmParId(id) != null) {
            model.addAttribute("film", filmService.consulterFilmParId(id));
            model.addAttribute("listFilm", filmService.consulterFilmParId(id).getAvis());
        } else {
            return "error";
        }
        return "view-findById";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submit(@ModelAttribute("Film") Film film) {
        System.out.println(film);
        filmService.updateFilm(film);
        return "redirect:findall";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(Film film) {
        filmService.creerFilm(film);
        return "redirect:findall";
    }


    @ModelAttribute("userSession")
    public Membre chargerUserSession() {
        return new Membre(1,"nom","prenom","abaille@campus-eni.fr",true);
    }

    @GetMapping("/creer")
    public String creerFilm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("lstGenre", filmService.consulterGenres());
        model.addAttribute("lstParticipant", filmService.consulterParticipants());
        return "view-creer";
    }

    @PostMapping("/creer")
    public String creerFilmPost(@ModelAttribute Film film) {
        System.out.println(film);
        filmService.creerFilm(film);
        return "redirect:/findall";
    }
}
