package org.example.tdrevision2java;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) {
        if (!voitures.contains(v)) {
            voitures.add(v);
        } else {
            System.out.println("Voiture déjà présente.");
        }
    }

    public void supprimeVoiture(Voiture v) {
        voitures.remove(v);
    }

    public void affiche() {
        for (Voiture v : voitures) {
            System.out.println(v);
        }
    }

    public Iterator<Voiture> iterateur() {
        return voitures.iterator();
    }
}
