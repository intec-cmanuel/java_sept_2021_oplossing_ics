package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
        this(1,1,1);
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType magnumType) {
        double priceFactor;

        switch(magnumType) {
            case MILKCHOCOLATE:
                priceFactor = 1.1;
                break;
            case BLACKCHOCOLATE:
                priceFactor = 1.3;
                break;
            case WHITECHOCOLATE:
                priceFactor = 1.2;
                break;
            case ALPINENUTS:
                priceFactor = 20;
                break;
            case ROMANTICSTRAWBERRIES:
                priceFactor = 1.6;
            default:
                priceFactor = 1;
        }

        return magnumStandardPrice * priceFactor;
    }
}
