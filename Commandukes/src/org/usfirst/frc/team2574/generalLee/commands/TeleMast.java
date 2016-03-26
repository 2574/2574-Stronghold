package org.usfirst.frc.team2574.generalLee.commands;

import org.usfirst.frc.team2574.generalLee.OI;
import org.usfirst.frc.team2574.generalLee.Robot;
import org.usfirst.frc.team2574.generalLee.subsystems.Mast;



import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleMast extends Command {

    public TeleMast() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mast);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Mast.initPosPID();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double sp = (OI.getMast() * -4.45) + 4.94;
    	
    		
        	Mast.set(sp);
        	SmartDashboard.putNumber("setpoint", sp);
        	SmartDashboard.putNumber("analog0", Mast.position0());
        	SmartDashboard.putNumber("analog1", Mast.position1());
    	
    	 
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//changed for button
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Mast.set(sp);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
