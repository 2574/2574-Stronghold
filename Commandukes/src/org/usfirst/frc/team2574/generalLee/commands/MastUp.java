package org.usfirst.frc.team2574.generalLee.commands;

import org.usfirst.frc.team2574.generalLee.Robot;
import org.usfirst.frc.team2574.generalLee.subsystems.Mast;
import org.usfirst.frc.team2574.generalLee.subsystems.Winch;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MastUp extends Command {

    public MastUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    	requires(Robot.mast);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Winch.initWinch();
    	Mast.initPosPID();
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
    	Winch.ratchetSet(0.6);
    	Timer.delay(.2);
    	
    	Timer.delay(.2);
    	Winch.set(3.8);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
