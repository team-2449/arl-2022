// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.drive;

import java.util.ArrayList;
import java.util.List;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.music.NullRobotify;
import frc.robot.music.Robotify;

/** Represents a group of {@code TalonSRX} objects. */
public class TalonSRXGroup implements MotorConGroup {

    private List<TalonSRX> m_talons;

    public TalonSRXGroup(List<Integer> ports) {
        m_talons = new ArrayList<>();
        for (Integer port : ports) {
            TalonSRX talon = new TalonSRX(port);
            m_talons.add(talon);
        }
    }

    @Override
    public void drivePercent(double percent) {
        m_talons.forEach(talon -> talon.set(ControlMode.PercentOutput, percent));
    }

    @Override
    public void setInverted(boolean shouldInvert) {
        m_talons.forEach(talon -> talon.setInverted(shouldInvert));
    }

    @Override
    public void initRobotify() {}

    @Override
    public Robotify getRobotify() {
        return new NullRobotify();
    }

}
