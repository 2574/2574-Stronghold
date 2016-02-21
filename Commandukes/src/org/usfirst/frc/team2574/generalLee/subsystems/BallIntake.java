package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
import org.usfirst.frc.team2574.generalLee.commands.SuckBalls;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {
    private static Talon ballRollerTal = new Talon(RobotMap.frontArmTalPWM);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static void set(double speed) {
    	ballRollerTal.set(speed);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

