package org.usfirst.frc.team1165.robot.commands.claw;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawOff extends InstantCommand
{
	public ClawOff()
	{
		super();
		requires(Robot.mClaw);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
		Robot.mClaw.off();
	}
}
