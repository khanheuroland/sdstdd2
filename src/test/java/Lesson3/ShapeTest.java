package Lesson3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeTest {
    @Test
    public void should_return_rectangle_area(){
        ShapeRefactorStratergy rectangle = new ShapeRefactorStratergy(ShapeType.RECTANGLE, 100, 50);
//        rectangle.type = ShapeType.RECTANGLE;
//        rectangle.width = 100;
//        rectangle.height = 50;

        assertThat(rectangle.calculateArea(), equalTo(5000d));
    }

    @Test
    public void should_return_square_area(){
        ShapeRefactorStratergy square = new ShapeRefactorStratergy(ShapeType.SQUARE, 100,0);
//        square.type = ShapeType.SQUARE;
//        square.width = 100;

        assertThat(square.calculateArea(), equalTo(10000d));
    }

    @Test
    public void should_return_triangle_area(){
        ShapeRefactor triangle = new ShapeRefactor();
        triangle.type = ShapeType.TRIANGLE;
        triangle.width = 100;
        triangle.height = 50;

        assertThat(triangle.calculateArea(), equalTo(2500d));
    }

    @Test
    public void should_return_exception_for_unknow_shape(){
        ShapeRefactor unknow = new ShapeRefactor();
        unknow.type = ShapeType.OTHER;
        unknow.width = 100;
        unknow.height = 50;

        Exception ex = assertThrows(IllegalArgumentException.class, ()-> unknow.calculateArea());
        assertThat(ex.getMessage(), equalTo("Unknow shape"));
    }
}
