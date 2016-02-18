package org.usfirst.frc.team2574.generalLee.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arduino extends Subsystem {
    private static I2C i2cBus = new I2C(I2C.Port.kOnboard, 0x1E);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public boolean requestFrom(int address, int count, byte[] buffer) {
    	return i2cBus.read(address, count, buffer);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

