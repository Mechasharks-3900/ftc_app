package com.mechasharks;

/**
 * Created by stjjensen1 on 12/21/2015.
 */
public class PID {
    private final double pCoeff;
    private final double iCoeff;
    private final double dCoeff;

    public PID(double proportional, double integral, double derivative) {
        this.pCoeff = proportional;
        this.iCoeff = integral;
        this.dCoeff = derivative;
    }

    private double cumulative;
    private double previousValue;
    private double previousTime;
    public double next(double target, double feedback) {
        double proportional = feedback - target;
        cumulative += proportional;
        double derivative = (previousValue - feedback)/(System.nanoTime()/1_000_000_000d - previousTime);

        double nextVal = proportional * pCoeff + cumulative * iCoeff + derivative * dCoeff;

        previousTime = System.nanoTime()/1_000_000_000d;
        previousValue = feedback;

        return nextVal;
    }
}
