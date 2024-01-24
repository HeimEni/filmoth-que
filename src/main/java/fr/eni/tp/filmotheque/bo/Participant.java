package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;

public class Participant extends Personne implements Serializable {

    public Participant(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
