package org.usfirst.frc.team1165.robot.util.drivers;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.claw.ClawToggle;
import org.usfirst.frc.team1165.robot.commands.climber.ClimberDown;
import org.usfirst.frc.team1165.robot.commands.climber.ClimberUp;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.rotary_lift.RotaryLiftUp;
import org.usfirst.frc.team1165.robot.commands.shooter.ShooterEject;
import org.usfirst.frc.team1165.robot.commands.shooter.ShooterIntake;
import org.usfirst.frc.team1165.robot.commands.wings.WingsLowerLeft;
import org.usfirst.frc.team1165.robot.commands.wings.WingsLowerRight;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * @author Kesav Kadalazhi
 */
public class OperatorInterface
{

	// DRIVER FUNCTIONALITY

	private static Joystick mJoy = new Joystick(0);

	private static JoystickButton mClawToggle = new JoystickButton(mJoy, RobotMap.CLAW_TOGGLE_BUTTON);

	private static JoystickButton mShooterIntake = new JoystickButton(mJoy, RobotMap.SHOOTER_INTAKE_BUTTON);
	private static JoystickButton mShooterEject = new JoystickButton(mJoy, RobotMap.SHOOTER_EJECT_BUTTON);

	private static JoystickButton mRotaryLiftUp = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_UP_BUTTON);
	private static JoystickButton mRotaryLiftDown = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_DOWN_BUTTON);

	// CO-DRIVER FUNCTIONALITY

	private static XboxController mCtrl = new XboxController(1);

	private static JoystickButton mLowerLeftWing = new JoystickButton(mCtrl, RobotMap.LEFT_WING_DOWN_BUTTON);
	private static JoystickButton mLowerRightWing = new JoystickButton(mCtrl, RobotMap.RIGHT_WING_DOWN_BUTTON);

	private static JoystickButton mClimberUp = new JoystickButton(mCtrl, RobotMap.CLIMBER_UP_BUTTON);
	private static JoystickButton mClimberDown = new JoystickButton(mCtrl, RobotMap.CLIMBER_DOWN_BUTTON);

	static
	{
		// DRIVER FUNCTIONALITY

		mClawToggle.whenPressed(new ClawToggle());

		mShooterIntake.whenPressed(new ShooterIntake());
		mShooterEject.whenPressed(new ShooterEject());

		mRotaryLiftUp.whenPressed(new RotaryLiftUp());
		mRotaryLiftDown.whenPressed(new RotaryLiftDown());

		// DRIVER FUNCTIONALITY

		mLowerLeftWing.whenPressed(new WingsLowerLeft());
		mLowerRightWing.whenPressed(new WingsLowerRight());

		mClimberUp.whenPressed(new ClimberUp());
		mClimberDown.whenPressed(new ClimberDown());
	}

	public static boolean getLeftWing()
	{
		return mLowerLeftWing.get();
	}

	public static boolean getRightWing()
	{
		return mLowerRightWing.get();
	}

	public static boolean getIntake()
	{
		return mShooterIntake.get();
	}

	public static boolean getEject()
	{
		return mShooterEject.get();
	}

	public static boolean getRotaryLiftUp()
	{
		return mRotaryLiftUp.get();
	}

	public static boolean getRotaryLiftDown()
	{
		return mRotaryLiftDown.get();
	}

	public static double getX()
	{
		return dampen(mJoy.getX());
	}

	public static double getY()
	{
		return dampen(-mJoy.getY());
	}

	public static double getTwist()
	{
		return dampen(mJoy.getTwist());
	}

	// rotary lift
	public static double getLeftY()
	{
		if (-mCtrl.getY(Hand.kLeft) > 0)
			return Math.min(-mCtrl.getY(Hand.kLeft), 0.6);
		else
			return Math.max(-mCtrl.getY(Hand.kLeft), -0.4);
	}

	// linear lift
	public static double getRightY()
	{
		if (-mCtrl.getY(Hand.kRight) > 0)
			return Math.min(-mCtrl.getY(Hand.kRight), 0.75);
		else
			return Math.max(-mCtrl.getY(Hand.kRight), -0.3);
	}

	// INPUT TRANSFORM

	public static double dampen(double value)
	{
		double damped = Math.pow(value, 3);
		return Math.abs(damped) < 0.1 ? 0 : damped;
	}

	public static double dampen(double value, double dampener)
	{
		return Math.pow(value, dampener);
	}

	public static double constrain(double input, double high, double low)
	{
		if (input > high)
			return high;
		else if (input < low)
			return low;
		else
			return input;
	}

	public void report()
	{
		// SmartDashboard.putNumber("OI Joystick X", getX());
		// SmartDashboard.putNumber("OI Joystick Y", getY());
		// SmartDashboard.putNumber("OI Joystick Twist", getTwist());

		// SmartDashboard.putNumber("OI Left Y", getLeftY());
		// SmartDashboard.putNumber("OI Right Y", getRightY());
	}

}
