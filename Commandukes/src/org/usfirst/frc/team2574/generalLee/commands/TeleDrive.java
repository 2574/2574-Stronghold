package org.usfirst.frc.team2574.generalLee.commands;

import org.usfirst.frc.team2574.generalLee.OI;
import org.usfirst.frc.team2574.generalLee.Robot;
import org.usfirst.frc.team2574.generalLee.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleDrive extends Command {

    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.drive);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Drive.setSafety(true);
    	Drive.invert();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double throt = OI.getThrottle();
    	Drive.arcadeDrive(throt, OI.getRotation());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
