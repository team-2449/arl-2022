// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.controllers.JoyCon;
import frc.robot.math.OttoMath;
import frc.robot.subsystems.DriveSubsystem;

public class UserDriveCommand extends CommandBase {

  private DriveSubsystem m_drive;
  private JoyCon m_con;

  /** Creates a new UserDriveCommand. */
  public UserDriveCommand(DriveSubsystem drive, JoyCon con) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_con = con;

    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Vector2d leftDir = m_con.getLeft();
    Vector2d rightDir = m_con.getRight();

    // Rotate sticks
    leftDir.rotate(-20);
    rightDir.rotate(20);

    double leftOut = leftDir.magnitude() * Math.signum(leftDir.y);
    double rightOut = rightDir.magnitude() * Math.signum(rightDir.y);
  
    // Quantize output
    leftOut = OttoMath.quantize(leftOut, 0.05);
    rightOut = OttoMath.quantize(rightOut, 0.05);

    // Prevent drifting
    if (Math.abs(leftDir.magnitude()) < 0.1) {
      leftOut = 0.0;
    }
    if (Math.abs(rightDir.magnitude()) < 0.1) {
      rightOut = 0.0;
    }

    // Cube output
    leftOut = leftOut * leftOut * leftOut;
    rightOut = rightOut * rightOut * rightOut;

    // Transition input smoothly
    if (Math.abs(leftDir.y) < 0.3) {
      leftOut *= Math.abs(leftDir.y);
    }
    if (Math.abs(rightDir.y) < 0.3) {
      rightOut *= Math.abs(rightDir.y);
    }

    // Cancel output if y = 0, otherwise clamp values
    leftOut = leftDir.y == 0.0 ? 0.0 : OttoMath.clamp(leftOut, -1.0, 1.0);
    rightOut = rightDir.y == 0.0 ? 0.0 : OttoMath.clamp(rightOut, -1.0, 1.0);

    System.out.println("Left: " + -leftOut);

    m_drive.drivePercent(-leftOut, rightOut);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drivePercent(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
