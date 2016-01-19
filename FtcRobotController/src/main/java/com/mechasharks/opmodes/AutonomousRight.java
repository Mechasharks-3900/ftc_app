package com.mechasharks.opmodes;

import com.mechasharks.Command;
import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by stjzito1 on 11/17/2015.
 */
@Register(name = "Autonomous")
public class AutonomousRight extends AutonomousOp {


    private boolean moved = false, turned = false;

    @Override
    public void init() {
        super.init();
        ServoTo(boxLiftRight,0);
        ServoTo(boxLiftLeft,0);
        ServoTo(flipper,0);
    }

    @Override
    public void start() {
        command = new Sequential(
                        new DriveTo(10000, 5),
                        new TurnTo(180, 2));

        super.start();
    }

    @Override
    public void loop() {
        telemetry.addData("encoder",driveLeftFront.getCurrentPosition());
        if (!moved && driveLeftFront.getCurrentPosition() > -12000) {
            drive(1,1);
        } else if (!turned && driveLeftFront.getCurrentPosition() < -11600) {
            drive(-1, 1);
            moved = true;
        } else {
            turned = true;
            drive(1,1);
        }
    }
}
