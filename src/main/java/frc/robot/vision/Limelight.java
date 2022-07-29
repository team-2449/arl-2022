// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/** Used to interface with the limelight vision system. */
public class Limelight {

    private NetworkTableEntry m_targetVisible, m_targetX, m_targetY, m_targetArea;

    private double m_targetHeight;
    private double m_cameraHeight;
    private double m_mountingAngle;

    public Limelight(String name, double targetHeight, double cameraHeight, double mountingAngle) {
        m_targetHeight = targetHeight;
        m_cameraHeight = cameraHeight;
        m_mountingAngle = mountingAngle;
        
        NetworkTable limelight = NetworkTableInstance.getDefault().getTable(name);
        m_targetVisible = limelight.getEntry("tv");
        m_targetX = limelight.getEntry("tx");
        m_targetY = limelight.getEntry("ty");
        m_targetArea = limelight.getEntry("ta");
    }

    public boolean canSeeTarget() {
        return m_targetVisible.getDouble(0.0) == 1.0;
    }

    public double targetX() {
        return m_targetX.getDouble(0.0);
    }

    public double targetY() {
        return m_targetY.getDouble(0.0);
    }

    public double targetArea() {
        return m_targetArea.getDouble(0.0);
    }

    public double targetDistance() {
        double opposite = m_targetHeight - m_cameraHeight;
        double angle = m_mountingAngle + targetY();
        return opposite / Math.tan(Math.toRadians(angle));
    }

}
