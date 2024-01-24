package fr.eni.tp.filmotheque.bll.contexte;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.tp.filmotheque.bo.Membre;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@Profile("dev")
//@SessionAttributes("userSession")
public class ContexteServiceBouchon implements ContexteService {
	// Liste des membres
	private static List<Membre> lstMembres;

	public ContexteServiceBouchon() {
		// initialisation de la liste
		lstMembres = new ArrayList<>();
		lstMembres.add(new Membre(1, "Baille", "Anne-Lise", "abaille@campus-eni.fr", false));
		Membre admin = new Membre(2, "Gobin", "Stéphane", "sgobin@campus-eni.fr", false);
		admin.setAdmin(true);
		lstMembres.add(admin);
		lstMembres.add(new Membre(3, "Trillard", "Julien", "jtrillard@campus-eni.fr", false));
	}

	@Override
	@ModelAttribute("userSession")
	public Membre charger(String email) {
		Membre user = lstMembres.stream().filter(item -> item.getPseudo().equals(email)).findAny().orElse(null);
		System.out.println("chargement du userSession :" +  user);
		return user;
	}
}
