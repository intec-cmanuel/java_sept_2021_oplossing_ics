package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

import java.util.stream.Stream;

public class IceCreamApp {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(1, 2, 2);
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);

        try {
            Cone cone1 = iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.MOKKA, Cone.Flavor.MOKKA});
            Cone cone2 = iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.STRAWBERRY, Cone.Flavor.VANILLA});
            IceRocket iceRocket1 = iceCreamSeller.orderIceRocket();
            IceRocket iceRocket2 = iceCreamSeller.orderIceRocket();
            Magnum magnum = iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE);

            Eatable[] myFood = new Eatable[]{cone1, cone2, iceRocket1, iceRocket2, magnum};

            for (Eatable eatable : myFood) {
                eatable.eat();
            }
        } catch (NoMoreIceCreamException e) {
            e.printStackTrace();
        }
        // Stream.of(myFood).forEach(Eatable::eat);

        System.out.printf("Today's profit: %.2f%n", iceCreamSeller.getProfit());
    }
}
