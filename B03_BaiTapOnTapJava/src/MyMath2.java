public class MyMath2 {
    public static double sum(double a, double b){
        return a+b;
    }

    public static void main(String[] args) {
        MyMath2 mm2 = new MyMath2();
        double result2 = mm2.sum(39, 42);
        System.out.println("Giá trị bằng " + result2);
    }
}