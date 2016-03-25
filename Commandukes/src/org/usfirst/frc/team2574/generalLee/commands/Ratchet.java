package org.usfirst.frc.team2574.generalLee.commands;

import org.usfirst.frc.team2574.generalLee.Robot;
import org.usfirst.frc.team2574.generalLee.subsystems.Winch;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Ratchet extends Command {

    public Ratchet() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(Winch.ratchetGet() < .3) {
    		Winch.ratchetSet(.7);
    	} else {
    		Winch.ratchetSet(.18);
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}