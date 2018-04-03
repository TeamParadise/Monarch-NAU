package org.usfirst.frc.team1165.robot.commands.climber;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimberDown extends InstantCommand
{

	public ClimberDown()
	{
		super();
		requires(Robot.mClimber);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
		Robot.mClimber.down();
	}
}
