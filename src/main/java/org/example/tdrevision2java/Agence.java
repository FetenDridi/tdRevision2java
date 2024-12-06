package org.example.tdrevision2java;

import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, List<Voiture>> ClientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.vs = new ListVoitures();
        this.ClientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) {
        vs.ajoutVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) {
        vs.supprimeVoiture(v);
        ClientVoitureLoue.computeIfAbsent(cl, k -> new ArrayList<>()).add(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) {
        List<Voiture> louees = ClientVoitureLoue.getOrDefault(cl, new ArrayList<>());
        if (louees.remove(v)) {
            vs.ajoutVoiture(v);
        }
    }

    public Set<Client> ensembleClientsLoueurs() {
        return ClientVoitureLoue.keySet();
    }

    public List<Voiture> voituresLouees() {
        List<Voiture> result = new ArrayList<>();
        for (List<Voiture> list : ClientVoitureLoue.values()) {
            result.addAll(list);
        }
        return result;
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, List<Voiture>> entry : ClientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey() + " | Voitures: " + entry.getValue());
        }
    }
    public Map<Client, List<Voiture>> triCodeCroissant() {
        return new TreeMap<>(ClientVoitureLoue);
    }


    public Map<Client, List<Voiture>> triNomCroissant() {
        return new TreeMap<>(Comparator.comparing(Client::getNom));
    }


}
