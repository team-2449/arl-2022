// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.profile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

import edu.wpi.first.wpilibj.Filesystem;

/** Used to create robot profiles. */
public class ProfileBuilder {

    /** Loads a {@link Profile} from deploy/profile/<fileName>.json.
     * 
     * @param fileName The name of the profile without the extension.
     * @return The generated {@code Profile}.
     */
    public static Profile fromFile(String fileName) {
        Path p = Filesystem.getDeployDirectory().toPath().resolve("profiles/" + fileName + ".json");
        
        try {
            String json = new String(Files.readAllBytes(p));

            Gson gson = new Gson();
            Profile profile = gson.fromJson(json, Profile.class);
            return profile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
