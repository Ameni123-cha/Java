package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int MAX_ANIMALS = 25;  // Constante pour le nombre max d'animaux
    private Animal[] animals = new Animal[MAX_ANIMALS];
    private String name;
    private String city;
    private int currentAnimalCount = 0;

    // Constructeur paramétré avec validation
    public Zoo(String name, String city) {
        setName(name);  // Utilisation du setter pour valider le nom
        this.city = city;
    }

    // Getter et Setter pour le nom avec validation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne peut pas être vide.");
        }
        this.name = name;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Impossible d'ajouter : le zoo est plein.");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal est déjà dans le zoo.");
            return false;
        }
        animals[currentAnimalCount++] = animal;
        System.out.println(animal.getName() + " a été ajouté au zoo.");
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal non trouvé.");
            return false;
        }
        for (int i = index; i < currentAnimalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[--currentAnimalCount] = null;
        System.out.println(animal.getName() + " a été supprimé du zoo.");
        return true;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < currentAnimalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isZooFull() {
        return currentAnimalCount >= MAX_ANIMALS;
    }

    public void afficherAnimaux() {
        System.out.println("Animaux dans le zoo " + name + " :");
        for (int i = 0; i < currentAnimalCount; i++) {
            animals[i].afficherDetails();
        }
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return z1.currentAnimalCount >= z2.currentAnimalCount ? z1 : z2;
    }

    public void afficherDetails() {
        System.out.println("Zoo: " + name + ", Ville: " + city + ", Nombre d'animaux: " + currentAnimalCount);
    }
}
