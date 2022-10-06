package homeWork4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static on.lesson4.TriangleFunction.TriangleFunction;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    /*позитивный тест, 3 негативных теста (одна сторона из треугольника 0,одна из сторон отрицательное число, стороны не дают треугольник 2,5,100) */
    final static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @DisplayName("Позитивный тест: равносторонний треугольник")
    public void positiveTest01(){
        assertEquals(TriangleFunction(1,1,1), "Equilateral Triangle");

    }
    @Test
    @DisplayName("Негативный тест: одна из сторон отрицальтельное число")
    public void negativeTest01(){
        assertEquals(TriangleFunction(0,1,1), "One of the sides = 0");
    }

    @Test
    @DisplayName("Негативный тест: одна из сторон отрицательное число")
    public void negativeTest02(){
        assertEquals(TriangleFunction(3,-3,3), "One of the sides < 0");

    }

    @Test
    @DisplayName("Негативный тест: стороны не дают треугольник")
    public void negativeTest03(){
        assertEquals(TriangleFunction(2,5,100), "Not a Triangle");
    }
}

