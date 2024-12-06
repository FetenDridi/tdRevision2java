package org.example.tdrevision2java;

import java.util.*;

public class TestAgence {
    public static void main(String[] args) {
        // Création d'une liste de voitures
        Voiture v1 = new Voiture(1, "Toyota", 50.0f);
        Voiture v2 = new Voiture(2, "Renault", 40.0f);
        Voiture v3 = new Voiture(3, "Toyota", 60.0f);

        // Ajout des voitures à la liste
        ListVoitures listVoitures = new ListVoitures();
        listVoitures.ajoutVoiture(v1);
        listVoitures.ajoutVoiture(v2);
        listVoitures.ajoutVoiture(v3);

        // Afficher toutes les voitures
        System.out.println("Toutes les voitures :");
        listVoitures.affiche();

        // Filtrer les voitures par marque
        Critere critereMarque = new CritereMarque("Toyota");
        System.out.println("Voitures de marque Toyota :");
        listVoitures.getVoitures().stream()
                .filter(critereMarque::estSatisfaitPar)
                .forEach(System.out::println);

        // Filtrer les voitures par prix
        Critere criterePrix = new CriterePrix(50.0f);
        System.out.println("Voitures avec un prix <= 50 :");
        listVoitures.getVoitures().stream()
                .filter(criterePrix::estSatisfaitPar)
                .forEach(System.out::println);

        // Création d'une agence
        Agence agence = new Agence("Location Express");
        agence.ajoutVoiture(v1);
        agence.ajoutVoiture(v2);
        agence.ajoutVoiture(v3);

        // Création de clients
        Client c1 = new Client(101, "Ali", "Ben Salah");
        Client c2 = new Client(102, "Sana", "Ben Ahmed");

        // Louer des voitures à des clients
        agence.loueClientVoiture(c1, v1);
        agence.loueClientVoiture(c2, v2);

        // Afficher les clients et leurs voitures
        System.out.println("Clients et leurs voitures louées :");
        agence.afficheLesClientsEtLeursListesVoitures();
    }
}
