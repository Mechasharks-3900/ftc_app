package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.gamepad.WrappedGamepad;
import com.mechasharks.opmodes.abstractmodes.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by stjjensen1 on 12/7/2015.
 */
@Register(name = "Raw Gamepad Test")
public class RawGamepadTest extends TeleOp {

    private Gamepad rawGamepad;

    @Override
    public void start() {
        super.start();
        try {
            rawGamepad = (Gamepad) WrappedGamepad.class.getField("gamepad").get(gamepad1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loop() {
        telemetry.addData("Button States",
                String.format("A: %b, B: %b, X: %b, Y: %b",
                        rawGamepad.a,
                        rawGamepad.b,
                        rawGamepad.x,
                        rawGamepad.y
                ));
        telemetry.addData("DPad",
                String.format("Right: %b, Up: %b, Left: %b, Down: %b",
                        rawGamepad.dpad_right,
                        rawGamepad.dpad_up,
                        rawGamepad.dpad_left,
                        rawGamepad.dpad_down
                ));
        telemetry.addData("Joysticks",
                String.format("X1: %f, Y1: %f, B1: %b, X2: %f, Y2: %f, B2: %b",
                        rawGamepad.left_stick_x,
                        rawGamepad.left_stick_y,
                        rawGamepad.left_stick_button,
                        rawGamepad.right_stick_x,
                        rawGamepad.right_stick_y,
                        rawGamepad.right_stick_button
                ));
    }
}
