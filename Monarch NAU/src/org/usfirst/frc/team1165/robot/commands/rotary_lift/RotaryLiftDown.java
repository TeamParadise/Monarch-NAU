package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftDown extends Command
{
	public RotaryLiftDown()
	{
		requires(Robot.mRotaryLift);
	}

	@Override
	protected void execute()
	{
		Robot.mRotaryLift.down();
	}

	@Override
	protected boolean isFinished()
	{
		return !OperatorInterface.getRotaryLiftDown();
	}

}
