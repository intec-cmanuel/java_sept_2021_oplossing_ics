package be.intecbrussel.eatables;

public class Magnum implements Eatable{
    private MagnumType type;

    public Magnum() {
        this(MagnumType.MILKCHOCOLATE);
    }

    public Magnum(MagnumType type){
        this.type = type;
    }

    @Override
    public void eat(){
        System.out.println("We are eating a: " + type.name().toLowerCase() + " Magnum");
    }

    public MagnumType getType(){
        return type;
    }

    public enum MagnumType {
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRIES;
    }
}
