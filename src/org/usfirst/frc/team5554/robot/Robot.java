package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.robot.Commands.AutoShoot;
import org.usfirst.frc.team5554.robot.Commands.Autonomous_One;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/**************************************************Autonomous Dashboard*********************************************/
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	Command autonomousCommand;
	SendableChooser autoChooser;
	/*******************************************************************************************************************/
	
	@SuppressWarnings("rawtypes")
	@Override
	public void robotInit() 
	{
		/**************************************************Autonomous options*********************************************/
		chooser.addDefault("Default Auto", "Default");
		chooser.addObject("My Auto", "My Auto");
		SmartDashboard.putData("Auto choices", chooser);
		autoChooser = new SendableChooser();
		autoChooser.addDefault("default", new Autonomous_One());
		autoChooser.addObject("autoShoot", new AutoShoot());
		/*******************************************************************************************************************/
	}

	@Override
	public void autonomousInit() 
	{
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}


	@Override
	public void teleopPeriodic() {
	}


	@Override
	public void testPeriodic() {
	}
}

