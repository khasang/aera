package strategy;

public class FlyWithRocketJump implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("RRRROCKET!");
    }
}
