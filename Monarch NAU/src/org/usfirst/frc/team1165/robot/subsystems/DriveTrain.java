package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem
{
	private WPI_TalonSRX mLeftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER_DRIVE_TALON);
	private WPI_TalonSRX mLeftSlave = new WPI_TalonSRX(RobotMap.LEFT_SLAVE_DRIVE_TALON);
	private WPI_TalonSRX mRightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_DRIVE_TALON);
	private WPI_TalonSRX mRightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_DRIVE_TALON);

	private SpeedControllerGroup mLeftDrive = new SpeedControllerGroup(mLeftMaster, mLeftSlave);
	private SpeedControllerGroup mRightDrive = new SpeedControllerGroup(mRightMaster, mRightSlave);

	private DifferentialDrive mDrive = new DifferentialDrive(mLeftDrive, mRightDrive);

	public void arcadeDrive(double speed, double twist)
	{
		mDrive.arcadeDrive(speed, twist);
	}

	public void tankDrive(double leftSpeed, double rightSpeed)
	{
		mDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public double getPosition()
	{
		return mRightMaster.getSensorCollection().getQuadraturePosition() * Math.PI * 5 * 7.66 / 4096;
//		return mRightMaster.getSensorCollection().getQuadraturePosition() / 37.1;
//		return mRightMaster.getSensorCollection().getQuadraturePosition() * Math.PI * 5 / (4096 * 7.66);
	}

	public double getVelocity()
	{
		return 0;
		// return mRightMaster.getSensorCollection().getQuadratureVelocity() *
		// 10 * Math.PI * 6 / 4096;
	}

	public void resetEncoder()
	{
		mRightMaster.getSensorCollection().setQuadraturePosition(0, 0);
	}

	public boolean isZeroed()
	{
		return Math.abs(getPosition()) < 0.001;
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Right", mRightDrive.get());
		SmartDashboard.putNumber(getName() + " Left", mLeftDrive.get());

		SmartDashboard.putNumber(getName() + " Position", getPosition());
		// SmartDashboard.putNumber(getName() + " Velocity", getVelocity());
	}
}