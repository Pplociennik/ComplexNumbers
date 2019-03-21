package com.pplociennik.vectors;

import com.pplociennik.complexNumbers.ComplexNumber;

public class Vector {

    private ComplexNumber[] coordinates;

    public Vector(ComplexNumber[] complexNumbers) {
        this.coordinates = complexNumbers;
    }

    public ComplexNumber getCoordinateAtIndex(int index) {
        return this.coordinates[index];
    }

    public void setCoordinateAtIndex(int index, ComplexNumber complexNumber) {
        this.coordinates[index] = complexNumber;
    }

    public ComplexNumber[] getCoordinates() {
        return this.coordinates;
    }

    public Vector sum(Vector component) {
        if (this.coordinates.length != component.getCoordinates().length)
            System.out.println("Wektory różnej długości! Nie można wykonać mnożenia przez skalar!");
        else {


            ComplexNumber[] tempList = new ComplexNumber[this.coordinates.length];

            for (int i = 0; i < tempList.length; i++) {
                tempList[i] = this.coordinates[i].add(component.getCoordinateAtIndex(i));
            }

            return new Vector(tempList);
        }
        return null;
    }

    public Vector multiplyBySkalar(ComplexNumber skalarValue) {
        if (this.coordinates.length == 0)
            System.out.println("Wektor jest pusty! Nie można pomnożyć przez skalar!");
        else {
            ComplexNumber[] tempList = new ComplexNumber[this.coordinates.length];
            for (int i = 0; i < tempList.length; i++) {
                tempList[i] = this.coordinates[i];

            }

            for (int i = 0; i < this.coordinates.length; i++) {
                tempList[i] = tempList[i].multiply(skalarValue);
            }

            return new Vector(tempList);
        }
        return null;
    }

    public ComplexNumber skalarMultiplying(Vector secondVector) {
        if (this.coordinates.length != secondVector.getCoordinates().length)
            System.out.println("Wektory różnej długości! Nie można wykonać iloczynu skalarnego!");
        else {
            ComplexNumber tempComplex = new ComplexNumber(0, 0);

            for (int i = 0; i < this.coordinates.length; i++) {
                tempComplex = tempComplex.add(this.coordinates[i].multiply(secondVector.getCoordinateAtIndex(i).returnCoupling()));
            }
            return tempComplex;
        }
        return null;
    }

    public static Vector Zero(int size) {
        ComplexNumber[] vector = new ComplexNumber[size];

        for (int i = 0; i < size; i++) {
            vector[i] = new ComplexNumber(0, 0);
        }

        return new Vector(vector);
    }

    public ComplexNumber normOfVector(Vector vector) {
        return ComplexNumber.pow(this.skalarMultiplying(vector), 0.5);
    }

    @Override
    public String toString() {
        String vector = " ";
        for (int i = 0; i < this.coordinates.length; i++) {
            vector = vector + this.coordinates[i] + ", ";
        }
        return vector;
    }
}


