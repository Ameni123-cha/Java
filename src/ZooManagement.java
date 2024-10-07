import java.util.Scanner;

public class ZooManagement {

    public static void main(String[] args) {
        // Instruction 2 (TP1) : Utilisation de Scanner pour permettre à l'utilisateur de saisir le nom du zoo et le nombre de cages
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

        System.out.println(zooName + " comporte " + nbrCages + " cages.");

        // Instruction 5
        Zoo myZoo = new Zoo(zooName, "Tunis", nbrCages);
        Animal lion = new Animal("LionFamille", "Lion", 5, true);

        // Instruction 8
        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

    }
}

// Instruction 5
class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    // Instruction 6
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    // Instruction 9
    @Override
    public String toString() {
        return "Animal [Nom=" + name + ", Famille=" + family + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }
}

// Instruction 5
class Zoo {
    Animal[] animals = new Animal[25];
    String name;
    String city;
    int nbrCages;

    // Instruction 6
    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }

    // Instruction 8
    public void displayZoo() {
        System.out.println("Nom du Zoo : " + name + ", Ville : " + city + ", Nombre de cages : " + nbrCages);
    }

    // Instruction 9
    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Nombre de cages=" + nbrCages + "]";
    }
}
