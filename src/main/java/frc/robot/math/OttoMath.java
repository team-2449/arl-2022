// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.math;

/** Contains miscellaneous functions pertaining to mathemathics. */
public class OttoMath {

    /** Clamps a number between two values. */
    public static double clamp(double value, double min, double max) {
        double out = value;
        if (out > max) {
            return max;
        }
        return out < min ? min : out;
    }

    /** Forces a value into intervals between 0 and 1. */
    public static double quantize(double value, double interval) {
        double toMult = 1.0 / interval;
        value *= toMult;
        value = Math.round(value);
        value /= toMult;
        return value;
    }

    /** Compares two floating point numbers. */
    public static boolean fequal(double left, double right, double eps) {
        return Math.abs(right - left) < eps;
    }

}
