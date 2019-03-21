package com.pplociennik.qubits;

import com.pplociennik.complexNumbers.ComplexNumber;
import com.pplociennik.vectors.Vector;

public class Qubit {

    private Vector vector;

    public ComplexNumber alpha;
    public ComplexNumber beta;

    public Qubit(ComplexNumber alpha, ComplexNumber beta) {
        try {
            setQubit(alpha, beta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Qubit() {
        ComplexNumber alpha = ComplexNumber.Random();
        ComplexNumber beta = ComplexNumber.fromPolarCoordinates(Math.sqrt(1 - Math.pow(alpha.getAbsoluteValue(), 2)), ComplexNumber.Random().getAngle());
        try {
            setQubit(alpha, beta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setQubit(ComplexNumber alpha, ComplexNumber beta) throws Exception {
        double d = Math.abs(1 - (Math.pow(alpha.getAbsoluteValue(), 2) + Math.pow(beta.getAbsoluteValue(), 2)));
        if (Math.abs(1 - (Math.pow(alpha.getAbsoluteValue(), 2) + Math.pow(beta.getAbsoluteValue(), 2))) > 0.00000001)
            throw new Exception("Given alpha and beta are not valid.");
        this.alpha = alpha;
        this.beta = beta;
    }

    public static Qubit PauliX(Qubit qubit) {
        return new Qubit(qubit.beta, qubit.alpha);
    }

    public static Qubit PauliY(Qubit qubit) {
        return new Qubit(qubit.beta.multiply(new ComplexNumber(0, -1)), qubit.alpha.multiply(new ComplexNumber(0, 1)));
    }

    public static Qubit PauliZ(Qubit qubit) {
        return new Qubit(qubit.alpha, qubit.beta.multiply(new ComplexNumber(-1, 0)));
    }

    public static Qubit T(Qubit qubit) {
        return new Qubit(qubit.alpha, (qubit.beta.multiply(new ComplexNumber(1, 1))).divide(new ComplexNumber(Math.sqrt(2), 0)));
    }

    public static Qubit Tt(Qubit qubit) {
        return new Qubit(qubit.alpha, (qubit.beta.multiply(new ComplexNumber(1, -1))).divide(new ComplexNumber(Math.sqrt(2), 0)));
    }

    public static Qubit S(Qubit qubit) {
        return new Qubit(qubit.alpha, qubit.beta.multiply(new ComplexNumber(0, 1)));
    }

    public static Qubit St(Qubit qubit) {
        return new Qubit(qubit.alpha, qubit.beta.multiply(new ComplexNumber(0, -1)));
    }

    public static Qubit Hadamard(Qubit qubit) {
        return new Qubit((qubit.alpha.add(qubit.beta)).divide(new ComplexNumber(Math.sqrt(2), 0)), (qubit.alpha.subtract(qubit.beta)).divide(new ComplexNumber(Math.sqrt(2), 0)));
    }

    @Override
    public String toString() {
        return "<" + alpha + "|" + beta + ">";
    }
}
