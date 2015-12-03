package mule.model;
import mule.view.GameController;

import java.net.*;
import java.io.*;

public class ChatClient implements Runnable
{  private static Socket socket              = null;
    private Thread thread              = null;
    private DataInputStream  console   = null;
    private static DataOutputStream streamOut = null;
    private static ChatClientThread client    = null;
    private static String serverMsg = null;

    public static void connect(String serverName, int serverPort)
    {  System.out.println("Establishing connection. Please wait ...");
        try
        {  socket = new Socket(serverName, serverPort);
            System.out.println("Connected: " + socket);
            open(); }
        catch(UnknownHostException uhe)
        {  System.out.println("Host unknown: " + uhe.getMessage()); }
        catch(IOException ioe)
        {  System.out.println("Unexpected exception: " + ioe.getMessage()); }
    }
    public static void send(String stuff)
    {
        try
        {
            //streamOut.writeUTF(GameController.enterChat.getText());
            //streamOut.flush(); GameController.enterChat.setText("");
            streamOut.writeUTF(stuff);
            streamOut.flush(); //GameController.enterChat.setText("");
        }
        catch(IOException ioe)
        {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }
    public static void close()
    {
        try
        {
            if (streamOut != null)  streamOut.close();
            if (socket    != null)  socket.close(); }
        catch(IOException ioe)
        {
            println("Error closing ...");
        }
            client.close();
            client.stop();
    }
    public static void open()
    {
        try
        {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client = new ChatClientThread(new ChatClient(), socket); }
        catch(IOException ioe)
        {
            println("Error opening output stream: " + ioe);
        }
    }
    public void run()
    {  while (thread != null)
    {  try
    {  streamOut.writeUTF(console.readLine());
        streamOut.flush();
    }
    catch(IOException ioe)
    {  System.out.println("Sending error: " + ioe.getMessage());
        stop();
    }
    }
    }
    public void handle(String msg)
    {  if (msg.equals(".bye")) {
            System.out.println("Good bye. Press RETURN to exit ...");
            stop();
    }
    else {
        System.out.println(msg);
        serverMsg = msg;
        }

    }

    public static String returnServerMsg() {
        return serverMsg;
    }


    public void start() throws IOException
    {  console   = new DataInputStream(System.in);
        streamOut = new DataOutputStream(socket.getOutputStream());
        if (thread == null)
        {  client = new ChatClientThread(this, socket);
            thread = new Thread(this);
            thread.start();
        }
    }
    public void stop()
    {  if (thread != null)
    {  thread.stop();
        thread = null;
    }
        try
        {  if (console   != null)  console.close();
            if (streamOut != null)  streamOut.close();
            if (socket    != null)  socket.close();
        }
        catch(IOException ioe)
        {  System.out.println("Error closing ..."); }
        client.close();
        client.stop();
    }

    private static void println(String msg)
    {
        //GameController.chatField.appendText(msg + "\n");
    }
}