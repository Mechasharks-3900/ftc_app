package com.mechasharks;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by stjjensen1 on 1/14/2016.
 */
public class MotorGroup {
    private DcMotor[] motors;
    public MotorGroup(DcMotor... motors) {
        this.motors = motors;
    }
    public void setMode(DcMotorController.RunMode mode) {
        for (DcMotor m : motors)
            m.setMode(mode);
    }

    public void setPower(double power) {
        for (DcMotor m : motors)
            m.setPower(power);
    }

    public DcMotor[] getMotors() {
        return motors;
    }
}
