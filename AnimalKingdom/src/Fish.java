class Fish extends Animal{
    Fish(int number, String name, int yearDiscovered) {
        super(number, name, yearDiscovered);
    }

    @Override
    String move() {
        return "swim";
    }

    @Override
    String breath() {
        return "gills";
    }

    @Override
    String reproduce() {
        return "eggs";
    }
}


/*
Fish move - swim, breath - gills, reproduce - eggs
 */