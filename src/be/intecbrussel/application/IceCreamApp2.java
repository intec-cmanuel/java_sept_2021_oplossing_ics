package be.intecbrussel.application;

import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.sellers.*;

public class IceCreamApp2 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(1,1,1);
        Stock stock = new Stock();
        stock.setBalls(2);
        stock.setMagni(2);
        stock.setCones(2);
        stock.setIceRockets(2);

        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);

            IceRocket iceRocket1 = letCostumerOrderIceRocket(iceCreamSeller);
            iceRocket1.eat();
            IceRocket iceRocket2 = letCostumerOrderIceRocket(iceCreamSeller);
            iceRocket2.eat();
            IceRocket iceRocket3 = letCostumerOrderIceRocket(iceCreamSeller);
            iceRocket3.eat();
    }

    private static IceRocket letCostumerOrderIceRocket(IceCreamSeller iceCreamSeller) {
        IceRocket iceRocket = null;
        try {
            iceRocket = iceCreamSeller.orderIceRocket();
        } catch (NoMoreIceCreamException e) {
            System.out.println(e.getMessage());
        }
        return iceRocket;
    }
}
