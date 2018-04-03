package org.usfirst.frc.team1165.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossAutoLineCenter extends CommandGroup
{
	public CrossAutoLineCenter()
	{
		addSequential(new DriveStraightSpeed(0.75, 0), 1.65);
	}
}
