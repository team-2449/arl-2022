// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.music;

import java.util.List;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

/** Add your docs here. */
public class TalonFXRobotify implements Robotify {

    private Orchestra m_orchestra;

    public TalonFXRobotify(List<TalonFX> talons) {
        talons.forEach(talon -> m_orchestra.addInstrument(talon));
    }

    @Override
    public void load(String name) {
        m_orchestra.loadMusic(name);
    }

    @Override
    public void play() {
        m_orchestra.play();
    }

    @Override
    public void pause() {
        m_orchestra.pause();
    }

    @Override
    public void stop() {
        m_orchestra.stop();
    }

}
