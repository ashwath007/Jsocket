import java.io.*;
import java.net.*;

public class Main
{
    public final static int PORT=7777; 
    public static void main(String args[])
    {
          String hostname="localhost";
          try
          {
                InetAddress in=InetAddress.getByName(hostname);
                BufferedReader userIn=new BufferedReader(new InputStreamReader(System.in));
                DatagramSocket ds=new DatagramSocket();
                while(true)
                {
                           System.out.println("Send a message to Server : ");
                           String s=userIn.readLine();
                    if(s.equals("end"))
                                        break;
                                         
                          
                           byte [] data=s.getBytes();
                           DatagramPacket dp=new DatagramPacket(data,data.length,in,PORT);
                           ds.send(dp);
                           byte []buf=new byte[20];
                           DatagramPacket dp2=new DatagramPacket(buf,buf.length);
                           ds.receive(dp2);
                           String ln=new String(dp2.getData(),0,dp2.getLength());
                           System.out.println("Server:"+ln);
                                       


                 }
           } 
                  
            catch(IOException e)
            {
                    System.out.println(e);
            }
             
      }      
    }