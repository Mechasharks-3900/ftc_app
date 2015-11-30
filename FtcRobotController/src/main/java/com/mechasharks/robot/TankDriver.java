package com.mechasharks.robot;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver extends TeleOp {
    private enum TankMode { DIRECT, SINGLE_JOYSTICK }

    private TankMode tankMode = TankMode.DIRECT;

    public void driveTeleOp(TankMode mode) {
        float left, right;
        if (mode == TankMode.DIRECT) {
            left = gamepad1.leftStick.getY();
            right = gamepad1.rightStick.getY();
        }
        else {
            float ratio = gamepad1.rightStick.getX() / 2 + 1/2;
            float power = gamepad1.rightStick.getY();
            left = power * (1 - ratio);
            right = power * ratio;
        }
        drive(left, right);
    }

    @Override
    public void loop() {
        if (gamepad1.buttonChangedState(Button.A) && gamepad1.a()) {
            tankMode = (tankMode == TankMode.DIRECT)
                    ? TankMode.SINGLE_JOYSTICK
                    : TankMode.DIRECT;
        }
        driveTeleOp(tankMode);
    }


}
