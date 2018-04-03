package org.usfirst.frc.team1165.robot.commands.shooter;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterEject extends InstantCommand
{
	public ShooterEject()
	{
		requires(Robot.mShooter);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
	}

	protected void execute()
	{
		SmartDashboard.putBoolean("Eject isFinished: ", !OperatorInterface.getEject());

		Robot.mShooter.eject();
	}

	protected boolean isFinished()
	{
		return !OperatorInterface.getEject();
	}

	protected void end()
	{
		Robot.mShooter.set(0);
	}
}
