package com.mechasharks.robot;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class TeleOp extends AbstractOpmode{

    protected WrappedGamepad gamepad1 = new WrappedGamepad(super.gamepad1),
            gamepad2 = new WrappedGamepad(super.gamepad2);




    public void tankDrive(){
        driveLeft.setPower(gamepad1.leftStick.getY());
        driveRight.setPower(gamepad1.rightStick.getY());
    }

    public void singleStickDrive(){
        double ratio=(gamepad1.rightStick.getY()+1)/2;
        driveLeft.setPower(gamepad1.rightStick.getY() * (1 - ratio));
        driveRight.setPower(gamepad1.rightStick.getY() * ratio);
    }
}
