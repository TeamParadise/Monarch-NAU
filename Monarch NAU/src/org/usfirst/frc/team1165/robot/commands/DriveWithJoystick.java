package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command
{
	public DriveWithJoystick()
	{
		requires(Robot.mDriveTrain);
	}

	@Override
	protected void execute()
	{
		Robot.mDriveTrain.arcadeDrive(OperatorInterface.getY(), OperatorInterface.getTwist());
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void end()
	{
		Robot.mDriveTrain.tankDrive(0, 0);
	}

}
