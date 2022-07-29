// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.drive;

import java.util.ArrayList;
import java.util.List;

/** Used to create MotorControllerGroup instances. */
public class MotorConFactory {

    public static MotorConGroup create(MotorConGroup.Type type, List<Integer> ids) {
        switch (type) {
            case TALON_FX:
                return new TalonFXGroup(ids);
            case TALON_SRX:
                return new TalonSRXGroup(ids);
            default:
                // TODO: log?
                return null;
        }
    }

    public static MotorConGroup create(MotorConGroup.Type type, int[] ids) {
        List<Integer> internalIds = new ArrayList<>();
        for (int id : ids) {
            internalIds.add(id);
        }

        switch (type) {
            case TALON_FX:
                return new TalonFXGroup(internalIds);
            case TALON_SRX:
                return new TalonSRXGroup(internalIds);
            default:
                // TODO: log?
                return null;
        }
    }

}
