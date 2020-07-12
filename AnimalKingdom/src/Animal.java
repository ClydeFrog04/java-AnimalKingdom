public abstract class Animal {

    private int number;
    private String name;
    private int yearDiscovered;

    public Animal(int number, String name, int yearDiscovered){
        this.number = number;
        this.name = name;
        this.yearDiscovered = yearDiscovered;
    }

    public void eat(String food){
        System.out.println(String.format("%s ate %s", this.name, food));
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getYearDiscovered() {
        return yearDiscovered;
    }

    abstract String move();

    abstract String breath();

    abstract String reproduce();
}


/*
All animals can move, breath, reproduce. How they do that, so what string should
get returned when the method is executed, varies by animal type.
 */