package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Film implements Serializable {
    private List<Participant> participants;
    private Genre genre;
    private long id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    private Participant realisateur;
    private List<Participant> acteurs;
    private List<Avis> avis;
    //    Bloc d'initalisation
    {
        this.acteurs = new ArrayList<>();
        this.avis = new ArrayList<>();
    }
    //    Bloc d'initalisation
    public Film(){

    }
    public Film(long id, String titre, int annee , int duree ,String synopsis) {
        this(titre, annee, duree, synopsis);
        this.id = id;
    }

    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }
    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "Film ("+ id +")" + '\n' +
                "Titre =" + titre + "[annee : " + annee +", duree : "+ duree + " minutes]" + '\n' +
                "Synopsis =" + synopsis + '\n' +
                "Réalisateur =" + realisateur + '\n' +
                "Acteurs =" + acteurs + '\n' +
                "Genre =" + genre + '\n' +
                "Avis =" + avis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
