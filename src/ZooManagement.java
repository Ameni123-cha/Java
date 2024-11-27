import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo: ");
        String zooName = sc.nextLine();

        int nbrCages = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Entrez le nombre de cages: ");
                nbrCages = Integer.parseInt(sc.nextLine());
                if (nbrCages > 0) {
                    validInput = true;
                } else {
                    System.out.println("Veuillez entrer un nombre positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);

        Animal lion = new Animal("Felidae", "Lion", 5, true);
        Animal tiger = new Animal("Felidae", "Tigre", 4, true);
        Animal elephant = new Animal("Elephantidae", "Éléphant", 10, false);

        // Instruction 10
        System.out.println("Ajout du lion : " + myZoo.addAnimal(lion));
        System.out.println("Ajout du tigre : " + myZoo.addAnimal(tiger));
        System.out.println("Ajout de l'éléphant : " + myZoo.addAnimal(elephant));

        // Instruction 11
        System.out.println("Recherche du lion : " + myZoo.searchAnimal(lion));
        System.out.println("Recherche d'un animal inexistant (Zèbre) : " + myZoo.searchAnimal(new Animal("Equidae", "Zèbre", 6, false)));

        // Instruction 12
        Animal lion2 = new Animal("Felidae", "Lion", 5, true);
        System.out.println("Ajout d'un deuxième lion identique : " + myZoo.addAnimal(lion2));

        // Instruction 13
        System.out.println("Suppression du tigre : " + myZoo.removeAnimal(tiger));
        System.out.println("Suppression d'un animal non présent (Zèbre) : " + myZoo.removeAnimal(new Animal("Equidae", "Zèbre", 6, false)));

        myZoo.displayAnimals();

        // Instruction 15
        System.out.println("Le zoo est-il plein ? " + myZoo.isZooFull());

        // Instruction 16
        Zoo anotherZoo = new Zoo("Safari Park", "Sousse", 30);
        anotherZoo.addAnimal(new Animal("Canidae", "Loup", 3, true));
        Zoo biggerZoo = Zoo.comparerZoo(myZoo, anotherZoo);
        System.out.println("Le zoo avec le plus d'animaux : " + biggerZoo.name);
    }
}

class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal [Nom=" + name + ", Famille=" + family + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal other = (Animal) obj;
        return this.name.equals(other.name) && this.family.equals(other.family);
    }
}

class Zoo {
    Animal[] animals;
    String name;
    String city;
    final int nbrCages;
    int animalCount;


    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    // Instruction 10
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein !");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal est déjà dans le zoo !");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // Instruction 13
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("L'animal n'a pas été trouvé dans le zoo.");
            return false;
        }

        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    // Instruction 11
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 11
    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + " :");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    // Instruction 15
    public boolean isZooFull() {
        return animalCount >= nbrCages;
    }

    // Instruction 16
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        return z1.animalCount > z2.animalCount ? z1 : z2;
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Nombre de cages=" + nbrCages + "]";
    }
}
