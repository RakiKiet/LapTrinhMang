public class MyMath {
    public double sum(double a, double b){
        return a + b;
    }

    public static void main(String[] args) {
        MyMath mm1 = new MyMath();
        double result = mm1.sum(5, 8);
        System.out.println("Giá trị bằng " + result);
    }
}
