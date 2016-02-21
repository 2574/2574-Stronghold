package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
import org.usfirst.frc.team2574.generalLee.commands.TeleWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */


public class Winch extends Subsystem {
	private static CANTalon winchTal = new CANTalon(RobotMap.winchTalonid);
	private static Servo ratchet = new Servo(RobotMap.ratchetServoPWM);
	
	public static void initWinch() {
		winchTal.changeControlMode(CANTalon.TalonControlMode.Position);
		winchTal.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	winchTal.configEncoderCodesPerRev(360);
    	
    	winchTal.setVoltageRampRate(10);
    	double kP = 0.25;
    	double kI = 0.00005;
    	double kD = 0.0;
    	winchTal.setPID(kP, kI, kD);
    	
    	winchTal.reverseSensor(false);
    	winchTal.reverseOutput(true);
    	winchTal.setEncPosition(0);
    	winchTal.enableControl();
	}
	
	public void tempInit() {
		winchTal.configEncoderCodesPerRev(360);
		winchTal.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		winchTal.setEncPosition(0);
	}
	
	public void zero() {
		winchTal.setEncPosition(0);
	}
	
	public static void ratchetSet(double pos) {
		ratchet.set(pos);
		
	}
	
	public static void set(double pos) {
		winchTal.set(pos);
		SmartDashboard.putNumber("WinchSP", pos);
		
	}
	
	public static double getPos() {
		return winchTal.getPosition();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new TeleWinch());
    }
}

