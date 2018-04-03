package org.usfirst.frc.team1165.robot.util.states;

/**
 * <p>
 * The Rotary Lift has 4 states:
 * </p>
 * 
 * <ol>
 * <li>Intake: parallel to the ground</li>
 * <li>Switch: a little higher than the ground</li>
 * <li>Scale Down: a little more higher than the ground</li>
 * <li>Scale Up: 45 from the ground</li>
 * </ol>
 */
public enum RotaryLiftState
{
	IDLE(0), DOWN(0), SWITCH(15), SCALE_DOWN(22.5), SCALE_UP(45);

	private double value;

	RotaryLiftState(double value)
	{
		this.value = value;
	}

	public double get()
	{
		return value;
	}
}