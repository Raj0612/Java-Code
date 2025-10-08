package solidprinciples.liskovSubstitution.sample1;

public class Square extends Rectangle{

    @Override
    public void setDimensions(int width, int height) {
        // Square should have equal sides, so only one dimension is needed
        this.width = this.height = width;
    }
}
