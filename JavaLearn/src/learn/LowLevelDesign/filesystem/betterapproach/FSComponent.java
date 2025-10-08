package learn.LowLevelDesign.filesystem.betterapproach;

public abstract class FSComponent {

    String name;

    abstract int getSize();

    abstract int getCount();

    abstract void printFileName();
}
