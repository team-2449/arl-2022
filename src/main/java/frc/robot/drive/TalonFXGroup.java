// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.drive;

import java.util.ArrayList;
import java.util.List;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.music.Robotify;
import frc.robot.music.TalonFXRobotify;

/** Represents a group of {@code TalonFX} objects. */
public class TalonFXGroup implements MotorConGroup {

    private List<TalonFX> m_talons;
    private TalonFXRobotify m_robotify;

    public TalonFXGroup(List<Integer> ports) {
        m_talons = new ArrayList<>();
        for (Integer port : ports) {
            TalonFX talon = new TalonFX(port);
            m_talons.add(talon);
        }

        m_robotify = null;
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
    public void initRobotify() {
        m_robotify = new TalonFXRobotify(m_talons);
    }

    @Override
    public Robotify getRobotify() {
        return m_robotify;
    }

}
