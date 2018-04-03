package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.wings.WingsInit;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wings extends Subsystem
{
	private Solenoid mLeftWing = new Solenoid(RobotMap.PCM, RobotMap.LEFT_WING_SOLENOID);
	private Solenoid mRightWing = new Solenoid(RobotMap.PCM, RobotMap.RIGHT_WING_SOLENOID);

	public void lowerLeft()
	{
		mLeftWing.set(true);
	}

	public void lowerRight()
	{
		mRightWing.set(true);
	}

	public void init()
	{
		mLeftWing.set(false);
		mRightWing.set(false);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new WingsInit());
	}

	public void report()
	{
		SmartDashboard.putBoolean(getName() + " Left", mLeftWing.get());
		SmartDashboard.putBoolean(getName() + " Right", mRightWing.get());
	}
}