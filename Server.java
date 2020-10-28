import java.io.*;
import java.net.*;
import java.lang.*;
public class Server
{
       public final static int PORT=7777; 
       public static void main(String args[])
       {
          System.out.println("*************Stop and Wait************");

               String hostname="localhost";
               byte[] buf=new byte[60];
              try
             {
                      BufferedReader userIn=new BufferedReader(new InputStreamReader(System.in));
                      DatagramPacket dp=new DatagramPacket(buf,buf.length);
                      DatagramSocket ds=new DatagramSocket(PORT);
                       while(true)
                       {
                           ds.receive(dp);
                           String s=new String(dp.getData(),0,dp.getLength());
                           System.out.println("Client's Message  : "+s);
                           if(s.length()>0){
                
                            String sn="Acknowledgement Responce ";
                            if(sn.equals("end")) break;
                            byte[] data=sn.getBytes();
                            DatagramPacket op;
                            op=new DatagramPacket(data,data.length,dp.getAddress(),dp.getPort());            
                            ds.send(op);    
                           }
                        
             }
                 } 
                catch(IOException e)
                 {
                       System.out.println(e);
                 }
             
         }      
}
