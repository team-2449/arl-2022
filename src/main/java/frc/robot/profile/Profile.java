// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.profile;

import java.util.ArrayList;
import java.util.List;

import frc.robot.controllers.JoyCon;
import frc.robot.controllers.LogiCon;
import frc.robot.controllers.PS4Con;
import frc.robot.drive.MotorConGroup;
import frc.robot.drive.MotorConGroup.Type;

/** Represents the current configuration of the robot. */
public class Profile {

    public class Drive {
        private String type = "";
        private List<Integer> leftids = new ArrayList<>();
        private List<Integer> rightids = new ArrayList<>();

        Drive() {
        }

        public MotorConGroup.Type getType() {
            switch (type) {
                case ProfileStrings.TALON_FX:
                    return Type.TALON_FX;
                case ProfileStrings.TALON_SRX:
                    return Type.TALON_SRX;
                default:
                    // TODO: Log?
                    return null;
            }
        }

        public List<Integer> getLeftIDs() {
            return leftids;
        }

        public List<Integer> getRightIDs() {
            return rightids;
        }
    }

    public class OI {
        private String controller = "";

        OI() {
        }

        public JoyCon createController() {
            switch (controller) {
                case ProfileStrings.LOGI:
                    return new LogiCon(0);
                case ProfileStrings.PS4:
                    return new PS4Con(0);
                default:
                    return null;
            }
        }
    }

    public Drive drive = null;
    public OI oi = null;

    Profile() {
    }

}
