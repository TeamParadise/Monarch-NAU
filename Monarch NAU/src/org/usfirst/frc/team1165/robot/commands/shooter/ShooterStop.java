package org.usfirst.frc.team1165.robot.commands.shooter;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterStop extends Command
{
	public ShooterStop()
	{
		requires(Robot.mShooter);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
	}

	protected void execute()
	{
		Robot.mShooter.set(0);
	}

	protected boolean isFinished()
	{
		return false;
	}
}
