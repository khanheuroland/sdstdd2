package Lesson3;

import java.util.EnumMap;
import java.util.Map;

public class ShapeRefactorStratergy {
    public ShapeType type;
    public double width;
    public double height;
    private Map<ShapeType, Shape> strategies = new EnumMap<>(ShapeType.class);
    public ShapeRefactorStratergy(ShapeType type, double width, double height) {
        this.type = type;
        strategies.put(ShapeType.RECTANGLE, new Rectangle(width, height));
        strategies.put(ShapeType.TRIANGLE, new Triangle(width, height));
        strategies.put(ShapeType.SQUARE, new Square(width));
    }

    public double calculateArea() {
        return strategies.get(type).calculateArea();
    }
}
