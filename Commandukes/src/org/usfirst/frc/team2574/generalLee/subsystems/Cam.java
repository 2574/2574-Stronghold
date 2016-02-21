package org.usfirst.frc.team2574.generalLee.subsystems;

import org.usfirst.frc.team2574.generalLee.RobotMap;
import org.usfirst.frc.team2574.generalLee.commands.TeleCam;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cam extends Subsystem {
    private static Servo camServo = new Servo(RobotMap.camServoPWM);
    private static CameraServer server = CameraServer.getInstance();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public static void camPos(double pos) {
    	camServo.set(pos);
    }
    
    public static void runCam() {
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleCam());
    }
}

