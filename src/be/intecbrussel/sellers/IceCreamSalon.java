package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
        totalProfit = 0;
    }


    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        totalProfit += priceList.getBallPrice() * balls.length;
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit += priceList.getRocketPrice() * 0.20;
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        totalProfit += priceList.getMagnumPrice(type);
        return new Magnum(type);
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }
}
