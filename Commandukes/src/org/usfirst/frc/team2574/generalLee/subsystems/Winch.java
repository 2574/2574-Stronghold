package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
//import org.usfirst.frc.team2574.generalLee.commands.OpenRatchet;
import org.usfirst.frc.team2574.generalLee.commands.winch.TeleWinch;
import org.usfirst.frc.team2574.generalLee.commands.winch.ZeroWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
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
	private static DigitalInput lowerLim = new DigitalInput(0);
	private static boolean init = false; 
	
	public static void initWinch() {
		//winchTal.changeControlMode(CANTalon.TalonControlMode.Position);
		winchTal.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	winchTal.configEncoderCodesPerRev(360);
    	
    	winchTal.setVoltageRampRate(15);
    	double kP = 0.28;
    	double kI = 0.00006;
    	double kD = 0.0;
    	winchTal.setPID(kP, kI, kD);
    	
    	winchTal.reverseSensor(false);
    	winchTal.reverseOutput(true);
    	winchTal.setEncPosition(0);
    	//winchTal.setReverseSoftLimit(-0.05);
    	init = true;
    	//winchTal.enableControl();
	}
	
	public static void setInit() {
		init = true;
		
	}
	
	public static double ratchetGet() {
		return ratchet.get();
	}
	
	public void tempInit() {
		winchTal.configEncoderCodesPerRev(360);
		winchTal.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		winchTal.setEncPosition(0);
	}
	
	public static boolean lowLim() {
		return lowerLim.get();
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
	public static void manual() {
		winchTal.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		init = false;
	}
	
	public static double getCurrent() {
		return winchTal.getOutputCurrent();
	}
	
	public static boolean init() {
		return init;
	}
	
	public static double getPos() {
		return winchTal.getPosition();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ZeroWinch());
    	//setDefaultCommand(new OpenRatchet());
    	
    }
}

