package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;

public class Membre extends Personne implements Serializable {
    private Personne personne;
    private String pseudo;
    private String motDePasse;
    private boolean admin;

    public Membre(Personne personne, String pseudo, String motDePasse, boolean admin) {
        this.personne = personne;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public Membre(long id, String nom, String prenom, Personne personne, String pseudo, String motDePasse, boolean admin) {
        super(id, nom, prenom);
        this.personne = personne;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }
    public Membre(long id, String nom, String prenom, String pseudo, boolean admin) {
        super(id, nom, prenom);
        this.pseudo = pseudo;
        this.admin = admin;
    }

    public Membre() {

    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Membre{");
        sb.append("personne=").append(personne);
        sb.append(", pseudo='").append(pseudo).append('\'');
        sb.append(", motDePasse='").append(motDePasse).append('\'');
        sb.append(", admin=").append(admin);
        sb.append('}');
        return sb.toString();
    }
}
