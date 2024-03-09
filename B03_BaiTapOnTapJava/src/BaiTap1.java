import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        double x1, x2;
        double delta = 0;
        System.out.print("Nhập giá trị a: ");
        a = sc.nextFloat();
        System.out.print("Nhập giá trị b: ");
        b = sc.nextFloat();
        System.out.print("Nhập giá trị c: ");
        c = sc.nextFloat();
        if(a == 0) {
            System.out.println("a phải khác 0. Vui lòng nhập lại");
        }
        else {
            delta = Math.pow(b, 2) - 4 * a * c;
            if(delta < 0) {
                System.out.println("Phương trình vô nghiệm.");
            }
            else if(delta == 0) {
                x1 = x2 = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép x1 = x2 = " + x1);
            }
            else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }
}