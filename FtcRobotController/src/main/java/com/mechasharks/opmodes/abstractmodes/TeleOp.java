package com.mechasharks.opmodes.abstractmodes;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class TeleOp extends AbstractOpMode {

    public void driveTeleOp(DriveMode mode) {
        switch (mode) {
            case ARCADE:
                singleStickDrive(gamepad1.right_stick_y, gamepad1.left_stick_x);
                break;
            case DIRECT:
                drive(gamepad1.left_stick_y, gamepad1.right_stick_y);
                break;
            case SINGLE_JOYSTICK:
                singleStickDrive(gamepad1.right_stick_y, gamepad1.right_stick_x);
                break;
        }
    }

    public void singleStickDrive(double forward, double turn) {
        double left = forward - turn;
        double right = forward + turn;
        double highest = Math.max(Math.abs(left), Math.abs(right));
        if (highest > 1) {
            right /= highest;
            left /= highest;
        }
        drive(left, right);
    }

    /**
     * Created by stjjensen1 on 11/30/2015.
     */
    public enum DriveMode {
        ARCADE, DIRECT, SINGLE_JOYSTICK
    }
}
