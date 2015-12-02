package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by stjjensen1 on 12/1/2015.
 */
@Register(name = "Motor Test")
public class MotorTest extends TeleOp {

    List<Map.Entry<String,DcMotor>> motors;

    @Override
    public void start() {
        super.start();
        motors = new ArrayList<>(hardwareMap.dcMotor.entrySet());
    }

    int index = 0;
    double power = 0;
    boolean upPressed, downPressed;

    @Override
    public void loop() {
        if (gamepad1.dpad.right()) {
            power += 1.0 / 64;
        }
        if (gamepad1.dpad.left()) {
            power -= 1.0 / 64;
        }
        int newIndex = index;
        if (upPressed != gamepad1.dpad.up()) {
            if (gamepad1.dpad.up()) {
                power = 0;
                newIndex = (index + motors.size() - 1) % motors.size();
            }
            upPressed = gamepad1.dpad.up();
        }
        if (downPressed != gamepad1.dpad.down()) {
            if (gamepad1.dpad.down()) {
                power = 0;
                newIndex = (index + 1) % motors.size();
            }
            downPressed = gamepad1.dpad.down();
        }
        motors.get(index).getValue().setPower(power);
        index = newIndex;
    }
}
