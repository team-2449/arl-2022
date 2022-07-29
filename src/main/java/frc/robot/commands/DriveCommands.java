// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DriveSubsystem;

/** Add your docs here. */
public class DriveCommands {

    /** Generates a drive train command that sets its output to a percent value.
     * 
     * @param drive The drive subsystem to use.
     * @param left The left output, between 0 and 1.
     * @param right The right output, between 0 and 1.
     * @return The command to execute.
     */
    public static Command percent(DriveSubsystem drive, double left, double right) {
        return new InstantCommand(() -> {
            drive.drivePercent(left, right);
        }, drive);
    }

    /** Generates a command that will stop the drive train.
     * 
     * @param drive The drive subsystem to use.
     * @return The command to execute.
    */
    public static Command stop(DriveSubsystem drive) {
        return new InstantCommand(() -> {
            drive.drivePercent(0, 0);
        }, drive);
    }

}
