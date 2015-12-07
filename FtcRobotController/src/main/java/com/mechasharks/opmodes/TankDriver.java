package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

@Register(name = "Tank Driver")
public class TankDriver extends TeleOp {

    private TankMode tankMode = TankMode.DIRECT;

    @Override
    public void loop() {
        if (gamepad1.a) {
            tankMode = (tankMode == TankMode.DIRECT)
                    ? TankMode.SINGLE_JOYSTICK
                    : TankMode.DIRECT;
        }
        driveTeleOp(tankMode);
        telemetry.addData("tankMode", tankMode);
    }
}
