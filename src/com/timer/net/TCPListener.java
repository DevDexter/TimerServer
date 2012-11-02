package com.timer.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * @author joshuab
 *
 */
public class TCPListener implements Runnable {
	
	public ServerSocket Socket;
	public Thread AcceptThread;
	private boolean Running;
	
	public TCPListener(String IP, int Port, int Backlog) throws IOException
	{
		this.Socket = new ServerSocket(Port, Backlog, InetAddress.getByName("localhost"));
		
		this.AcceptThread = new Thread(this);
		this.AcceptThread.start();
		
		this.Running = true;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		while (Running)
		{
		java.net.Socket newClient = null;
		
		try {
			newClient = this.Socket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if (newClient != null)
		{
			System.out.println("New connection: " + newClient.getRemoteSocketAddress());
			
			try {
				TCPConnection Conn = new TCPConnection(newClient);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	
}
