package com.mechasharks.opmodes;

import com.mechasharks.Command;
import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by stjzito1 on 11/17/2015.
 */
@Register(name = "Autonomous Test")
public class AutonomousTest1 extends AutonomousOp {

    private boolean loweredArm = false;

    @Override
    public void start() {
        command = new Simultaneous(
                new Command() {
                    @Override
                    public boolean act() {
                        armLift(-.5);
                        if (leadScrewArm.isPressed()) {
                            armLift.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                            return true;
                        }
                        return false;
                    }
                },
                new Sequential(
                        new DriveTo(500, 5),
                        new TurnTo(90, 2)));
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
