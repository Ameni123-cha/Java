package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagement {
    public static void main(String[] args) {
        // Création d'animaux
        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal tigre = new Animal("Felidae", "Tigre", 4, true);

        // Création du zoo
        Zoo myZoo = new Zoo("My Zoo", "Tunis");

        // Ajout d'animaux
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tigre);

        // Affichage des animaux
        myZoo.afficherAnimaux();

        // Recherche d'un animal
        int index = myZoo.searchAnimal(lion);
        System.out.println("L'indice du Lion est : " + index);

        // Test de suppression
        myZoo.removeAnimal(tigre);
        myZoo.afficherAnimaux();

        // Comparaison de deux zoos
        Zoo secondZoo = new Zoo("Safari", "Sousse");
        Zoo zooAvecPlusDAnimaux = Zoo.comparerZoo(myZoo, secondZoo);
        System.out.println("Le zoo avec le plus d'animaux est : " + zooAvecPlusDAnimaux.getName());
    }
}
