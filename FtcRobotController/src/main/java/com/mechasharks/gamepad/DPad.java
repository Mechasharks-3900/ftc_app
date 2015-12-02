package com.mechasharks.gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 12/1/2015.
 */
public class DPad {
    private final Gamepad gamepad;

    public enum Direction {
        RIGHT,
        UP,
        LEFT,
        DOWN,
    }

    public boolean right() {
        return get(Direction.RIGHT);
    }
    public boolean up() {
        return get(Direction.UP);
    }
    public boolean left() {
        return get(Direction.LEFT);
    }
    public boolean down() {
        return get(Direction.DOWN);
    }

    public boolean get(Direction dir) {
        switch (dir) {
            case RIGHT:
                return gamepad.dpad_right;
            case UP:
                return gamepad.dpad_up;
            case LEFT:
                return gamepad.dpad_left;
            case DOWN:
                return gamepad.dpad_down;
        }
        throw new AssertionError("Unreachable code");
    }

    public DPad(Gamepad gamepad) {
        this.gamepad = gamepad;
    }
}
