public class TriangleFunction {
    public static void main(String[] args) {

    functionOfGeron(4,4,12);

    }
    public static void functionOfGeron (int a, int b, int c) {
        int p = 0;
        int s = 0;
        p = (a + b + c) / 2;
        s = (p * (p - a) * (p - b) * (p - c));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(p);
        System.out.println("Area:"+s);
    }
}
