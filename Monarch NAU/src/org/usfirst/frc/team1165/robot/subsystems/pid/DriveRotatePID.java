package org.usfirst.frc.team1165.robot.subsystems.pid;

import static org.usfirst.frc.team1165.robot.Robot.mDriveTrain;

import org.usfirst.frc.team1165.robot.util.drivers.NavX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveRotatePID extends PIDSubsystem
{
	private double mTwist;

	public DriveRotatePID()
	{
		super("NavX PID", 0.05, 0, 0, 0);

		setInputRange(0, 360);
		setOutputRange(-.75, .75);
		setAbsoluteTolerance(3);

		getPIDController().setContinuous();
	}

	@Override
	public void initDefaultCommand()
	{
	}

	@Override
	protected double returnPIDInput()
	{
		return NavX.getHeading();
	}

	@Override
	protected void usePIDOutput(double twist)
	{
		mTwist = twist;
		mDriveTrain.arcadeDrive(0, twist);
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Target", getSetpoint());
		SmartDashboard.putNumber(getName() + " Output", mTwist);
		SmartDashboard.putBoolean(getName() + " On Target", onTarget());
	}
}
