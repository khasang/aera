package strategy;

public class QuackWithMouth implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
