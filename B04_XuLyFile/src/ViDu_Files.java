import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ViDu_Files {
    public static void main(String[] args) {
        Path source = Paths.get("D:\\BaiTapDNTU\\LapTrinhMang\\LyThuyet\\Bai 00 GIOI THIEU.pptx");
        Path newdir = Paths.get("D:\\temp");

        try{
            Files.copy(source, newdir.resolve(source.getFileName()));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
