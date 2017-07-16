package strategy;

public class MallardDuck extends Duck{
    public MallardDuck() {
        flyBehavior = new FlyWithRocketJump();
        quackBehavior = new QuackWithMouth();
    }

    @Override
    public void display() {
        System.out.println("I am mallard duck!");
    }

}
