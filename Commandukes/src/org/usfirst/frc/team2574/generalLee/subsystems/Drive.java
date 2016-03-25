package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
import org.usfirst.frc.team2574.generalLee.commands.StartDrive;
import org.usfirst.frc.team2574.generalLee.commands.TeleDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    private static CANTalon leftTal0 = new CANTalon(RobotMap.leftMotor0id);
    private static CANTalon leftTal1 = new CANTalon(RobotMap.leftMotor1id);
    private static CANTalon rightTal0 = new CANTalon(RobotMap.rightMotor0id);
    private static CANTalon rightTal1 = new CANTalon(RobotMap.rightMotor1id);
    private static boolean inverted = false;
    
    private static RobotDrive robotDrive = new RobotDrive(leftTal0, leftTal1,  rightTal0, rightTal1);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Drive() {
    	
    }
    
    public static void tankDrive(double leftPower, double rightPower) {
        
        	robotDrive.tankDrive(leftPower, rightPower);
        
    }
    
    public static void setSafety(boolean safe) {
    	robotDrive.setSafetyEnabled(safe);
    }
    
    public static void arcadeDrive(double throttle, double rotation) {
    	
    		robotDrive.arcadeDrive(throttle, rotation, false);
    	
    }
    
    public static void invert() {
    	leftTal0.setInverted(true);
    	leftTal1.setInverted(true);
    	rightTal0.setInverted(true);
    	rightTal1.setInverted(true);
    	inverted = true;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleDrive());
    }
}

