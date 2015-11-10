package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by stjjensen1 on 11/9/2015.
 */
public class ServoTest extends OpMode {

    Servo servo_1, servo_2;

    @Override
    public void init() {
        servo_1 = hardwareMap.servo.get("servo_1");
        servo_1 = hardwareMap.servo.get("servo_2");
    }

    @Override
    public void loop() {
        servo_1.setPosition(gamepad1.left_stick_y);
        servo_2.setPosition(gamepad1.right_trigger * 2 - 1);
    }
}
