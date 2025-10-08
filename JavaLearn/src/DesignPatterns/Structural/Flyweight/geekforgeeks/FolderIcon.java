package DesignPatterns.Structural.Flyweight.geekforgeeks;

public class FolderIcon implements  Icon{

    private String color;  // Intrinsic state: color of the folder icon
    private Image image;   // Intrinsic state: image specific to the folder icon

    public FolderIcon(String color, Image image) {
        this.color = color;
        this.image = image;
    }

    @Override
    public void draw(int x, int y) {
        // Draw logic specific to folder icon using intrinsic state (image)
        System.out.println("Drawing folder icon with color " + color + " at position (" + x + ", " + y + ")");
    }
}
