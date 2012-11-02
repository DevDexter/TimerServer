package com.timer.packets.navigator;

import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class GETFLATINFO implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		Handler.Conn.SendData("#FLATINFO{{13}}i=1282{{13}}n=Suelake donate room{{13}}o=Joshy{{13}}m=open{{13}}u=30000{{13}}w=1{{13}}t=127.0.0.1{{13}}d=You donate i will give v40 emulator!{{13}}a=0##");
	}

}
