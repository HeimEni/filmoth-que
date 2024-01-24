package fr.eni.tp.filmotheque.controller;

import fr.eni.tp.filmotheque.bll.contexte.ContexteServiceBouchon;
import fr.eni.tp.filmotheque.bo.Membre;
import fr.eni.tp.filmotheque.bo.Personne;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("userSession")
public class ContexteController {
    private ContexteServiceBouchon contexteServiceBouchon;

    public ContexteController(ContexteServiceBouchon contexteServiceBouchon) {
        this.contexteServiceBouchon = contexteServiceBouchon;
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        System.out.println("Déconnexion");
        sessionStatus.setComplete();
        return "redirect:/findall";
    }
    @GetMapping("/login")
    public String login(@ModelAttribute Membre userSession, @RequestParam(name="email", required = false, defaultValue = "abaille@campus-eni.fr") String email) {
        System.out.println("Connexion");
        Membre aCharger = contexteServiceBouchon.charger(email);
        if(aCharger != null){
            userSession.setId(12);
            userSession.setAdmin(false);
            userSession.setNom("nom");
            userSession.setPrenom("prenom");
            userSession.setMotDePasse("mdp");
            userSession.setPseudo("abaille@campus-eni.fr");
        } else{
            userSession.setId(0);
            userSession.setAdmin(false);
            userSession.setNom("nom");
            userSession.setPrenom("prenom");
            userSession.setMotDePasse("mdr");
            userSession.setPseudo("pseudo");
        }
        System.out.println("user " + userSession.getId());
        return "redirect:/findall";
    }

}
