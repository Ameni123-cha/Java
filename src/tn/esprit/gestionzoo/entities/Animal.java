package tn.esprit.gestionzoo.entities;

public class Animal {
    // Attributs privés
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Constructeur paramétré avec validation
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);  // Utilisation de la méthode pour valider l’âge
        this.isMammal = isMammal;
    }

    // Getter et Setter pour l’âge avec validation
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge d'un animal ne peut pas être négatif.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void afficherDetails() {
        System.out.println("Animal: " + name + ", Famille: " + family
                + ", Âge: " + age + " ans, Mammifère: " + (isMammal ? "Oui" : "Non"));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return name.equals(animal.name);
    }
}
