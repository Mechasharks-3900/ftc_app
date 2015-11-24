package com.mechasharks.robot;

/**
 * Created by stjjensen1 on 11/20/2015.
 */
public abstract class TeleOp extends AbstractOpmode{

    protected WrappedGamepad gamepad1 = new WrappedGamepad(super.gamepad1),
            gamepad2 = new WrappedGamepad(super.gamepad2);


}
