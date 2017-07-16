package strategy;

public class RedHatDuck extends Duck {

    public RedHatDuck() {
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I am red hat duck!");
    }

}
