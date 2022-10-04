package on.lesson4;

public class TriangleFunction {
    public static void main(String[] args) {

    }
    public TriangleFunction(int a, int b, int c) {
        int p = 0;
        double s;
        p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Triangle Area Is:"+s);
    }
}
