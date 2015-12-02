package com.mechasharks.opmodes;

import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 12/1/2015.
 */
public class GamepadTest extends TeleOp {

    @Override
    public void loop() {
        telemetry.addData("Button States",
                String.format("A: %b, B: %b, X: %b, Y: %b",
                        gamepad1.a(),
                        gamepad1.b(),
                        gamepad1.x(),
                        gamepad1.y()));
    }
}
