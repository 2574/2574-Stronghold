package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
import org.usfirst.frc.team2574.generalLee.commands.TeleArm;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FrontArm extends Subsystem {
    private static Talon frontArmTal = new Talon(RobotMap.frontArmTalPWM);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static void set(double speed) {
    	frontArmTal.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleArm());
    }
}

