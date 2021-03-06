package org.usfirst.frc.team2574.generalLee;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    public static int leftMotor0id = 4;
    public static int leftMotor1id = 6;
    
    public static int rightMotor0id = 3;
    public static int rightMotor1id = 5;
    
    public static int mastTal0id = 1;
    public static int mastTal1id = 2;
    
    public static int winchTalonid = 7;
    
    public static int frontArmTalPWM = 7;
    public static int ballSuckerTalPWM = 8;
    
    public static int ratchetServoPWM = 6;
    public static int camServoPWM = 5;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
