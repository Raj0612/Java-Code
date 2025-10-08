package learn.clone;

import java.util.ArrayList;

public class ShallowAndDeep {


    public String name;
    public ArrayList<String> colors;

    public ShallowAndDeep(String name, ArrayList<String> colors)
    {
        this.name = name;
        this.colors = colors;
    }
}

class Main {
    public static void main(String[] args)
    {
        // Create a Honda car object
        ArrayList<String> hondaColors = new ArrayList<>();
        hondaColors.add("Red");
        hondaColors.add("Blue");
        ShallowAndDeep honda = new ShallowAndDeep("Honda", hondaColors);

        System.out.println("honda " + honda);

        // Deep copy of Honda
        ShallowAndDeep deepcopyHonda = new ShallowAndDeep(
                honda.name, new ArrayList<>(honda.colors));
        deepcopyHonda.colors.add("Green");
        System.out.print("Deepcopy: ");
        for (String color : deepcopyHonda.colors) {
            System.out.print(color + " ");
        }
        System.out.println("\nOriginal: ");
        for (String color : honda.colors) {
            System.out.print(color + " ");
        }
        System.out.println();

        // Shallow Copy of Honda
        ShallowAndDeep copyHonda = honda;

        System.out.println("copyHonda " + copyHonda + " honda " + honda);
        copyHonda.colors.add("Green");
        System.out.print("Shallow Copy: ");
        for (String color : copyHonda.colors) {
            System.out.print(color + " ");
        }
        System.out.println("\nOriginal: ");
        for (String color : honda.colors) {
            System.out.print(color + " ");
        }
        System.out.println();
    }
}
