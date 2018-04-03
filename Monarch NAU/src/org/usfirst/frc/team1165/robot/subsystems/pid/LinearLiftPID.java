// package org.usfirst.frc.team1165.robot.subsystems.pid;
//
// import org.usfirst.frc.team1165.robot.Robot;
// import org.usfirst.frc.team1165.robot.util.states.LinearLiftState;
//
// import edu.wpi.first.wpilibj.command.PIDSubsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
/// **
// *
// * @author Kesav Kadalazhi
// *
// */
// public class LinearLiftPID extends PIDSubsystem
// {
// protected LinearLiftPID()
// {
// super("Linear Lift", 0.01, 0, 0, 0);
//
// setInputRange(-10, 65);
// setOutputRange(-0.3, 0.3);
// setAbsoluteTolerance(10);
// }
// public void set(LinearLiftState state)
// {
// setSetpoint(state.get());
// }
//
// @Override
// protected double returnPIDInput()
// {
// return Robot.mLinearLift.getPosition();
// }
//
// @Override
// protected void usePIDOutput(double output)
// {
// mLiftMotors.set(output);
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