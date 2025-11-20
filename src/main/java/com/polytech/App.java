package com.polytech;

import com.polytech.tp.*;

public class App {
    public static void main(String[] args) {

        System.out.println("===== TEST EXERCICE 1 : BUILDER =====");

        // Création d'un cours via le Builder
        ICours cours = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mme Dupont")
                .setSalle("B12")
                .setDate("2025-03-01")
                .setHeureDebut("08:00")
                .setEstOptionnel(false)
                .setNiveau("2GI")
                .setNecessiteProjecteur(true)
                .build();

        System.out.println(cours.getDescription());
        System.out.println("Durée : " + cours.getDuree() + " heures");

        // ---------------------------------------------
        System.out.println("\n===== TEST EXERCICE 2 : OBSERVER =====");

        // Création du gestionnaire (Subject)
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        // Observateurs
        Observer etu1 = new Etudiant("Ahmed");
        Observer etu2 = new Etudiant("Sara");
        Observer resp = new Responsable("Mme Dubois");

        // Attacher les observateurs
        gestionnaire.attach(etu1);
        gestionnaire.attach(etu2);
        gestionnaire.attach(resp);

        // Ajouter un cours -> notifications
        gestionnaire.ajouterCours(cours);

        // Modifier un cours -> notifications
        gestionnaire.modifierCours(cours, "Heure déplacée à 10h");

        // ---------------------------------------------
        System.out.println("\n===== TEST EXERCICE 3 : DECORATOR =====");

        // Décoration des cours
        ICours coursEnLigne = new CoursEnLigne(cours);
        ICours coursAnglais = new CoursEnAnglais(coursEnLigne);
        ICours coursMagistral = new CoursMagistral(coursAnglais);

        System.out.println(coursMagistral.getDescription());
        System.out.println("Durée : " + coursMagistral.getDuree() + " heures");

        System.out.println("\n===== FIN DES TESTS =====");
    }
}
