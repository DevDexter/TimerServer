package com.timer.packets.navigator;

import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class SUSERF implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		Handler.Conn.SendData("FLAT_RESULTS{{13}}1282{{9}}Suelake donate room{{9}}Joshy{{9}}open{{9}}127.0.0.1{{9}}0{{9}}x{{9}}You donate i will give v40 emulator!");
	}

}
