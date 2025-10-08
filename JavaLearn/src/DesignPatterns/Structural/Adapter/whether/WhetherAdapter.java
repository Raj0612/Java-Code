package DesignPatterns.Structural.Adapter.whether;

public class WhetherAdapter {

    public int findTemp(int zipCode){
        String city = null;
        if(zipCode == 19406)
            city = "King Of Prussia";

        WhetherFinder finder = new WhetherFinderImpl();
        int result = finder.find(city);
        return result;
    }
}
