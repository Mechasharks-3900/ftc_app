package com.mechasharks.opmodes.abstractmodes;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class TeleOp extends AbstractOpMode {

    public void driveTeleOp(TankMode mode) {
        if (mode == TankMode.DIRECT)
            drive(gamepad1.left_stick_y, gamepad1.right_stick_y);
        else
            singleStickDrive(gamepad1.right_stick_y, gamepad1.right_stick_x);
    }

    public void singleStickDrive(double forward, double turn) {
        double ratio = (turn + 1) / 2;
        double left = forward * (1 - ratio), right = forward * ratio;
        drive(left, right);
    }

    /**
     * Created by stjjensen1 on 11/30/2015.
     */
    public static enum TankMode {
        DIRECT, SINGLE_JOYSTICK
    }
}
