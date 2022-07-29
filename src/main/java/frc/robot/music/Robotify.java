// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.music;

/** Used to play music from select MotorControllerGroup instances. */
public interface Robotify {
    
    public void load(String name);
    public void play();
    public void pause();
    public void stop();

}
