package com.mechasharks.robot;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public class Joystick {
    private final Side side;

    public enum Side { LEFT, RIGHT }
    private final Gamepad gamepad;

    public Joystick(Gamepad gamepad, Side side) {
        this.gamepad = gamepad;
        this.side = side;
    }

    public float getX() {
        return side == Side.LEFT ? gamepad.left_stick_x : gamepad.left_trigger * 2 - 1;
    }

    public float getY() {
        return side == Side.LEFT ? gamepad.left_stick_y : gamepad.right_trigger * 2 - 1;
    }

    public boolean button() {
        return side == Side.LEFT ? gamepad.left_stick_button : gamepad.right_stick_button;
    }
}
