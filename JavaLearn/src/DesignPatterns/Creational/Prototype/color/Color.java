package DesignPatterns.Creational.Prototype.color;

public abstract class Color implements Cloneable {
    protected String colorName;
    public void setColor(String color){
        this.colorName = color;
    }
    abstract public void addColor();

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
