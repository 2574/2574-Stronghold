package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.commands.ReadPower;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Power extends Subsystem {
    private static PowerDistributionPanel pd = new PowerDistributionPanel();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static double getCurrent(int chan) {
    	return pd.getCurrent(chan);
    }
    
    public static double getCurrent() {
    	return pd.getTotalCurrent();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ReadPower());
    }
}

