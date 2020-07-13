import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    //interfaces
    private interface CheckType {
        boolean test(String type);
    }

    private interface CheckNum{
        boolean test(int num);
    }

    private interface CheckReproduction{
        boolean test(String reproduceBy);
    }

    //methods
    @NotNull
    private static List<Animal> filterBreath(@NotNull List<Animal> animalList, CheckType typeTester) {
        List<Animal> filteredList = new ArrayList<>();

        for (Animal animal : animalList) {
            // if the lambda expression returns true, add that element to the new ArrayList
            if (typeTester.test(animal.breath())) filteredList.add(animal);
        }
        return filteredList;
    }

    @NotNull
    private static List<Animal> filterYear(@NotNull List<Animal> animalList, CheckNum numTester){
        List<Animal> filteredList = new ArrayList<>();

        for(Animal animal : animalList){
            if(numTester.test(animal.getYearDiscovered())) filteredList.add(animal);
        }
        return filteredList;
    }

    @NotNull
    private static List<Animal> filterReproduction(@NotNull List<Animal> animalList, CheckReproduction reproductionTester){
        List<Animal> filteredList = new ArrayList<>();

        for(Animal animal : animalList){
            if(reproductionTester.test(animal.reproduce())) filteredList.add(animal);
        }
        return filteredList;
    }

    private static List<Animal> filterType(@NotNull List<Animal> animalList, CheckType typeTester) {
        List<Animal> filteredList = new ArrayList<>();

        for (Animal animal : animalList) {
            //I know the keyword instanceof exists, but it is said to be code smell, so I have decided not to use it here.
            //I believe there is a solution with polymorphism to be found here, but I haven't tried that yet
            if (typeTester.test(animal.getClass().toString())) filteredList.add(animal);
        }
        return filteredList;
    }


    public static void main(String[] args) {
        final ArrayList<Animal> animals = new ArrayList<>();

        //mammals
        animals.add(new Mammal(0, "Panda", 1869));
        animals.add(new Mammal(1, "Zebra", 1778));
        animals.add(new Mammal(2, "Koala", 1816));
        animals.add(new Mammal(3, "Sloth", 1804));
        animals.add(new Mammal(4, "Armadillo", 1758));
        animals.add(new Mammal(5, "Raccoon", 1758));
        animals.add(new Mammal(6, "Bigfoot", 2021));

        //birds
        animals.add(new Bird(7, "Pigeon", 1837));
        animals.add(new Bird(8, "Peacock", 1821));
        animals.add(new Bird(9, "Toucan", 1758));
        animals.add(new Bird(10, "Parrot", 1824));
        animals.add(new Bird(11, "Swan", 1758));

        //fish
        animals.add(new Fish(12, "Salmon", 1758));
        animals.add(new Fish(13, "Catfish", 1817));
        animals.add(new Fish(14, "Perch", 1758));

        //list animals by year
        animals.sort(Comparator.comparing(animal -> String.valueOf(animal.getYearDiscovered()), Comparator.reverseOrder()));
        System.out.println("Sort by year: " + animals);

        //list animals by name
        animals.sort(Comparator.comparing(animal -> {
            return animal.getName();
        }));
        System.out.println("Sort by name: " + animals);

        //list animals by movement type
        animals.sort(Comparator.comparing(animal -> {
            return animal.move();
        }));
        System.out.println("Sort by move: " + animals);

        //list animals with lungs
        System.out.println("Animals with lungs: \n" + filterBreath(animals, breath -> breath.equalsIgnoreCase("lungs")));

        //list animals with lungs that were named in 1758
        //a nice one liner XP. Can be broken up into vars but I liked this solution
        System.out.println("Animals with lungs by 1758: \n" + filterYear(filterBreath(animals, breath -> breath.equalsIgnoreCase("lungs")), year -> year == 1758));

        //list animals with lungs that lay eggs
        //another one liner in the same style as above
        System.out.println("Animals with lungs that lay eggs: \n" + filterBreath(filterReproduction(animals, reproduceBy ->
                reproduceBy.equalsIgnoreCase("eggs")), breath ->
                breath.equalsIgnoreCase("lungs")));

        //list alphabetically animals named in 1758
        //sort by name first
        animals.sort(Comparator.comparing(animal -> {
            return animal.getName();
        }));
        //filter by year and print list
        System.out.println("Animals named in 1758: \n" + filterYear(animals, year -> year == 1758));

        //stretch: list only animals of type Mammal
        System.out.println("Mammals only:\n " + filterType(animals, type -> type.equalsIgnoreCase("class mammal")));

    }
}


/*
 */