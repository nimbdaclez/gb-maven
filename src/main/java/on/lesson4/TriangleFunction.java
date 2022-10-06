package on.lesson4;

public class TriangleFunction {

    /*позитивный тест, 3 негативных теста (одна сторона из треугольника 0,одна из сторон отрицательное число, стороны не дают треугольник 2,5,100) */

    public static String TriangleFunction(int a, int b, int c) {

        if(a == 0 || b == 0 || c == 0 ) {
            return "One of the sides = 0";
        } else if(a==b && b==c) {
            return "Equilateral Triangle";
        } else if (a < 0 || b < 0 || c < 0){
            return "One of the sides < 0";
        } else if (a >= (b+c) || c >= (b+a) || b >= (a+c) ) {
            return "Not a Triangle";
        }
        return null;
    }

}
