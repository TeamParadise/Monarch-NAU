package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.shooter.ShooterStop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Shooter extends Subsystem
{
	private WPI_TalonSRX mRearRightMotor = new WPI_TalonSRX(RobotMap.REAR_RIGHT_SHOOTER_TALON);
	private WPI_TalonSRX mRearLeftMotor = new WPI_TalonSRX(RobotMap.REAR_LEFT_SHOOTER_TALON);

	public Shooter()
	{
		// mRearRightMotor.setInverted(true);
	}

	public void set(double speed)
	{
		mRearRightMotor.set(speed);
		mRearLeftMotor.set(speed);
	}

	public void intake()
	{
		mRearRightMotor.set(0.6);
		mRearLeftMotor.set(0.6);
	}

	public void eject()
	{
		mRearRightMotor.set(-0.6);
		mRearLeftMotor.set(-0.6);
	}

	public void stop()
	{
		mRearRightMotor.set(0);
		mRearLeftMotor.set(0);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new ShooterStop());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Right", mRearRightMotor.get());
		SmartDashboard.putNumber(getName() + " Left", mRearLeftMotor.get());
	}

}