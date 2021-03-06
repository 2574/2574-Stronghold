package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;

import org.usfirst.frc.team2574.generalLee.commands.TeleMast;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Mast extends Subsystem {
    private static CANTalon mastTal0 = new CANTalon(RobotMap.mastTal0id);
    
    private static CANTalon mastTal1 = new CANTalon(RobotMap.mastTal1id);
    
    //private static Talon lifterTal = new Talon(RobotMap.lifterTalonPWM);
    
    //private static Servo ratchet = new Servo(RobotMap.ratchetServoPWM);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static void initPosPID() {
    	mastTal0.changeControlMode(CANTalon.TalonControlMode.Position);
    	mastTal0.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
    	mastTal0.configPotentiometerTurns(10);
    	mastTal0.setVoltageRampRate(10);
    	double kP = SmartDashboard.getNumber("P", 2.6);
    	double kI = SmartDashboard.getNumber("I", 0.00009);
    	double kD = SmartDashboard.getNumber("D", 0.3);
    	mastTal0.setPID(kP, kI, kD);
    	mastTal1.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
    	mastTal1.configPotentiometerTurns(10);
    	mastTal1.setVoltageRampRate(10);
    	mastTal1.setPID(kP, kI, kD);
    	mastTal1.changeControlMode(CANTalon.TalonControlMode.Position);
    	mastTal0.enableControl();
    	mastTal1.enableControl();
    	
    }
    
    
    
    public void initSpeedPID() {
    	
    }
    
    public static double position0() {
    	return mastTal0.getPosition();
    }
    
    public static double position1() {
    	return mastTal1.getPosition();
    }
    
    public static void set(double pos) {
    	mastTal0.set(pos);
    	mastTal1.set(pos - .25);
    }
    
    /*public static void lift(double speed) {
    	lifterTal.set(speed);
    }
    */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleMast());
    }
}

