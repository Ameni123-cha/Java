import java.util.Scanner;

public class ZooManagement {
    // Instruction 1 : Déclaration des variables
    int nbrCages = 20;
    String zooName = "my zoo";

    public static void main(String[] args) {
        // Instruction 1 :
        ZooManagement zoo = new ZooManagement();
        System.out.println(zoo.zooName + " comporte " + zoo.nbrCages + " cages.");

        // Instruction 2 :
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du zoo : ");
        zoo.zooName = scanner.nextLine(); // Lire le nom du zoo depuis l'entrée clavier

        System.out.print("Entrez le nombre de cages : ");

        while (!scanner.hasNextInt()) {
            System.out.println("Veuillez entrer un nombre valide.");
            scanner.next();
        }
        zoo.nbrCages = scanner.nextInt();

        System.out.println(zoo.zooName + " comporte " + zoo.nbrCages + " cages.");

        scanner.close();
    }
}