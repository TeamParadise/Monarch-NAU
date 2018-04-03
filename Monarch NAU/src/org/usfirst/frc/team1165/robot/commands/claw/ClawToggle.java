package org.usfirst.frc.team1165.robot.commands.claw;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawToggle extends InstantCommand
{
	public ClawToggle()
	{
		super();
		requires(Robot.mClaw);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
		Robot.mClaw.toggle();
	}
}
