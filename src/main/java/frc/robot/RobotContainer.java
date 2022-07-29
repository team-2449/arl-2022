// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.UserDriveCommand;
import frc.robot.commands.auton.AutonRoutine;
import frc.robot.controllers.JoyCon;
import frc.robot.profile.Profile;
import frc.robot.profile.ProfileBuilder;
import frc.robot.subsystems.DriveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Profile profile = ProfileBuilder.fromFile("kop");
  
  private DriveSubsystem drive = new DriveSubsystem(
    profile.drive.getType(),
    profile.drive.getLeftIDs(),
    profile.drive.getRightIDs());

  private JoyCon con = profile.oi.createController();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  }

  public void bindInputs() {
    // Configure the button bindings
    configureButtonBindings();

    drive.setDefaultCommand(new UserDriveCommand(drive, con));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutonRoutine(drive);
  }
}
