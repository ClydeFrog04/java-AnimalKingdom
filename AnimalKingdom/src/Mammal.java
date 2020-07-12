public class Mammal extends Animal {


    public Mammal(int number, String name, int yearDiscovered) {
        super(number, name, yearDiscovered);
    }

    @Override
    String move() {
        return "walk";
    }

    @Override
    String breath() {
        return "lungs";
    }

    @Override
    String reproduce() {
        return "live births";
    }
}

/*
Mammals move - walk, breath - lungs, reproduce - live births
 */