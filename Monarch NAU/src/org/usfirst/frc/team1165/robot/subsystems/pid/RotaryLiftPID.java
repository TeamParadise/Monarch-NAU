// package org.usfirst.frc.team1165.robot.subsystems.pid;
//
// import org.usfirst.frc.team1165.robot.Robot;
// import org.usfirst.frc.team1165.robot.util.states.RotaryLiftState;
//
// import edu.wpi.first.wpilibj.command.PIDSubsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
/// **
// *
// * @author Kesav Kadalazhi
// *
// */
// public class RotaryLiftPID extends PIDSubsystem
// {
// public RotaryLiftPID()
// {
// super("Rotary Lift", 0.05, 0, 0, 0.01);
//
// setInputRange(0, 360);
// setOutputRange(-0.1, 0.1);
// setAbsoluteTolerance(5);
//
// getPIDController().setContinuous();
// }
//
// public void set(RotaryLiftState state)
// {
// setSetpoint(state.get());
// }
//
// @Override
// protected double returnPIDInput()
// {
// return Robot.mRotaryLift.getLiftPosition();
// }
//
// @Override
// protected void usePIDOutput(double output)
// {
// Robot.mRotaryLift.set(output);
// }
//
// @Override
// protected void initDefaultCommand()
// {
// }
//
// public void report()
// {
// SmartDashboard.putNumber(getName() + " Target", getSetpoint());
// SmartDashboard.putBoolean(getName() + " On Target", onTarget());
// }
//
// }