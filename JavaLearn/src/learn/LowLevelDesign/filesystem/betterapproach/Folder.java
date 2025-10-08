package learn.LowLevelDesign.filesystem.betterapproach;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FSComponent{

    List<FSComponent> list;

    public Folder(String name){
        this.name = name;
        list = new ArrayList<>();
    }

    public void addComponent(FSComponent component){
        list.add(component);
    }
    @Override
    int getSize() {
        int size =0;
        for(FSComponent component: list){
            size = component.getSize();
        }
        return size;
    }

    @Override
    int getCount() {
        int count =0;
        for(FSComponent component: list){
            count = count + component.getCount();
        }
        return count;
    }

    @Override
    void printFileName() {
        for(FSComponent component: list){
            component.printFileName();
        }
    }
}
