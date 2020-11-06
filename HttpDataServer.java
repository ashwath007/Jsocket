import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
public class HttpDataServer {
public static void main(String args[]){
try {
ServerSocket server=new ServerSocket(9999);
System.out.println("Server Waiting for image");
Socket socket=server.accept();
System.out.println("Client connected.");
/*Reading the port 9999 using InputStream*/
InputStream in = socket.getInputStream();
DataInputStream dis = new DataInputStream(in);
int len = dis.readInt();
System.out.println("Image Size: " + len/1024 + "KB");
byte[] data = new byte[len];
dis.readFully(data);
dis.close();
in.close();
InputStream ian = new ByteArrayInputStream(data); //Converting byte

BufferedImage bImage = ImageIO.read(ian);//byte outputStream to

JFrame f = new JFrame("Server");
f.setBounds(50, 100, 300, 300);
ImageIcon icon = new ImageIcon(bImage); 
JLabel l = new JLabel();
l.setIcon(icon);
f.add(l);
f.pack();
f.setVisible(true);
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
 }
}