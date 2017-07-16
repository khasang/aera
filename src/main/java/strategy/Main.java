package strategy;

public class Main {

    public static void main(String[] args) {
        Duck toyDuck = new ToyDuck();
        Duck mallardDuck = new MallardDuck();
//        mallardDuck.performQuack();
//        toyDuck.performFly();
//        mallardDuck.performFly();
        toyDuck.performQuack();
        toyDuck.performFly();
        Singleton singleton = Singleton.getInstance();
    }
}
