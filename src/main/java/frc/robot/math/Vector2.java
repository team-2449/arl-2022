// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.math;

import edu.wpi.first.wpilibj.drive.Vector2d;

/** Represents a two-dimensional vector. */
public class Vector2 {

    public double x;
    public double y;

    /** Initializes a vector with all components set to 0. */
    public Vector2() {
        this(0.0);
    }

    /** Initializes a vector with all components set to a scalar value. */
    public Vector2(double scalar) {
        x = scalar;
        y = scalar;
    }

    /** Initializes a vector with specified component values. */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Adds another vector's values to the calling object's values. */
    public Vector2 add(Vector2 other) {
        x += other.x;
        y += other.y;
        return this;
    }

    /** Subtracts another vector's values from the calling object's values. */
    public Vector2 subtract(Vector2 other) {
        x -= other.x;
        y -= other.y;
        return this;
    }

    /** Multiplies the calling object's values by another vector's values. */
    public Vector2 multiply(Vector2 other) {
        x *= other.x;
        y *= other.y;
        return this;
    }

    /** Divides the calling object's values by another vector's values. */
    public Vector2 divide(Vector2 other) {
        x /= other.x;
        y /= other.y;
        return this;
    }

    /** Returns the length of the caller. */
    public double length() {
        return Math.sqrt(length2());
    }

    /** Returns the square of the caller's length. */
    public double length2() {
        return x * x + y * y;
    }

    /** Rotates the caller by a given value counterclockwise. */
    public Vector2 rotate(double radians) {
        // https://www.codegrepper.com/code-examples/whatever/rotate+2d+vector+by+angle
        double c = Math.cos(radians);
        double s = Math.sin(radians);

        double newX = x * c - y * s;
        double newY = x * s + y * c;

        x = newX;
        y = newY;

        return this;
    }

    /** Converts the vector to its WPILib equivalent. */
    public Vector2d wpi() {
        return new Vector2d(x, y);
    }

}
