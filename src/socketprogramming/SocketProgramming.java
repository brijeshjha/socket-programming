package socketprogramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketProgramming{

 public static void main(String[] args) throws IOException {

       new Thread()
	   {
	    public void run()
		{
                try {
                    ServerSocket soc=new ServerSocket(5432);
                    Socket skt=soc.accept();
                    Scanner scan=new Scanner(skt.getInputStream());
                    String msgFromClient=null;
                    while(scan.hasNextLine())
                    {
                        msgFromClient=scan.nextLine();
                    }
                    System.out.println("Client says:"+msgFromClient);
                } catch (IOException ex) {
                }
		}
	   }.start();
	   
	   
	   new Thread()
	   {
	    public void run()
		{
                try {
                    ServerSocket soc=new ServerSocket(9999);
                    Socket skt=soc.accept();
                    Scanner scan=new Scanner(skt.getInputStream());
                    String msgFromClient=null;
                    while(scan.hasNextLine())
                    {
                        msgFromClient=scan.nextLine();
                    }
                    System.out.println("Client says:"+msgFromClient);
                } catch (IOException ex) {
                }
		}
	   }.start();
       
 }

}