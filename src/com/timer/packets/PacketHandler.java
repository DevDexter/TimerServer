package com.timer.packets;

import com.timer.Framework;
import com.timer.RC4;
import com.timer.net.TCPConnection;
import com.timer.packets.handshake.*;
import com.timer.packets.navigator.*;

import java.io.IOException;
import java.util.*;

public class PacketHandler {
	public TCPConnection Conn;
	private Map<String, IEvent> Packets = new HashMap<String, IEvent>();
	public RC4 Crypto;
	public String Extras;
	
	public Habbo
	
	public PacketHandler(TCPConnection Conn)
	{
		this.Conn = Conn;
		
		this.Packets.put("VERSIONCHECK", new VERSIONCHECK());
		this.Packets.put("GETAVAILABLESETS", new GETAVAILABLESETS());
		this.Packets.put("LOGIN", new LOGIN());
		this.Packets.put("GETADFORME", new GETADFORME());
		this.Packets.put("SUSERF", new SUSERF());
		this.Packets.put("GETFLATINFO", new GETFLATINFO());
		
		this.Packets.put("GETALLUNITS", new GETALLUNITS());
	}
	
	public void Handle(int Type, char[] Data) throws IOException
	{	
		if (this.Crypto != null)
		{
			Data = this.Crypto.decipher(Data);
		}
		
        // 256 = enterprise server
        // 257 = room server
        // 258 = room directory
        String serverType = null;
        
        if (Type == 256)
        {
                serverType = "ENTERPRISE";
        }
        else if (Type == 257)
        {
                serverType = "ROOM";
        }
        else if (Type == 258)
        {
                serverType = "ROOM_DIRECTORY";
        }
		
		 if (Type == 256 || Type == 257)
         {
                 // Filter out '#', it's EOF for server>client messages (security issue)
                 for (int i = 0; i < Data.length; i++)
                 {
                         if (Data[i] == '#')
                         {
                             Data[i] = '?';
                         }
                 }
                
                 
                 String Packet_Data = new String(Data);
                 String Header = Packet_Data.split(" ")[0];
                 this.Extras = "";
                 
                 for(int i = 0; i < Packet_Data.split(" ").length; i++)
                 {
                	 if (i == 0)
                		 continue;
                	 
                	 if (Packet_Data.split(" ")[i].contains("#"))
                		 break;
                	 
                	 for (char Char : Packet_Data.split(" ")[i].toCharArray())
                	 {
                		 if (Char == '#')
                			 break;
                		 
                		 Extras += Char;
                	 }
                	 
                	 Extras += " ";
                 }
                 
                 System.out.println("[@" + serverType + "] -> " + Packet_Data);
                 
                 if (Packets.containsKey(Header))
                	 Packets.get(Header).Handle(this);
                 
                 switch(Header)
                 {
                 
                 case "TRYFLAT":
                 {
                	 break;
                 }
                 
                 case "G_HMAP":
                 {
                     Conn.SendData("FLATPROPERTY floor/111");
                     Conn.SendData("FLATPROPERTY wallpaper/201");
                	 Conn.SendData("HEIGHTMAP xxxxxxxxxxxx{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxx0000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxx000000x{{13}}xxxxxxxxxxxx{{13}}");
                	 break;
                 }
                 
                 case "G_USRS":
                 {
                	 Conn.SendData("USERS");
                	 break;
                 }
                 
                 case "G_OBJS":
                 {
                	 Conn.SendData("OBJECTS WORLD 0 model_a{{13}}1 left_wallpart_0 3 1 0 0{{13}}2 left_wallpart_0 3 2 0 0{{13}}3 left_wallpart_0 3 3 0 0{{13}}4 left_wallpart_0 3 4 0 0{{13}}5 left_wallpart_0 3 6 0 0{{13}}6 left_wallpart_0 3 7 0 0{{13}}7 left_wallpart_0 3 8 0 0{{13}}8 left_wallpart_0 3 9 0 0{{13}}9 left_wallpart_0 3 10 0 0{{13}}10 left_wallpart_0 3 11 0 0{{13}}11 left_wallpart_0 3 12 0 0{{13}}12 left_wallend_0 3 13 0 0{{13}}13 left_wallmask_0 3 5 0 0{{13}}14 right_wallpart_0 4 0 0 2{{13}}15 right_wallpart_0 5 0 0 2{{13}}16 right_wallpart_0 6 0 0 2{{13}}17 right_wallpart_0 5 0 0 2{{13}}18 right_wallpart_0 7 0 0 2{{13}}19 right_wallpart_0 8 0 0 2{{13}}20 right_wallpart_0 9 0 0 2{{13}}21 right_wallpart_0 10 0 0 2{{13}}22 right_wallend_0 11 0 0 2");
                	 Conn.SendData("ACTIVE_OBJECTS");
                	 break;
                 }
                 
                 case "G_ITEMS":
                 {
                	 Conn.SendData("ITEMS");
                	 break;
                 }
                 
                 case "G_STAT":
                 {
                	 Conn.SendData("YOUARECONTROLLER");
                	 Conn.SendData("YOUAREOWNER");
                	 Conn.SendData("USERS{{13}}a=2645{{13}}n=Quartz{{13}}f=1100118001270012900121001{{13}}s=M{{13}}l=3 5 0{{13}}c=123");
                	 Conn.SendData("STATUS{{13}}Quartz 3,5,0,0,0/flatctrl useradmin/mod H");
                	 break;
                 }
                 
                 case "GCIX":
                 {
                	 Conn.SendData("C_I{{13}}1{{9}}Frontpage");
                	 break;
                 }
                 
                 case "GCAP":
                 {
                	 Integer.parseInt(Extras.split("/")[2]);
                	 break;
                 }
                 
                 case "SHOUT":
                 {
                	 String Say = Extras;
                	 
                	 Conn.SendData("SHOUT Quartz " + Say);
                	 break;
                 }
                 
                 case "CHAT":
                 {
                	 String Say = Extras;
                	 
                	 Conn.SendData("CHAT Quartz " + Say);
                	 break;
                 }
                 
                 case "GETSTRIP":
                 {
                	 Conn.SendData("STRIPINFO |33097|blunk|S|0|present_gen4|Gift|181:*::Gift from Suelake.com|1|1|0,0,0/|33098|blunk|S|1|present_gen6|Gift|127:*::Gift from Suelake.com|1|1|0,0,0/|33099|blunk|S|2|present_gen1|Gift|134:*::Gift from Suelake.com|1|1|0,0,0/{{13}}3");
                	 break;
                 }
                 
                 }
         }
		 else
		 {
			  // Decode data
             int[] decoded = Framework.DecodeSpecialCharArr(Data);
             int spaceID = decoded[1];
             int doorID = decoded[2];
            
             System.out.println("[@ROOM_DIRECTORY] <-- space ID: " + spaceID + ", door ID: " + doorID);
            
             // ROOM_DIRECTORY successfully received data!
             Conn.SendData("OPC_OK");
            
             // If this space is not a flat, we can skip all access check handlers etc and go to space immediately
			 Conn.SendData("FLAT_LETIN");
             Conn.SendData("ROOM_READY model_a " + spaceID);
             
             Conn.SendData("FLATPROPERTY floor/111");
             Conn.SendData("FLATPROPERTY wallpaper/201");
		 }
	}
}
