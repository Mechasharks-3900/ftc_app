package com.mechasharks.opmodes.abstractmodes;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

public abstract class AutonomousOp extends AbstractOpMode {

    @Override
    public void init() {
        super.init();
    }

    public int turnWithGyro(int degree) {
        int difference = degree - gyroSensor.getHeading();
        double power = difference / 20d;
        if (power > 1) power = 1;
        else if (power < -1) power = -1;
        turn(power);
        return difference;
    }

    public void turn(double power) {
        drive(-power, power);
    }
}
