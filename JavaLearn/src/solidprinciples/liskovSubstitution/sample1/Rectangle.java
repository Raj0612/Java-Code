package solidprinciples.liskovSubstitution.sample1;

public class Rectangle {
    protected int width, height;

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}
