// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.drive.MotorConFactory;
import frc.robot.drive.MotorConGroup;

public class DriveSubsystem extends SubsystemBase {

  private MotorConGroup m_left;
  private MotorConGroup m_right;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem(MotorConGroup.Type mcgType, List<Integer> leftIds, List<Integer> rightIds) {
    m_left = MotorConFactory.create(mcgType, leftIds);
    m_right = MotorConFactory.create(mcgType, rightIds);
  }

  public void drivePercent(double left, double right) {
    m_left.drivePercent(left);
    m_right.drivePercent(right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
