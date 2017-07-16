package strategy;

public class ToyDuck extends Duck {
    public ToyDuck() {
        flyBehavior =  new FlyNoWay();
        quackBehavior = new QuackNoWay();
    }

    @Override
    public void display() {
        System.out.println("Not a real duck, just a toy!");
    }
}
