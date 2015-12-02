package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.gamepad.WrappedGamepad;
import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 12/1/2015.
 */
@Register(name = "Gamepad Test")
public class GamepadTest extends TeleOp {

    WrappedGamepad pad;

    @Override
    public void start() {
        super.start();
        pad = gamepad1;
    }

    @Override
    public void loop() {
        telemetry.addData("Current Controller", pad == gamepad1 ? "gamepad 1" : "gamepad 2");
        telemetry.addData("Button States",
                String.format("A: %b, B: %b, X: %b, Y: %b",
                        pad.a(),
                        pad.b(),
                        pad.x(),
                        pad.y()
                ));
        telemetry.addData("DPad",
                String.format("Right: %b, Up: %b, Left: %b, Down: %b",
                        pad.dpad.right(),
                        pad.dpad.up(),
                        pad.dpad.left(),
                        pad.dpad.down()
                ));
        telemetry.addData("Joysticks",
                String.format("X1: %f, Y1: %f, B1: %b, X2: %f, Y2: %f, B2: %b",
                        pad.leftStick.getX(),
                        pad.leftStick.getY(),
                        pad.leftStick.button(),
                        pad.rightStick.getX(),
                        pad.rightStick.getY(),
                        pad.rightStick.button()
                ));

        if (pad == gamepad1 && gamepad2.a())
            pad = gamepad2;
        else if (pad == gamepad2 && gamepad1.a())
            pad = gamepad1;
    }
}
