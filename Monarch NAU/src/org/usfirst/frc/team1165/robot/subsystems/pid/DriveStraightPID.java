package org.usfirst.frc.team1165.robot.subsystems.pid;

import static org.usfirst.frc.team1165.robot.Robot.mDriveTrain;

import org.usfirst.frc.team1165.robot.util.drivers.NavX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightPID extends PIDSubsystem
{
	private double mOutput;

	private double mInitHeading;

	private static final double TWIST_CORRECT = 0; // 0.4

	public DriveStraightPID()
	{
		super("Drive Straight PID", 0.05, 0.01, 0.01, 0);

		resetInputRange(100);
		setInputRange(0, 100);
		setOutputRange(-.75, .75);
		setAbsoluteTolerance(1);

		getPIDController().setContinuous(false);
	}

	public void resetInputRange(double overUnder)
	{
		setInputRange(mDriveTrain.getPosition() - overUnder, mDriveTrain.getPosition() + overUnder);
	}

	public void resetInitHeading()
	{
		mInitHeading = NavX.getHeading();
	}

	public double getTwistCorrect()
	{
		if (mInitHeading < NavX.getHeading())
			return -TWIST_CORRECT;
		else if (mInitHeading > NavX.getHeading())
			return TWIST_CORRECT;
		else
			return 0;
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	protected double returnPIDInput()
	{
		return mDriveTrain.getPosition();
	}

	@Override
	protected void usePIDOutput(double output)
	{
		mOutput = output;
		mDriveTrain.arcadeDrive(output, getTwistCorrect());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Target", getSetpoint());
		SmartDashboard.putBoolean(getName() + " On Target", onTarget());
		SmartDashboard.putNumber(getName() + " PID Output", mOutput);
		SmartDashboard.putNumber(getName() + " Twist Correct", getTwistCorrect());
		SmartDashboard.putNumber(getName() + " Init Heading", mInitHeading);
	}
}
