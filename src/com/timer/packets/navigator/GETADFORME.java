package com.timer.packets.navigator;

import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class GETADFORME implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		Handler.Conn.SendData("ADVERTISEMENT 0");
	}

}
