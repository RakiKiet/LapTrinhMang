import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        // In bang cuu chuong
        // nhap x = 5
        // 5 x 1 = 5
        // 5 x 2 = 10
        // ...
        // for
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giá trị x: ");
        int x = sc.nextInt();
        for (int i = x; i <= x; i++){
            for (int j = 1; j < 11; j++){
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println("------------");
        }
    }
}
