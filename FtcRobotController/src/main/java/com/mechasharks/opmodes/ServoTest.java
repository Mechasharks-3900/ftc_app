package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stjjensen1 on 11/9/2015.
 */
@Register(name = "Servo Test")
public class ServoTest extends TeleOp {

    @Override
    public void loop() {
        boxLiftRight.setPosition(1);
        boxLiftLeft.setPosition(0);
    }
}
