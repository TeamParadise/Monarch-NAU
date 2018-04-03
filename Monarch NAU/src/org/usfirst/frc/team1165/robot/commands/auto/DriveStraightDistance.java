package org.usfirst.frc.team1165.robot.commands.auto;

import static org.usfirst.frc.team1165.robot.Robot.mDriveStraightPID;
import static org.usfirst.frc.team1165.robot.Robot.mDriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightDistance extends Command
{
	private double mTarget;

	private double mInitial;
	private double mFinal;
	
	public DriveStraightDistance(double target)
	{
		mTarget = target;
		
		requires(mDriveTrain);
		requires(mDriveStraightPID);
	}

	@Override
	protected void initialize()
	{
		mInitial = mDriveTrain.getPosition();
		
		System.out.println("Initial Position: " + mInitial);

		mDriveStraightPID.resetInitHeading();
		mDriveStraightPID.resetInputRange(mTarget * 2);
		mDriveStraightPID.setSetpointRelative(mTarget);
		mDriveStraightPID.enable();
	}

	@Override
	protected boolean isFinished()
	{
		return mDriveStraightPID.onTarget();
	}

	@Override
	protected void end()
	{
		mDriveTrain.tankDrive(0, 0);
		mDriveStraightPID.disable();
		
		mFinal = mDriveTrain.getPosition();
		
		System.out.println("Final Position: " + mFinal);
		System.out.println("Delta Position: " + (mFinal - mInitial));

	}
}