package org.usfirst.frc.team2574.generalLee;

import org.usfirst.frc.team2574.generalLee.subsystems.Winch;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class Current extends Trigger {

	@Override
	public boolean get() {
		
		return (Winch.getCurrent() > 40 && !Winch.lowLim());
	}

}
