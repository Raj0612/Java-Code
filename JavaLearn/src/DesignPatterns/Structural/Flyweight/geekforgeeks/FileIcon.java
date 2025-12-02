package DesignPatterns.Structural.Flyweight.geekforgeeks;
// Concrete Flyweight class representing a File Icon
public class FileIcon implements Icon{

    private String type;  // Intrinsic state: type of file icon (e.g., document, image)
    private Image image;  // Intrinsic state: image specific to the file icon

    public FileIcon(String type, Image image) {
        this.type = type;
        this.image = image;
    }


    @Override
    public void draw(int x, int y) {
        // Draw logic specific to file icon using intrinsic state (image)
        System.out.println("Drawing " + type + " icon at position (" + x + ", " + y + ")");
    }
}
