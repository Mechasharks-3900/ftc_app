package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 12/1/2015.
 */
@Register(name = "Gamepad Test")
public class GamepadTest extends TeleOp {

    boolean whichPad = true;
    Gamepad pad;

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        pad = whichPad ? gamepad1 : gamepad2;
        telemetry.addData("Current Controller", whichPad ? "gamepad 1" : "gamepad 2");
        telemetry.addData("Button States",
                String.format("A: %b, B: %b, X: %b, Y: %b",
                        pad.a,
                        pad.b,
                        pad.x,
                        pad.y
                ));
        telemetry.addData("DPad",
                String.format("Right: %b, Up: %b, Left: %b, Down: %b",
                        pad.dpad_right,
                        pad.dpad_up,
                        pad.dpad_left,
                        pad.dpad_down
                ));
        telemetry.addData("Joysticks",
                String.format("X1: %f, Y1: %f, B1: %b, X2: %f, Y2: %f, B2: %b",
                        pad.left_stick_x,
                        pad.left_stick_y,
                        pad.left_stick_button,
                        pad.right_stick_x,
                        pad.right_stick_y,
                        pad.right_stick_button
                ));

        if (gamepad2.a && whichPad) {
            whichPad = false;
        }
        else if (gamepad1.a && whichPad) {
            whichPad = true;
        }
    }
}
