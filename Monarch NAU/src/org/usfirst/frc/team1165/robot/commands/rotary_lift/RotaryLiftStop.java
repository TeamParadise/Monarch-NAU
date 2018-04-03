package org.usfirst.frc.team1165.robot.commands.rotary_lift;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftStop extends Command
{
	public RotaryLiftStop()
	{
		requires(Robot.mRotaryLift);
	}

	@Override
	protected void execute()
	{
		Robot.mRotaryLift.stop();
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

}
