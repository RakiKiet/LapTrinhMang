import java.io.File;
import java.io.IOException;

public class XuLyFile {
    public static void taoThuMuc(String path){
        // Khai bao ra file moi
        File file = new File(path);

        if(!file.exists()) { // exists => kiểm tra đã tồn tại hay chưa?
            // Tạo thư mục
            // file.mkdir(); // make directory
            file.mkdirs(); // tạo nhiều thư mục cùng lúc
        }else{
            System.out.println("Thư mục đã tồn tại!");
        }
    }

    public static void taoTapTin(String path){
        File file = new File(path);
        if(!file.exists()){
            try{
                file.createNewFile();
            }
            catch(IOException e){
                System.out.println("Gặp lỗi IOException!");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Tập tin đã tồn tại!");
        }
    }

    public static void xoa(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete(); // Xóa
        }
        else{
            System.out.println("Tập tin / Thư mục không tồn tại!");
        }
    }

    public static void xoaTatCa(String path){
        File file = new File(path);
        if(file.exists()){
            // Sử dụng đệ qui
            if(file.isDirectory()){ // Nếu file là thư mục
                //Xóa nội dung bên trong
                File[] files = file.listFiles(); // lấy danh sách các file con
                for (File f : files){
                    xoaTatCa(f.getAbsolutePath()); // Tiếp tục đệ quy để xóa dựa trên đường dẫn tuyệt đối
                }
            }

            // Xóa chính bản thân nó
            if(file.delete()){ // thực hiện hành động xóa và file thành công
                System.out.println("Đã xóa file: " + path);
            }
            else{
                System.out.println("Không thể xóa file: " + path);
            }
        }
        else{
            System.out.println("Tập tin / Thư mục không tồn tại!");
        }
    }

    public static void hienThiCayThuMucChiTiet(String path, int level){
        File file = new File(path);
        for(int i = 0; i < level; i++){
            System.out.print("\t");
        }
        if(file.isFile()){ // Kiểm tra file là tập tin
            System.out.println("|__" + file.getName());
        }
        else{
            System.out.println("|__" + file.getName());
            // Tiếp tục đệ quy để hiện thị các mục con bên trong
            File[] files = file.listFiles();
            for(File f : files){
                hienThiCayThuMucChiTiet(f.getAbsolutePath(), level + 1);
            }
        }
    }

    public static void hienThiCayThuMuc(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File không tồn tại!");
            return; // Dừng lương hàm
        }
        hienThiCayThuMucChiTiet(path, 0);
    }

    public static void kietTraThongTin(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File không tồn tại!");
        }
        System.out.println("THÔNG TIN CHI TIẾT: ");
        System.out.println("Tên File: " + file.getName());
        System.out.println("Loại: " + (file.isFile()?"Tập tin":"Thư mục"));
        // System.out.println("Lưu trữ: " + file.getTotalSpace());
        System.out.println("File ẩn: " + file.isHidden());
    }

    public static void main(String[] args) {
        // String path = "D:\\BaiTapDNTU\\temp";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\dir1\\dir2\\dir3";
        // XuLyFile.taoThuMuc(path);

        // String path = "D:\\temp\\BAITAP.docx";
        // XuLyFile.taoTapTin(path);

        // String path = "D:\\temp\\baitap\\BAITAP.DOCX";
        // XuLyFile.taoTapTin(path);

        // String path = "D:\\BaiTapDNTU\\temp\\text.txt";
        // XuLyFile.xoa(path);

        // String path = "D:\\BaiTapDNTU\\temp";
        // XuLyFile.xoaTatCa(path);

        // XuLyFile.hienThiCayThuMuc("D:\\temp");
        XuLyFile.kietTraThongTin("D:\\temp\\BAITAP.docx");
    }
}