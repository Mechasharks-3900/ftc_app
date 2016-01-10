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

    public void turnWithGyro(int Degree, float power, boolean right) {
        int initialDegree = gyroSensor.getHeading();
        int degreesErrorLeft = initialDegree - Degree;
        int degreesErrorRight = initialDegree + Degree;
        int powerLeft = degreesErrorLeft;
        int powerRight = degreesErrorRight;
        if (!right) {
            while (Degree != degreesErrorRight) {
                degreesErrorRight = gyroSensor.getHeading() - initialDegree;
                if (degreesErrorRight >= 20) {
                    powerLeft = -1;
                    powerRight = 1;
                } else {
                    powerLeft = (degreesErrorRight / 20) * -1;
                    powerRight = (degreesErrorRight / 20) * 1;
                }
            }
        } else {
            while (Degree != degreesErrorLeft) {
                degreesErrorLeft = initialDegree - gyroSensor.getHeading();
                if (degreesErrorLeft >= 20) {
                    powerLeft = -1;
                    powerRight = 1;
                } else {
                    powerLeft = (degreesErrorLeft / 20) * -1;
                    powerRight = (degreesErrorLeft / 20) * 1;
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
