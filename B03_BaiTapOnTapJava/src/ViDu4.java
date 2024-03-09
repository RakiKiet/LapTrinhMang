import java.util.Scanner;

public class ViDu4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Nhập giá trị x: ");
        x = sc.nextInt();
        String check = (x % 2 == 0)?"Số chẵn":"Số lẻ";
        System.out.println(check);
    }
}
