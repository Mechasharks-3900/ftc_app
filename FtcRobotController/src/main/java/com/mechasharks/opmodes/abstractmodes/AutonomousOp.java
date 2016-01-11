package com.mechasharks.opmodes.abstractmodes;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

import com.qualcomm.robotcore.hardware.GyroSensor;

public abstract class AutonomousOp extends AbstractOpMode {


    @Override
    public void init() {
        super.init();
    }

    public void turnWithGyro(int Degree, boolean right) {
        int initialDegree = gyroSensor.getHeading();
        int degreesErrorLeft = initialDegree - Degree;
        int degreesErrorRight = initialDegree + Degree;
        if (!right) {
            while (Degree != 0) {
                degreesErrorRight = gyroSensor.getHeading() - initialDegree;
                if (degreesErrorRight >= 20) {
                    drive(-1, 1);
                } else {
                    drive(-1 / 20, 1 / 20);
                }
            }
        } else {
            while (Degree != 0) {
                degreesErrorLeft = initialDegree - gyroSensor.getHeading();
                if (degreesErrorLeft >= 20) {
                    drive(-1, 1);
                } else {
                    drive(-1 / 20, 1 / 20);
                }
            }
        }
    }

    public void turn(int position, float power, boolean relative) {
        moveTo(driveLeftFront, position, power, relative);
        moveTo(driveRightFront, position, power, relative);
        moveTo(driveLeftBack, position, power, relative);
        moveTo(driveRightBack, position, power, relative);
    }
}
