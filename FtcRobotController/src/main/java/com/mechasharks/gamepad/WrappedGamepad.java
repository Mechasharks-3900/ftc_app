package com.mechasharks.gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public class WrappedGamepad {

    public final Gamepad gamepad;
    public final Joystick leftStick;
    public final Joystick rightStick;

    public boolean buttonState(Button b) {
        switch (b) {
            case A:
                return gamepad.a;
            case B:
                return gamepad.b;
            case X:
                return gamepad.x;
            case Y:
                return gamepad.y;
            default:
                throw new AssertionError("Unreachable code. Was another button added to the Button enum?");
        }
    }
    
    public boolean a() {
        return buttonState(Button.A);
    }

    public boolean b() {
        return buttonState(Button.B);
    }

    public boolean x() {
        return buttonState(Button.X);
    }

    public boolean y() {
        return buttonState(Button.Y);
    }

    private boolean[] states = new boolean[Button.values().length];
    public boolean buttonChangedState(Button b) {
        boolean newVal = buttonState(b);
        boolean oldVal = states[b.ordinal()];
        states[b.ordinal()] = newVal;
        return newVal != oldVal;
    }

    public WrappedGamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
        leftStick = new Joystick(gamepad, Joystick.Side.LEFT);
        rightStick = new Joystick(gamepad, Joystick.Side.RIGHT);
    }
}
