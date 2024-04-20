package server;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class HandleRequest extends Thread{
    private Socket socket;

    public HandleRequest(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));

            while (true) {
                String request = reader.readLine();
                System.out.println(request);
                if (request.equals("shutdown")) {
                    Runtime.getRuntime().exec("shutdown -s -t 3600");
                } else if (request.equals("restart")) {
                    Runtime.getRuntime().exec("shutdown -r -t 3600");
                } else if (request.equals("cancel")) {
                    Runtime.getRuntime().exec("shutdown -a");
                } else if (request.equals("screenshot")) {
                    Robot robot = new Robot();

                    //Take an image
                    BufferedImage screenshot = robot.createScreenCapture(new Rectangle(
                            Toolkit.getDefaultToolkit().getScreenSize()
                    ));

                    //Create data array
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "png", baos);
                    byte[] imageBytes = baos.toByteArray();
                    baos.close();

                    //Write data from baos to client
                    writer.println(imageBytes.length);
                    writer.flush();
                    os.write(imageBytes);
                    os.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
