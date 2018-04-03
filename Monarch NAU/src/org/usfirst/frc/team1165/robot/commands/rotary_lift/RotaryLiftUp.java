package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftUp extends Command
{
	public RotaryLiftUp()
	{
		requires(Robot.mRotaryLift);
	}

	@Override
	protected void execute()
	{
		Robot.mRotaryLift.up();
	}

	@Override
	protected boolean isFinished()
	{
		return !OperatorInterface.getRotaryLiftUp();
	}

}
