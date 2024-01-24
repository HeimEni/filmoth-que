package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;

public class Avis implements Serializable {
    private Membre membre;
    private long id;
    private int note;
    private String commentaire;

    public Avis(long id, int note, String commentaire, Membre membre) {
        this.membre = membre;
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Avis(Membre membre, int note, String commentaire) {
        this.membre = membre;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Avis() {

    }

    @Override
    public String toString() {
        return "Avis de " + membre + " note =" + note + " commentaire: " + commentaire;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
