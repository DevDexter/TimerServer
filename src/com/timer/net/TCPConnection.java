package com.timer.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import com.timer.packets.PacketHandler;

public class TCPConnection implements Runnable {

	private Socket Socket;
	private BufferedReader DataIn;
	@SuppressWarnings("unused")
	private BufferedWriter DataOut;
	private Thread ReceiveThread;
	private boolean Keepalive = true;
	private boolean FirstPacket = true;
	private boolean m_macintosh;
	public PacketHandler Handler;
	
	public TCPConnection(Socket Socket) throws UnsupportedEncodingException, IOException
	{
		this.Socket = Socket;
		this.DataIn = new BufferedReader(new InputStreamReader(this.Socket.getInputStream(), "iso-8859-1"));
		this.DataOut = new BufferedWriter(new OutputStreamWriter(this.Socket.getOutputStream()));
		
		  byte[] greet = new byte[8];
          greet[0] = (byte)'#';
          greet[1] = (byte)'H';
          greet[2] = (byte)'E';
          greet[3] = (byte)'L';
          greet[4] = (byte)'L';
          greet[5] = (byte)'O';
          greet[6] = (byte)'#';
          greet[7] = (byte)'#';
          this.Socket.getOutputStream().write(greet);
          
          m_macintosh = (this.Socket.getInputStream().read() == 194);
		
          this.Handler = new PacketHandler(this);
          
		this.ReceiveThread = new Thread(this);
		this.Keepalive = true;
		this.Start();
	}
	
	public void Start()
	{
		this.ReceiveThread.start();
	}
	
	public void SendData(String Data)
	{
		try {
			this.Socket.getOutputStream().write(("#" + Data.replace("{{13}}", "" + (char)13).replace("{{9}}", "" + (char)9) + (char)13 + "##").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try
		{
		// TODO Auto-generated method stub
		while (this.Keepalive)
		{
			try
			{
			 char[] header = new char[5];
			 
             for (int i = 0; i < header.length; i++)
             {
                 header[i] = (char)this.DataIn.read();
                     
                 if(this.FirstPacket)
                 {
                	 header[0] = 128;
                	 
                	 if(!this.m_macintosh)
                	 {
                		 header[1] = 128;
                		 i++;
                	 }
                	 
                	 this.FirstPacket = false;
                 }
             }
             
             // Determine message type and message length
             int msgType = header[0] + header[1];
             int msgLength = ((header[4] - 128) + ((header[3] - 128) * 128) + ((header[2] - 128) * 16384));
            
            // Read in actual data and verify if all data has been read
            char[] msgData = new char[msgLength];
            this.DataIn.read(msgData);
            //System.out.println("len: " + msgLength + " type: " + msgType + " data: " + new String(msgData));
            this.Handler.Handle(msgType, msgData);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		}
		catch (Exception ex)
		{
		this.Keepalive = false;
		}
	}
	
}
