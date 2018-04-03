package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// MOTOR CONTROLLERS

	public static final int RIGHT_MASTER_DRIVE_TALON = 28;
	public static final int RIGHT_SLAVE_DRIVE_TALON = 22;
	public static final int LEFT_MASTER_DRIVE_TALON = 24;
	public static final int LEFT_SLAVE_DRIVE_TALON = 25;

	public static final int REAR_RIGHT_SHOOTER_TALON = 27;
	public static final int REAR_LEFT_SHOOTER_TALON = 23;

	public static final int LINEAR_LIFT_TALON_1 = 26;
	public static final int LINEAR_LIFT_TALON_2 = 21;

	public static final int ROTARY_LIFT_TALON = 20;

	// SENSORS

	public static final int LINEAR_LIFT_ENCODER = 0; // placeholder value
	public static final int ROTARY_LIFT_POT = 0; // placeholder value

	public static final int PRESSURE_SENSOR_PORT = 1;

	// PNEUMATICS

	public static final int PCM = 1;

	public static final int LEFT_WING_SOLENOID = 5; // good
	public static final int RIGHT_WING_SOLENOID = 2; // good

	public static final int CLAW_EXTEND_SOLENOID = 0; // good
	public static final int CLAW_RETRACT_SOLENOID = 1; // good

	public static final int CLIMBER_EXTEND_SOLENOID = 3; // good
	public static final int CLIMBER_RETRACT_SOLENOID = 4; // good

	// BUTTONS FOR LUKE

	public static final int CLAW_TOGGLE_BUTTON = 1;
	public static final int SHOOTER_INTAKE_BUTTON = 5;
	public static final int SHOOTER_EJECT_BUTTON = 6;
	public static final int ROTARY_LIFT_UP_BUTTON = 3;
	public static final int ROTARY_LIFT_DOWN_BUTTON = 4;

	// BUTTONS FOR CO-DRIVER

	// linear lift is right stick on controller

	public static final int LEFT_WING_DOWN_BUTTON = 5;
	public static final int RIGHT_WING_DOWN_BUTTON = 6;

	public static final int CLIMBER_UP_BUTTON = 1;
	public static final int CLIMBER_DOWN_BUTTON = 4;

}
