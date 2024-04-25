package ex6_as_2;

class Pizza {
    protected double price;

    public Pizza() {
        this.price = 10.0;
    }

    public double get_price() {
        return price;
    }
}


class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public double get_price() {
        return pizza.get_price();
    }
}



class PepperoniTopping extends PizzaDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    public double get_price() {
        double toppingPrice = 2.0;
        return super.get_price() + toppingPrice;
    }
}

class MushroomTopping extends PizzaDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    public double get_price() {
        double toppingPrice = 1.5;
        return super.get_price() + toppingPrice;
    }
}



