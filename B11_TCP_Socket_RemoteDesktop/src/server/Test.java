package server;

public class Test {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("shutdown -a");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
