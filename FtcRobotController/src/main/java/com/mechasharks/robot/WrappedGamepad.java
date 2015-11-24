package com.mechasharks.robot;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public class WrappedGamepad {
    public final Gamepad gamepad;
    public final Joystick leftStick;
    public final Joystick rightStick;


    public WrappedGamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
        leftStick = new Joystick(gamepad, Joystick.Side.LEFT);
        rightStick = new Joystick(gamepad, Joystick.Side.RIGHT);
    }
}
