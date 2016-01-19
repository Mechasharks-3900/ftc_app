package com.mechasharks.opmodes;

import com.mechasharks.Command;
import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AbstractOpMode;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by stjzito1 on 11/17/2015.
 */
//@Register(name = "Autonomous left flip")
public class AutonomousLeftFlip extends AutonomousOp {

    private boolean loweredArm = false;

    @Override
    public void init() {
        super.init();
        ServoTo(boxLiftRight,0);
        ServoTo(boxLiftLeft,0);
        ServoTo(flipper,1);
    }

    @Override
    public void start() {
        command =
                new Sequential(
                        new DriveTo(500000, 5),
                        new TurnTo(180, 2),
                        new ServoTo(flipper, 1));

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
