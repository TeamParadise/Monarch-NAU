package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * <p>
 * The Claw consists of two pistons, which are controlled by one
 * {@link DoubleSolenoid}.
 * </p>
 * 
 * <p>
 * The Claw has three states:
 * </p>
 * 
 * <ol>
 * <li>Idle (default)</li>
 * <li>Open</li>
 * <li>Close</li>
 * </ol>
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Claw extends Subsystem
{
	private DoubleSolenoid mClawSolenoid = new DoubleSolenoid(RobotMap.PCM, RobotMap.CLAW_EXTEND_SOLENOID,
			RobotMap.CLAW_RETRACT_SOLENOID);

	public void toggle()
	{
		if (get() == Value.kForward)
			mClawSolenoid.set(Value.kReverse);
		else if (get() == Value.kReverse)
			mClawSolenoid.set(Value.kForward);
	}

	public void off()
	{
		mClawSolenoid.set(Value.kOff);
	}

	public Value get()
	{
		return mClawSolenoid.get();
	}

	@Override
	protected void initDefaultCommand()
	{
	}

	public void report()
	{
		SmartDashboard.putString(getName(), mClawSolenoid.get().toString());
	}

}