package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightSpeed extends Command
{
	private double mY;
	private double mTwist;

	public DriveStraightSpeed(double y, double twist)
	{
		mY = y;
		mTwist = twist;

		requires(Robot.mDriveTrain);
	}

	@Override
	protected void execute()
	{
		Robot.mDriveTrain.arcadeDrive(mY, mTwist);
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
