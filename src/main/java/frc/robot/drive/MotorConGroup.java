// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.drive;

import frc.robot.music.Robotify;

/** Represents a group of motor controllers. */
public interface MotorConGroup {

    public enum Type {
        TALON_FX,
        TALON_SRX
    }

    public void drivePercent(double percent);

    public void setInverted(boolean shouldInvert);

    public void initRobotify();
    public Robotify getRobotify();

}
