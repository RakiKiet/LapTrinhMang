import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void copyFile(String src, String dest) {
        // Tạo ra một cái file mới
        // Từng bước đọc dữ liệu từ file cũ => ghi sang file mới
        File fileSrc = new File(src); // 1
        File fileDest = new File(dest);// 2
        try {
            if (!fileSrc.exists()) {
                System.out.println("File src không tồn tại!");
            } else {
                if (fileDest.exists()) {
                    System.out.println("File dest đã tồn tại, bạn có muốn ghi đè hay không(y/n)?");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.nextLine();
                    if (c.equals("n")) { // Nếu không muốn ghi đè thì ngưng chương trình
                        return;
                    }
                } else {
                    fileDest.createNewFile();
                }

                // Tạo stream để đọc dữ liệu
                FileInputStream fis = new FileInputStream(fileSrc);

                // Tạo stream ghi dữ liệu
                FileOutputStream fos = new FileOutputStream(fileDest);

                // Copy từng byte
                int b = 0;
                while(true){
                    b = fis.read(); // Đọc lên một byte

                    if(b==-1) break; // = -1 khi không có dữ liệu để đọc

                    fos.write(b); // ghi xuống file
                    fos.flush(); // ép dữ liệu được ghi xuống file ngay lập tức
                }
                fis.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileArr(String src, String dest){
        // Tạo ra một cái file mới
        // Từng bước một dữ liệu từ file cũ => ghi sang file mới
        File fileSrc = new File(src);
        File fileDest = new File(dest);
        try{
            if(!fileSrc.exists()){
                System.out.println("File src không tồn tại!");
            }
            else{
                if(fileDest.exists()){
                    System.out.println("File dest đã tồn tại, bạn có muốn ghi đè hay không(y/n)?");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.nextLine();
                    if (c.equals("n")) { // Nếu không muốn ghi đè thì dừng chương trình
                        return;
                    }
                }
                else {
                    fileDest.createNewFile();
                }

                // Tạo stream để đọc dữ liệu
                FileInputStream fis = new FileInputStream(fileSrc);

                // Tạo stream để ghi dữ liệu
                FileOutputStream fos = new FileOutputStream(fileDest);

                // Copy một lần 1MB
                byte[] arr = new byte[1024];
                while(true){
                    int n = fis.read(arr);// Đọc một mảng 1MB
                    if(n == -1) break;
                    fos.write(arr, 0, n);// Đọc được bao nhiêu thì ghi được bấy nhiêu dữ liệu
                    fos.flush();// ép dữ liệu được ghi xuống file ngay lập tức
                }
                fis.close();
                fos.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String src = "D:\\BaiTapDNTU\\LapTrinhMang\\LyThuyet\\Bai 04 QUAN LY LUONG VAO RA.pptx";
        String dest = "D:\\BaiTapDNTU\\Bai04_Copy.pptx";
        // copyFile(src, dest);
        copyFileArr(src, dest);
    }
}
