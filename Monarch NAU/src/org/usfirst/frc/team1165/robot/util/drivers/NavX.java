package org.usfirst.frc.team1165.robot.util.drivers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX
{
//	private static final AHRS mAHRS = new AHRS(SerialPort.Port.kMXP);

	public static double getHeading()
	{
		return 0;
//		return mAHRS.getFusedHeading();
	}

	public static void report()
	{
		SmartDashboard.putNumber("NavX Heading", getHeading());
	}
}
