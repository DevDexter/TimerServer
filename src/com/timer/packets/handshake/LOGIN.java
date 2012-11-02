package com.timer.packets.handshake;

import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class LOGIN implements IEvent {

	@SuppressWarnings("unused")
	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		String Name = Handler.Extras.split(" ")[0];
		String Password = Handler.Extras.split(" ")[1];
		
		Handler.Conn.SendData("U_RTS{{13}}default{{13}}can_furni_chooser{{13}}can_use_special_room_layouts{{13}}can_trade{{13}}can_login{{13}}can_moonwalk{{13}}can_see_server_status{{13}}can_see_server_info{{13}}can_enter_others_rooms{{13}}can_buy_credits{{13}}can_access_stocks");
		Handler.Conn.SendData("OK");
		Handler.Conn.SendData("USEROBJECT{{13}}name=Quartz{{13}}email=alphastudios@anonyops.nl{{13}}birthday=23.05.1997{{13}}phoneNumber=+44{{13}}region=3{{13}}country=329{{13}}directMail=0{{13}}had_read_agreement=1{{13}}customData=123{{13}}sex=M{{13}}figure=1100118001270012900121001{{13}}badge_type=H");
	}

}
