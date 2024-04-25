package ex6_as_2;

public class Main {
    public static void main(String[] args) {

        Pizza pizza = new Pizza();


        pizza = new PepperoniTopping(pizza);
        pizza = new MushroomTopping(pizza);


        System.out.println("Final price: $" + pizza.get_price());
    }
}
