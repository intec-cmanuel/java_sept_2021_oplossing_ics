package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller{
    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar(PriceList priceList, Stock stock){
        this.priceList = priceList;
        this.stock = stock;
        this.profit = 0;
    }

    @Override
    public Cone orderCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {
        if (stock.getCones() <= 0) {
            throw new NoMoreIceCreamException("No more cones");
        }

        if (stock.getBalls() < balls.length) {
            throw new NoMoreIceCreamException("Not enough ice cream balls");
        }

        Cone cone = prepareCone(balls);

        profit += priceList.getBallPrice() * balls.length;
        return cone;
    }

    private Cone prepareCone(Cone.Flavor[] balls){
        Cone cone = new Cone(balls);
        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - balls.length);
        return cone;
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        if (stock.getIceRockets() <= 0) {
            throw new NoMoreIceCreamException("No more ice rockets");
        }

        IceRocket iceRocket = prepareIceRocket();

        profit += priceList.getRocketPrice();
        return iceRocket;
    }

    private IceRocket prepareIceRocket() {
        IceRocket iceRocket = new IceRocket();
        stock.setIceRockets(stock.getIceRockets() - 1);
        return iceRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) throws NoMoreIceCreamException {
        if (stock.getMagni() <= 0) {
            throw new NoMoreIceCreamException("Out of magnum");
        }

        Magnum magnum = prepareMagnum(type);

        profit += priceList.getMagnumPrice(type);
        return magnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        Magnum magnum = new Magnum(type);
        stock.setMagni(stock.getMagni() - 1);
        return magnum;
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
