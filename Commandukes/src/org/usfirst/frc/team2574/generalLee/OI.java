package org.usfirst.frc.team2574.generalLee;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team2574.generalLee.commands.ArmForward;
import org.usfirst.frc.team2574.generalLee.commands.ArmReverse;
import org.usfirst.frc.team2574.generalLee.commands.ArmStop;
//import org.usfirst.frc.team2574.generalLee.commands.ExampleCommand;
import org.usfirst.frc.team2574.generalLee.commands.InvertDriveCommand;
import org.usfirst.frc.team2574.generalLee.commands.Ratchet;
import org.usfirst.frc.team2574.generalLee.commands.SpitBalls;
import org.usfirst.frc.team2574.generalLee.commands.StopBalls;
import org.usfirst.frc.team2574.generalLee.commands.SuckBalls;
import org.usfirst.frc.team2574.generalLee.commands.winch.CurrentKill;
import org.usfirst.frc.team2574.generalLee.commands.winch.MastDown;
import org.usfirst.frc.team2574.generalLee.commands.winch.MastUp;
import org.usfirst.frc.team2574.generalLee.commands.winch.ZeroWinch;
import org.usfirst.frc.team2574.generalLee.commands.SuckBalls;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
    static Joystick joystick0 = new Joystick(0);
    static Joystick joystick1 = new Joystick(1);
    Button invertDrive = new JoystickButton(joystick0, 3); //change number eventually
    
    Button ballF = new JoystickButton(joystick0, 1);
    Button ballR = new JoystickButton(joystick0, 2);
    
    Button ArmF = new JoystickButton(joystick0, 6);
    Button ArmR = new JoystickButton(joystick0, 4);
    
    Button Mast0 = new JoystickButton(joystick0, 12);
    Button Mast1 = new JoystickButton(joystick0, 11);
    Button winchZero = new JoystickButton(joystick1, 8);
    Button ratchet = new JoystickButton(joystick0, 9);
    Trigger current = new Current();
    
    public OI() {
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    invertDrive.whenPressed(new InvertDriveCommand());
    ballF.whileHeld(new SuckBalls());
    ballF.whenReleased(new StopBalls());
    ballR.whenPressed(new SpitBalls());
    ballR.whenReleased(new StopBalls());
    
    ArmF.whileHeld(new ArmForward());
    ArmF.whenReleased(new ArmStop());
    ArmR.whenPressed(new ArmReverse());
    ArmR.whenReleased(new ArmStop());
    
    Mast0.whenPressed(new MastUp());
    Mast1.whenPressed(new MastDown());
    ratchet.whenPressed(new Ratchet());
    current.whenActive(new CurrentKill());
    
    //winchZero.whenPressed(new ZeroWinch());
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    }
    
    public static double getThrottle() {
    	return joystick0.getRawAxis(1);
    	
    }
    
    public static double getRotation() {
    	return joystick0.getRawAxis(2);
    }

	public static double getOut() {
		return joystick1.getRawAxis(0);
	}
	
	public static double getLift() {
		return joystick1.getRawAxis(2);
	}
	
	public static double getMast() {
		return joystick1.getRawAxis(3);
	}
	
	public static double getCam() {
		return joystick0.getRawAxis(3);
	}
	
	public static double getArm() {
		return joystick1.getRawAxis(1);
	}
}

