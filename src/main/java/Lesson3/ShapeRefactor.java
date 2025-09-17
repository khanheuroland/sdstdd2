package Lesson3;

public class ShapeRefactor {
    public ShapeType type;
    public double width;
    public double height;
    public double calculateArea() {
        Shape shape=null;
        switch (type) {
            case RECTANGLE:
                shape = new Rectangle(width, height);
                break;
            case SQUARE:
                shape = new Square(width);
                break;
            case TRIANGLE:
                shape = new Triangle(width, height);
                break;
            default:
                throw new IllegalArgumentException("Unknow shape");
        }
        return shape.calculateArea();
    }
}
