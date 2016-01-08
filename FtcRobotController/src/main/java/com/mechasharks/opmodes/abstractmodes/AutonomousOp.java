package com.mechasharks.opmodes.abstractmodes;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

import com.qualcomm.robotcore.hardware.GyroSensor;

public abstract class AutonomousOp extends AbstractOpMode {

    protected GyroSensor gyroSensor;

    @Override
    public void init() {
        super.init();
        gyroSensor = hardwareMap.gyroSensor.get("gyro main");
    }

    public void turn(int position, float power) {
        turn(position, power, true);
    }

    public void turn(int position, float power, boolean relative){
        moveTo(driveLeftBack,position, power, relative);
        moveTo(driveLeftFront,position, power, relative);
        moveTo(driveRightBack,position, power, relative);
        moveTo(driveRightFront,position, power, relative);
    }
}
