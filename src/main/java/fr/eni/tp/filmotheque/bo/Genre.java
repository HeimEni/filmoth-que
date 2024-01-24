package fr.eni.tp.filmotheque.bo;

import java.io.Serializable;

public class Genre implements Serializable {
    private long id;
    private String tire;

    public Genre(long id, String tire) {
        this.id = id;
        this.tire = tire;
    }

    public Genre(String tire) {
        this.tire = tire;
    }

    public Genre() {

    }

    @Override
    public String toString() {
        return  tire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }
}
