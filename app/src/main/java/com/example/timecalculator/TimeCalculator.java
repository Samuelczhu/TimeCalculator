package com.example.timecalculator;

/**
 * This class is use for the time calculation
 * This class is a util class and not meant to be instantiated
 * @author samuel zhu
 * @version 1.0
 */
public class TimeCalculator {
    /**
     * Private constructor to forbid instantiate
     */
    private TimeCalculator(){}

    /**
     * This method is use to calculate the time difference in 12-hour system, answer is in hour
     * @param startHour the hour of start time
     * @param startMin the minute of start time
     * @param startIsPM true if start time is in PM
     * @param endHour the hour of end time
     * @param endMin the minute of end time
     * @param endIsPM true if end time is in PM
     * @return double represent the time difference in hours
     */
    public static double twelveCalc(int startHour, int startMin, boolean startIsPM, int endHour, int endMin, boolean endIsPM, double deductHour) {
        //check for invalid pm argument
        if(startIsPM && !endIsPM )
            throw new IllegalArgumentException("Start is in PM but end is in AM, impossible!");
        //convert to twenty-four hour system
        if (startIsPM)
            startHour+=12;
        if (endIsPM)
            endHour+=12;
        //use the method in calculate 24 system
        return twentyFourCalc(startHour,startMin,endHour,endMin,deductHour);
    }

    public static double twentyFourCalc(int startHour, int startMin, int endHour, int endMin, double deductHour) {
        //check for invalid arguments
        if (startHour>endHour || !(0<=startHour&&startHour<24) || !(0<=endHour&&endHour<=24) || !(0<=startMin&&startMin<60) || !(0<=endMin&&endMin<60) || deductHour<0)
            throw new IllegalArgumentException("Invalid time entered");

        //calculate the time difference in hours
        int hourDiff = endHour-startHour;
        int minDiff = endMin-startMin;
        if (minDiff<0) {
            minDiff+=60;
            hourDiff--;
        }
        return (1.0*hourDiff + minDiff/60.0) - deductHour;
    }
}
