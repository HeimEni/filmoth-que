package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bll.mock.FilmServiceBouchon;
import fr.eni.tp.filmotheque.bo.Avis;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/avis")
@SessionAttributes("userSession")
public class AvisController {
    private FilmServiceBouchon filmService;
    @Autowired
    public AvisController(FilmServiceBouchon filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/create/{id}")
    public String create(Model model, @PathVariable(name = "id") long id){
        System.out.println(filmService.consulterFilmParId(id).getAvis());
        model.addAttribute("film", filmService.consulterFilmParId(id));
        model.addAttribute(new Avis());
        return "view-avis";
    }

    @PostMapping("/create/{id}")
    public String create(@ModelAttribute("userSession") Membre userSession, @ModelAttribute Avis avis, @PathVariable(name="id") String id){
        if(avis.getNote() < 6 && avis.getNote() >= 0) {
            Film currentFilm = filmService.consulterFilmParId(Long.parseLong(id));
            avis.setMembre(userSession);
            currentFilm.getAvis().add(avis);
            currentFilm.setAvis(currentFilm.getAvis());
            System.out.println(currentFilm);
            return "redirect:/findall";
        } else {
            return "redirect:/findall";
        }
    }
    @ModelAttribute("userSession")
    public Membre chargerUserSession() {
        return new Membre(1,"nom","prenom","abaille@campus-eni.fr",true);
    }

}
