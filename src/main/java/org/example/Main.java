package org.example;

// Feet Converter Program
// Program that converts Feet to Meters and Meters to Feet
// Chad Swift
// SDEV200-50P
// Module 1 Assignment 1

public class Main {

    public static void main(String[] args) {

        // Tester class with testing data passed into constructor
        MeasurementTester tester = new MeasurementTester(
                new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0 },
                new Double[] { 20.0, 25.0, 30.0, 35.0, 40.0, 45.0, 50.0, 55.0, 60.0, 65.0 }
        );

        // Creating the table with data
        tester.testAndPrintTable();

    }
}

class MeasurementConverter {
    //store these so they are available in the class itself
    final static double METER_CONVERSION_NUMBER = 0.305;
    final static double FOOT_CONVERSION_NUMBER = 3.279;

    /**
     * Convert from feet to meters
     **/
    public static double footToMeter(double foot) {
        return METER_CONVERSION_NUMBER * foot;
    }

    /**
     * Convert from meters to feet
     **/
    public static double meterToFoot(double meter) {
        return FOOT_CONVERSION_NUMBER * meter;
    }
}

class MeasurementTester {

    // store testing data for ease of use, final private so it can't be messed with once set
    final private Double[] sampleFootData;
    final private Double[] sampleMeterData;

    // store converted data for ease of use, final private so it can't be messed with once set
    final private Double[] footToMeterConvertedData;
    final private Double[] meterToFootConvertedData;

    // constructor sets the sample data plus instantiates the conversion arrays since we know how long they need to be
    MeasurementTester(Double[] sampleFootData, Double[] sampleMeterData) {
        this.sampleFootData = sampleFootData;
        this.sampleMeterData = sampleMeterData;
        meterToFootConvertedData = new Double[sampleMeterData.length];
        footToMeterConvertedData = new Double[sampleFootData.length];
    }

    /**
     * Private method for separation, runs the method meterToFoot on the MeasurementConverter class to test it
     **/
    private void testFootToMeterConversion() {
        for (int i = 0; i < sampleFootData.length; i++){
            footToMeterConvertedData[i] = MeasurementConverter.footToMeter(sampleFootData[i]);
        }
    }

    /**
     * Private method for separation, runs the method meterToFoot on the MeasurementConverter class to test it
     **/
    private void testMeterToFootConversion() {
        for (int i = 0; i < sampleMeterData.length; i++){
            meterToFootConvertedData[i] = MeasurementConverter.meterToFoot(sampleMeterData[i]);
        }
    }

    /**
     * Runs the methods made for testing and builds the output table for the test once data;
     **/
    public void testAndPrintTable() {
        this.testFootToMeterConversion();
        this.testMeterToFootConversion();

        System.out.printf("%4s %11s %14s %10s", "Feet", "Meters", "Meters", "Feet");
        System.out.println("\n-------------------------------------------");
        for (int i = 0; i < footToMeterConvertedData.length; i++) {
            System.out.printf("%4.1f %10.3f %15.1f %10.3f", sampleFootData[i], footToMeterConvertedData[i], sampleMeterData[i], meterToFootConvertedData[i]);
            System.out.println();
        }
    }
}