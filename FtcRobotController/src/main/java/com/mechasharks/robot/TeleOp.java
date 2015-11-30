package com.mechasharks.robot;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class TeleOp extends AbstractOpmode {

    protected WrappedGamepad gamepad1 = new WrappedGamepad(super.gamepad1),
            gamepad2 = new WrappedGamepad(super.gamepad2);

    public void driveTeleOp(TankMode mode) {
        if (mode == TankMode.DIRECT)
            drive(gamepad1.leftStick.getY(), gamepad1.rightStick.getY());
        else
            singleStickDrive(gamepad1.rightStick.getY(), gamepad1.rightStick.getX());
    }

    public void singleStickDrive(double forward, double turn) {
        double ratio = (turn + 1) / 2;
        double left = forward * (1 - ratio), right = forward * ratio;
        drive(left, right);
    }
}
