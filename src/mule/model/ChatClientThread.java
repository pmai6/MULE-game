package mule.model;
import java.net.*;
import java.io.*;

/**
 * Created by ryyanj on 12/2/15.
 */

public class ChatClientThread extends Thread
{  private Socket           socket   = null;
    private ChatClient       client   = null;
    public DataInputStream  streamIn = null;

    public ChatClientThread(ChatClient _client, Socket _socket)
    {  client   = _client;
        socket   = _socket;
        open();
        start();
    }
    public void open()
    {  try
    {  streamIn  = new DataInputStream(socket.getInputStream());
    }
    catch(IOException ioe)
    {  System.out.println("Error getting input stream: " + ioe);
        client.stop();
    }
    }
    public void close()
    {  try
    {  if (streamIn != null) streamIn.close();
    }
    catch(IOException ioe)
    {  System.out.println("Error closing input stream: " + ioe);
    }
    }
    public void run()
    {  while (true)
    {  try
    {
        client.handle(streamIn.readUTF());
    }
    catch(IOException ioe)
    {  System.out.println("Listening error: " + ioe.getMessage());
        client.stop();
    }
    }
    }
}

