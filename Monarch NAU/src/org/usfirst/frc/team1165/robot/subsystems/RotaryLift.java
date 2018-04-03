package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.ROTARY_LIFT_POT;
import static org.usfirst.frc.team1165.robot.RobotMap.ROTARY_LIFT_TALON;

import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftStop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLift extends Subsystem
{
	private WPI_TalonSRX mRotaryLift = new WPI_TalonSRX(ROTARY_LIFT_TALON);

	private AnalogPotentiometer mPot = new AnalogPotentiometer(ROTARY_LIFT_POT, 360, 0);

	public void up()
	{
		mRotaryLift.set(0.6);
	}

	public void down()
	{
		mRotaryLift.set(-0.6);
	}

	public void stop()
	{
		mRotaryLift.set(0);
	}

	public double getPosition()
	{
		return mPot.get();
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new RotaryLiftStop());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Motor", mRotaryLift.get());
		SmartDashboard.putNumber(getName() + " Angle", mPot.get());
	}

}