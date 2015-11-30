package com.mechasharks.robot;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stjjensen1 on 11/9/2015.
 */
@Register(name = "Servo Test")
public class ServoTest extends TeleOp {

    Servo servo_1, servo_2;

    @Override
    public void init() {
        servo_1 = hardwareMap.servo.get("servo_1");
        servo_1 = hardwareMap.servo.get("servo_2");
    }

    @Override
    public void loop() {
        servo_1.setPosition(gamepad1.leftStick.getY());
        servo_2.setPosition(gamepad1.rightStick.getY());
    }
}
