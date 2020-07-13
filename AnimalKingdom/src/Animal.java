public abstract class Animal {

    private int number;
    private String name;
    private int yearDiscovered;

    public Animal(int number, String name, int yearDiscovered){
        this.number = number;
        this.name = name;
        this.yearDiscovered = yearDiscovered;
    }

    //public methods
    public void eat(String food){
        System.out.println(String.format("%s ate %s", this.name, food));
    }

    public int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }

    int getYearDiscovered() {
        return yearDiscovered;
    }

    //abstract methods
    abstract String move();

    abstract String breath();

    abstract String reproduce();

    //overrides
    @Override
    public String toString(){
        return String.format("Animal id: %d Name: %s Year Discovered: %d Movement Type: %s Breaths by: %s Reproduces by: %s%n",
                this.number, this.name, this.yearDiscovered, this.move(), this.breath(), this.reproduce());
    }
}


/*
All animals can move, breath, reproduce. How they do that, so what string should
get returned when the method is executed, varies by animal type.
 */