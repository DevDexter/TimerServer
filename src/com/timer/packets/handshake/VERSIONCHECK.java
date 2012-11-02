package com.timer.packets.handshake;

import com.timer.FuseSecret;
import com.timer.RC4;
import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class VERSIONCHECK implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		String Key = FuseSecret.GenerateSecret();
		int ID = FuseSecret.SecretDecode(Key);
		
		Handler.Conn.SendData("SECRET_KEY " + Key);
		
		Handler.Crypto = new RC4(ID);
	}

}
