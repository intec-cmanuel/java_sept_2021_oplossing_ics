package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable{
    private Flavor[] balls;

    public Cone() {
        this(new Flavor[]{Flavor.VANILLA});
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        System.out.println("We are eating a: " + Arrays.toString(balls) + " Cone");
    }

    public enum Flavor {
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;
    }
}
