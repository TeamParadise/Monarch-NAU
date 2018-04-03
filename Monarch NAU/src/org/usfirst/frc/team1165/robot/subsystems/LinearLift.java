package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.LINEAR_LIFT_TALON_1;
import static org.usfirst.frc.team1165.robot.RobotMap.LINEAR_LIFT_TALON_2;

import org.usfirst.frc.team1165.robot.commands.linear_lift.RunLinearLiftJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLift extends Subsystem
{
	/**
	 * Has Encoder on Breakout Board
	 */
	private WPI_TalonSRX mMaster = new WPI_TalonSRX(LINEAR_LIFT_TALON_1);
	private WPI_TalonSRX mFollower = new WPI_TalonSRX(LINEAR_LIFT_TALON_2);

	private SpeedControllerGroup mLift = new SpeedControllerGroup(mMaster, mFollower);

	public void set(double speed)
	{
		mLift.set(speed);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new RunLinearLiftJoystick());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Speed", mLift.get());
	}

}