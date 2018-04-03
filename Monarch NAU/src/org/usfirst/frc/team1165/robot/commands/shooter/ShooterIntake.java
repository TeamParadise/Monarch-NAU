package org.usfirst.frc.team1165.robot.commands.shooter;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterIntake extends InstantCommand
{
	public ShooterIntake()
	{
		requires(Robot.mShooter);
	}

	protected void initialize()
	{
		DriverStation.reportWarning("Command Started: " + getName(), false);
	}

	protected void execute()
	{
		SmartDashboard.putBoolean("Intake isFinished: ", !OperatorInterface.getIntake());

		Robot.mShooter.intake();
	}

	protected boolean isFinished()
	{
		return !OperatorInterface.getIntake();
	}

	protected void end()
	{
		Robot.mShooter.set(0);
	}
}
