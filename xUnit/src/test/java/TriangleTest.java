import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    Triangle triangle= new Triangle();
    @Test
    @DisplayName("Test with zero size sides")
    public void allSidesZero(){
        assertFalse(Triangle.isTriangle(0, 0, 0));
    }

    @Test
    @DisplayName("Test with all negative size sides")
    public void allSidesNegative(){
        assertFalse(Triangle.isTriangle(-18, -12, -5));
    }

    @Test
    @DisplayName("Test with all negative size sides")
    public void oneSideZero(){
        assertFalse(Triangle.isTriangle(0, 55, 44));
    }

    @Test
    @DisplayName("Test with one negative size side")
    public void oneSideNegative(){
        assertFalse(Triangle.isTriangle(-10, 5, 3));
    }

    @Test
    @DisplayName("Test with equilateral triangle")
    public void equilateralTriangle(){
        assertTrue(Triangle.isTriangle(7.7, 7.7, 7.7));
    }

    @Test
    @DisplayName("Test with isosceles triangle")
    public void isoscelesTriangle(){
        assertTrue(Triangle.isTriangle(7.7, 5.5, 7.7));
    }

    @Test
    @DisplayName("Test with right triangle")
    public void rightTriangleSides(){
        assertTrue(Triangle.isTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Test with versatile triangle")
    public void versatileTriangle(){
        assertTrue(Triangle.isTriangle(2.56, 12.3, 14.12));
    }

    @Test
    @DisplayName("One side is Larger than the sum of others test")
    public void sideLargerThanSumOfOthers(){
        assertFalse(Triangle.isTriangle(2, 4, 50));
    }

    @Test
    @DisplayName("One side is Equal to the sum of two others test")
    public void sideEqualToSumOfOthers(){
        assertFalse(Triangle.isTriangle(12, 12, 24));
    }
}
