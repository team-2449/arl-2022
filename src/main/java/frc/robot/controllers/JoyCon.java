// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.controllers;

import edu.wpi.first.wpilibj.drive.Vector2d;

/** Represents a Controller device. */
public abstract class JoyCon {

    public enum DpadDir {
        NONE (-1),
        UP (0), RIGHT (90), DOWN(180), LEFT(270),
        UPRIGHT (45), DOWNRIGHT(135), DOWNLEFT(225), UPLEFT(315);

        private final int m_value;

        DpadDir(int value) {
            m_value = value;
        }

        public int asInt() {
            return m_value;
        }

        public static DpadDir fromInt(int value) {
            switch (value) {
                case -1: return NONE;
                case 0: return UP;
                case 90: return RIGHT;
                case 180: return DOWN;
                case 270: return LEFT;
                case 45: return UPRIGHT;
                case 135: return DOWNRIGHT;
                case 225: return DOWNLEFT;
                case 315: return UPLEFT;
            }
            
            return NONE;
        }
    }

    public abstract double getLeftX();
    public abstract double getLeftY();

    public Vector2d getLeft() {
        return new Vector2d(getLeftX(), getLeftY());
    }

    public abstract double getRightX();
    public abstract double getRightY();

    public Vector2d getRight() {
        return new Vector2d(getRightX(), getRightY());
    }

    public abstract DpadDir getDpad();

}
