package learn.LowLevelDesign.filesystem.betterapproach;

public class File extends FSComponent {
    int size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }


    @Override
    int getSize() {
        return size;
    }

    @Override
    int getCount() {
        return 1;
    }

    @Override
    void printFileName() {
        System.out.println("File " + name);
    }
}
