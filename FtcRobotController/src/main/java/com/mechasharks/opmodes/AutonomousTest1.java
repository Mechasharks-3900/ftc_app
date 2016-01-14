package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;

/**
 * Created by stjzito1 on 11/17/2015.
 */
@Register(name = "Autonomous Test")
public class AutonomousTest1 extends AutonomousOp {



    @Override
    public void start() {
        command = new Sequential(
                new DriveTo(500, 5),
                new TurnTo(90, 2)
        );

        super.start();
    }

    @Override
    public void loop() {
        if (command.act())
            if (command != null)
                command = null;
        telemetry.addData("Gyro Heading", gyroSensor.getHeading());
    }
}
