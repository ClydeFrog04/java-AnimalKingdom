class Bird extends Animal{

    Bird(int number, String name, int yearDiscovered) {
        super(number, name, yearDiscovered);
    }

    @Override
    String move() {
        return "fly";
    }

    @Override
    String breath() {
        return "lungs";
    }

    @Override
    String reproduce() {
        return "eggs";
    }
}


/*
Birds move - fly, breath - lungs, reproduce - eggs
 */