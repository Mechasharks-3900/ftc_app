package com.mechasharks.robot;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver2 extends TeleOp {
    @Override
    public void loop() {
        drive(gamepad1.leftStick.getY(), gamepad1.rightStick.getY());
        telemetry.addData("Speed", "left:" + gamepad1.leftStick.getY() + "right:" + (-1*(gamepad1.rightStick.getY() * 2 - 1)));
    }
}
