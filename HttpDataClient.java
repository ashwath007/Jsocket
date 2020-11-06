import java.net.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
public class HttpDataClient{
public static void main(String args[]) throws Exception{
Socket soc=new Socket("localhost",9999);
try {
/*Reading a image*/
System.out.println("Reading image from disk. ");
BufferedImage img = ImageIO.read(new
File("./two.jpg")); //Reading the image
ByteArrayOutputStream baos = new
ByteArrayOutputStream(); // Creating a baos to write image in byte outputstream
ImageIO.write(img, "jpg", baos); //Writing a image to byte

byte[] bytes = baos.toByteArray(); //Converting Byte

baos.close();//closing byteoutput stream
/*Sending a image to server*/
System.out.println("Sending image to server. ");
OutputStream out = soc.getOutputStream();
DataOutputStream dos = new DataOutputStream(out);
dos.writeInt(bytes.length);
dos.write(bytes, 0, bytes.length); 
System.out.println("Image sent to server. ");
dos.close();
out.close();
}
 catch (Exception e)
 {
 System.out.println("Exception: " + e.getMessage());
 soc.close();
 }
 soc.close();
}
}
