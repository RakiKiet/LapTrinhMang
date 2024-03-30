import java.net.NetworkInterface;
import java.util.Enumeration;

public class InterfaceLister {
    public static void main(String[] args) {
        try{
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            //Kiểm tra con interface nào khác hay không
            while(interfaces.hasMoreElements()){
                //Lấy ra phần tử và ép kiểu
                NetworkInterface ni = (NetworkInterface) interfaces.nextElement();
                System.out.println(ni);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
