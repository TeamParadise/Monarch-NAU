package org.usfirst.frc.team1165.robot.commands.linear_lift;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.util.drivers.OperatorInterface;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunLinearLiftJoystick extends Command
{
	public RunLinearLiftJoystick()
	{
		requires(Robot.mLinearLift);
	}

	@Override
	protected void execute()
	{
		Robot.mLinearLift.set(OperatorInterface.getRightY());
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

}
