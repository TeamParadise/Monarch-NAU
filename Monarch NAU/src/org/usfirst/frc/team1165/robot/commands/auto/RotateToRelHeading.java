package org.usfirst.frc.team1165.robot.commands.auto;

import static edu.wpi.first.wpilibj.DriverStation.reportWarning;
import static org.usfirst.frc.team1165.robot.Robot.mDriveTrain;
import static org.usfirst.frc.team1165.robot.Robot.mRotatePID;

import org.usfirst.frc.team1165.robot.util.drivers.NavX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateToRelHeading extends Command
{
	private double mTarget;

	private double mInitial;
	private double mFinal;
	
	public RotateToRelHeading(double target)
	{
		mTarget = target;

		requires(mDriveTrain);
		requires(mRotatePID);
	}

	@Override
	protected void initialize()
	{
		mInitial =  NavX.getHeading();
		
		System.out.println("Initial Angle: " + mInitial);

		mRotatePID.setSetpointRelative(mTarget);
		mRotatePID.enable();
	}

	@Override
	protected boolean isFinished()
	{
		return mRotatePID.onTarget();
	}

	@Override
	protected void end()
	{
		mDriveTrain.arcadeDrive(0, 0);
		mRotatePID.disable();

		mFinal = NavX.getHeading();
		
		System.out.println("Final Angle: " + mFinal);
		System.out.println("Delta Angle: " + (mFinal - mInitial));
	}
}