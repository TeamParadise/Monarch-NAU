package org.usfirst.frc.team1165.robot.commands.wings;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WingsLowerLeft extends Command
{
	public WingsLowerLeft()
	{
		super();
		requires(Robot.mWings);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
		Robot.mWings.lowerRight();
	}

	protected boolean isFinished()
	{
		return !OperatorInterface.getLeftWing();
	}
}
