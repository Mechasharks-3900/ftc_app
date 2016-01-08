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

    public void turnWithGyro(int Degree, float power) {
        int initialDegree = gyroSensor.getHeading();
        int degreesErrorLeft = initialDegree - Degree;
        int degreesErrorRight = initialDegree + Degree;
        while (Degree != degreesErrorLeft) {
            degreesErrorLeft = initialDegree - gyroSensor.getHeading();
            if (degreesErrorLeft >= 20) {
                int powerLeft = -1;
                int powerRight = 1;
            } else {
                int powerLeft = (degreesErrorLeft/20)*1;
                int powerRight = (degreesErrorLeft/20)*-1;
            }
            while (Degree != degreesErrorRight) {
                degreesErrorRight = gyroSensor.getHeading() - initialDegree;
                if (degreesErrorRight >= 20) {
                    int powerLeft = -1;
                    int powerRight = 1;
                } else {
                    int powerLeft = (degreesErrorRight/20)*1;
                    int powerRight = (degreesErrorRight/20)*-1;
                }
                int powerLeft = degreesErrorLeft;
                int powerRight = degreesErrorRight;
                drive(powerLeft, powerRight);
            }
        }
    }

    public void turn(int position, float power, boolean relative){
        moveTo(driveLeftFront, position, power, relative);
        moveTo(driveRightFront, position, power, relative);
        moveTo(driveLeftBack, position, power, relative);
        moveTo(driveRightBack, position, power, relative);
    }
}
