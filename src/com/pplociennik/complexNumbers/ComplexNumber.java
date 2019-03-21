package com.pplociennik.complexNumbers;

import java.util.Random;

public class ComplexNumber {

    private double realPart;
    private double imaginaryPart;
    private double angle;
    private double absoluteValue;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        //this.angle = angle;
        calcAbsoluteValue();

        double cosValue = Math.acos(realPart / absoluteValue);
        // double sinValue = Math.asin(imaginaryPart/absoluteValue);

        //if (cosValue == sinValue)
        this.angle = (((cosValue * 180) * 100.0) / 100.0);
        //else
        // System.out.println("RÓŻNE WARTOSCI F. TRYGONOMETRYCZNYCH!");
    }


    public void calcAbsoluteValue() {
        this.absoluteValue = (((Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2))) * 100.0) / 100.0);
    }

    public double getReal() {
        return realPart;
    }

    public double getIm() {
        return imaginaryPart;
    }

    public double getAngle() {
        return angle;
    }

    public double getAbsoluteValue() {
        return absoluteValue;
    }

    public String returnTrigonometric() {
        return absoluteValue + "(cos" + angle + " + isin" + angle + ")";
    }

    public static double toRadians(double angle) {
        return (angle * Math.PI) / 180;
    }

    public static ComplexNumber fromPolarCoordinates(double magnitude, double angle) {
        return new ComplexNumber(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    public ComplexNumber add(ComplexNumber component) {
        return new ComplexNumber(this.realPart + component.realPart, this.imaginaryPart + component.imaginaryPart);
    }

    public ComplexNumber subtract(ComplexNumber subtrahend) {
        return new ComplexNumber(this.realPart - subtrahend.realPart, this.imaginaryPart - subtrahend.imaginaryPart);
    }

    public ComplexNumber multiply(ComplexNumber factor) {
        return new ComplexNumber((this.realPart * factor.realPart) - (this.imaginaryPart * factor.imaginaryPart), (this.realPart * factor.imaginaryPart) + (this.imaginaryPart * factor.realPart));
    }

    public static ComplexNumber pow(ComplexNumber value, double pow) {
        double magnitude = Math.pow(value.getAbsoluteValue(), pow);
        double phase = value.getAngle() * pow;
        return ComplexNumber.fromPolarCoordinates(magnitude, phase);
    }

    public ComplexNumber returnCoupling() {
        return new ComplexNumber(this.realPart, -this.imaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber divider) {
        double denominator = ((Math.pow(divider.getReal(), 2)) + (Math.pow(divider.getIm(), 2)));
        ComplexNumber numerator = this.multiply(divider.returnCoupling());

        return numerator.multiply(new ComplexNumber(Math.pow(denominator, -1), 0));
    }

    public static ComplexNumber exp(ComplexNumber complexNumber) {
        double magnitude = Math.pow(Math.E, complexNumber.getReal());
        return ComplexNumber.fromPolarCoordinates(magnitude, complexNumber.getIm());
    }

    @Override
    public String toString() {
        if (realPart == 0) {
            if (imaginaryPart != 0)
                return String.valueOf(imaginaryPart) + "i";
            else
                return "0";
        }
        if (imaginaryPart != 0) {
            if (imaginaryPart > 0) {
                return String.valueOf(realPart) + "+" + String.valueOf(imaginaryPart) + "i";
            } else
                return String.valueOf(realPart) + String.valueOf(imaginaryPart) + "i";
        } else
            return String.valueOf(realPart);

    }

    public static ComplexNumber ZERO() {
        return new ComplexNumber(0, 0);
    }

    public static ComplexNumber Random() {
        Random rand = new Random();
        double a = rand.nextDouble();
        return fromPolarCoordinates(a, (rand.nextInt(360) + 1) * Math.PI / 180);
    }

}
