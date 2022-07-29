// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;

/** Represents a Logitech controller. */
public class LogiCon extends JoyCon {

    private Joystick m_con;

    public LogiCon(int port) {
        m_con = new Joystick(port);
    }

    @Override
    public double getLeftX() {
        return m_con.getRawAxis(0);
    }

    @Override
    public double getLeftY() {
        return -m_con.getRawAxis(1);
    }

    @Override
    public double getRightX() {
        return m_con.getRawAxis(2);
    }

    @Override
    public double getRightY() {
        return -m_con.getRawAxis(3);
    }

    @Override
    public DpadDir getDpad() {
        int pov = m_con.getPOV();
        
        return DpadDir.fromInt(pov);
    }

}
