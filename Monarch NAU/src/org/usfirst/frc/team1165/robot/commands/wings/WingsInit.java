package org.usfirst.frc.team1165.robot.commands.wings;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WingsInit extends Command
{
	public WingsInit()
	{
		super();
		requires(Robot.mWings);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
		Robot.mWings.init();
	}

	protected boolean isFinished()
	{
		return false;
	}
}
