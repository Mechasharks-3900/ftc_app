package com.mechasharks.opmodes;

import com.mechasharks.Register;
import com.mechasharks.opmodes.abstractmodes.AutonomousOp;

/**
 * Created by stjzito1 on 11/17/2015.
 */
@Register(name = "Autonomous Test")
public class AutonomousTest1 extends AutonomousOp {

    @Override
    public void init(){
        super.init();
    }

    @Override
    public void start(){
        driveTo(1, 100);
    }

    @Override
    public void loop(){
        telemetry.addData("Right Encoder", driveRightBack.getChannelMode());
        telemetry.addData("Right Encoder Target", driveRightBack.getTargetPosition());
        telemetry.addData("Right Encoder Current", driveRightBack.getCurrentPosition());
        telemetry.addData("Left Encoder", driveLeftBack.getChannelMode());
        telemetry.addData("Left Encoder Target", driveLeftBack.getTargetPosition());
        telemetry.addData("Left Encoder Current", driveLeftBack.getCurrentPosition());
    }
}
