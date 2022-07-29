// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.vision.Limelight;

public class SeekCommand extends CommandBase {
  
  private DriveSubsystem m_drive;
  private Limelight m_limelight;

  private boolean m_shouldStop;
  
  /** Creates a new SeekCommand. */
  public SeekCommand(DriveSubsystem drive, Limelight limelight) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_limelight = limelight;
    m_shouldStop = false;
  
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double seekSpeed = 0.0;
    final double kP = 1.0 / 150.0;

    if (!m_limelight.canSeeTarget()) {
      seekSpeed = 0.3;
    } else {
      seekSpeed = m_limelight.targetX() * kP;
    }

    if (seekSpeed <= 0.05) {
      disengage();
    } else {
      m_drive.drivePercent(seekSpeed, -seekSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    disengage();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_shouldStop;
  }

  // Stops the drive train and signals the command to finish.
  private void disengage() {
    m_shouldStop = true;
    m_drive.drivePercent(0, 0);
  }
}
