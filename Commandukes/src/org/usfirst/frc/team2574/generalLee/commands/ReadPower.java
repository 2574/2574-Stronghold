package org.usfirst.frc.team2574.generalLee.commands;

import org.usfirst.frc.team2574.generalLee.Robot;
import org.usfirst.frc.team2574.generalLee.subsystems.Power;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ReadPower extends Command {

    public ReadPower() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.power);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(int i =0; i<=15; i++){
    		SmartDashboard.putNumber("pwrChan" + i, Power.getCurrent(i));
    	}
    	SmartDashboard.putNumber("totalPwr", Power.getCurrent());
    	//Timer.delay(.02);
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