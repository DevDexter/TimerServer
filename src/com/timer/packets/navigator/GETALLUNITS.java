package com.timer.packets.navigator;

import com.timer.packets.IEvent;
import com.timer.packets.PacketHandler;

public class GETALLUNITS implements IEvent {

	@Override
	public void Handle(PacketHandler Handler) {
		// TODO Auto-generated method stub
		Handler.Conn.SendData("UNITS{{13}}1{{9}}1{{9}}Main Lobby{{9}}0{{9}}100{{9}}Main Lobby{{9}}0{{9}}100{{9}}{{13}}2{{9}}2{{9}}Basement Lobby{{9}}0{{9}}40{{9}}Basement Lobby{{9}}0{{9}}40{{9}}{{13}}3{{9}}3{{9}}Median Lobby{{9}}0{{9}}40{{9}}Median Lobby{{9}}0{{9}}40{{9}}{{13}}4{{9}}4{{9}}Skylight Lobby{{9}}0{{9}}25{{9}}Skylight Lobby{{9}}0{{9}}25{{9}}{{13}}5{{9}}5{{9}}Theatredome{{9}}0{{9}}100{{9}}Theatredome{{9}}0{{9}}100{{9}}{{13}}6{{9}}6{{9}}McBlunk{{9}}0{{9}}50{{9}}McBlunk{{9}}0{{9}}50{{9}}{{13}}7{{9}}7{{9}}Club Massiva{{9}}0{{9}}40{{9}}Club Massiva{{9}}0{{9}}40{{9}}{{13}}9{{9}}9{{9}}Club Massiva: dancefloor{{9}}0{{9}}100{{9}}Club Massiva: dancefloor{{9}}0{{9}}100{{9}}{{13}}10{{9}}10{{9}}Pr0n Cinema{{9}}0{{9}}50{{9}}Pr0n Cinema{{9}}0{{9}}50{{9}}{{13}}18{{9}}18{{9}}The Dirty Fuck Pub{{9}}0{{9}}40{{9}}The Dirty Fuck Pub{{9}}0{{9}}40{{9}}{{13}}19{{9}}19{{9}}Lido A{{9}}0{{9}}50{{9}}Lido A{{9}}0{{9}}50{{9}}{{13}}20{{9}}20{{9}}Lido B{{9}}0{{9}}45{{9}}Lido B{{9}}0{{9}}45{{9}}{{13}}26{{9}}26{{9}}Slinky Helsinki - A{{9}}0{{9}}45{{9}}Slinky Helsinki - A{{9}}0{{9}}45{{9}}{{13}}27{{9}}27{{9}}Slinky Helsinki - B{{9}}0{{9}}45{{9}}Slinky Helsinki - B{{9}}0{{9}}45{{9}}{{13}}31{{9}}31{{9}}Hotel Kitchen{{9}}0{{9}}25{{9}}Hotel Kitchen{{9}}0{{9}}25{{9}}{{13}}33{{9}}33{{9}}Rooftop Rumble{{9}}0{{9}}35{{9}}Rooftop Rumble{{9}}0{{9}}35{{9}}{{13}}1000{{9}}1000{{9}}Placeholder{{9}}0{{9}}25{{9}}Placeholder{{9}}0{{9}}25{{9}}");
	}

}
