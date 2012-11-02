package com.timer.packets.handshake;

import com.timer.Framework;
import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class GETAVAILABLESETS implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		Handler.Conn.SendData("AVAILABLESETS " + (char)13 + Framework.NORMAL_AVAILABLESETS);
	}

}
