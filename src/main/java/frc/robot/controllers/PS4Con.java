// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.controllers;

import edu.wpi.first.wpilibj.PS4Controller;

/** Represents a PS4 Controller. */
public class PS4Con extends JoyCon {

    private PS4Controller m_con;

    public PS4Con(int port) {
        m_con = new PS4Controller(port);
    }

    @Override
    public double getLeftX() {
        return m_con.getLeftX();
    }

    @Override
    public double getLeftY() {
        return m_con.getLeftY();
    }

    @Override
    public double getRightX() {
        return m_con.getRightX();
    }

    @Override
    public double getRightY() {
        return m_con.getRightY();
    }

    @Override
    public DpadDir getDpad() {
        int pov = m_con.getPOV();
        
        return DpadDir.fromInt(pov);
    }

}
