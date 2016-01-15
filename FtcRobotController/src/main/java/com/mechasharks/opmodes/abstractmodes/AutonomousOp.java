package com.mechasharks.opmodes.abstractmodes;

import com.mechasharks.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by stjjensen1 on 11/20/2015.
 */

public abstract class AutonomousOp extends AbstractOpMode{
    protected Command command;

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

    @Override
    public void loop() {

    }

    ////////////////////////////////////////////////////////


    public class DriveTo extends Command {

        int[] newPositions;
        int error;

        public DriveTo(int position, int error) {
            newPositions = new int[]{
                    driveLeftFront.getCurrentPosition() + position,
                    driveLeftBack.getCurrentPosition() + position,
                    driveRightFront.getCurrentPosition() + position,
                    driveRightBack.getCurrentPosition() + position
            };
            this.error = error;
        }

        @Override
        public boolean act() {
            return (moveTo(driveLeftFront, newPositions[0], 1) +
                    moveTo(driveLeftBack, newPositions[1], 1) +
                    moveTo(driveRightFront, newPositions[2], 1) +
                    moveTo(driveRightBack, newPositions[3], 1)) < error * 4;
        }
    }

    public class TurnTo extends Command {
        int finalDir;
        int error;

        public TurnTo(int amount, int error) {
            finalDir = gyroSensor.getHeading() + amount;
            this.error = error;
        }

        @Override
        public boolean act() {
            return turnWithGyro(finalDir) < error;
        }
    }

    private abstract class Control extends Command {
        List<Command> commands;

        public Control(Command... commands) {
            this.commands = new ArrayList<>(Arrays.asList(commands));
        }
    }

    /**
     * A set of Commands to run simultaneously
     */
    public class Simultaneous extends Control {

        public Simultaneous(Command... commands) {
            super(commands);
        }

        @Override
        public boolean act() {
            Iterator<Command> iter = commands.iterator();
            while (iter.hasNext())
                if (iter.next().act())
                    iter.remove();
            return commands.size() == 0;
        }
    }

    /**
     * A list of commands that run sequentially
     */
    public class Sequential extends Command {
        private List<Command> commands;

        public Sequential(Command... commands) {
            this.commands = Arrays.asList(commands);
        }

        @Override
        public boolean act() {
            if (commands.get(0).act())
                commands.remove(0);
            return commands.size() == 0;
        }
    }


    public void touchSensorValues(double power, int pos){
        leadScrewArm.getValue();
        armHook.getValue();
        if(leadScrewArm.isPressed()){

        }
        else{

        }
        if(armHook.isPressed()){
        }
        else{

        }
    }
}
