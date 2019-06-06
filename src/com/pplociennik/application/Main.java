package com.pplociennik.application;

import com.pplociennik.complexNumbers.ComplexNumber;
import com.pplociennik.qubits.Qubit;
import com.pplociennik.vectors.Vector;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n&&---------------------LICZBY ZESPOLONE---------------------&&\n");

        ComplexNumber cn = new ComplexNumber(-2, 5);
        System.out.println("Kąt " + cn.getAngle());
        System.out.println("Moduł " + cn.getAbsoluteValue());
        System.out.println("Postać trygonometryczna: " + cn.returnTrigonometric());
        System.out.println("Sprzezenie: " + cn.returnCoupling());

        System.out.println("Sprzezenie: " + new ComplexNumber(3, 3).returnCoupling());
        System.out.println("Dodawanie: " + cn.add(new ComplexNumber(3, -4)));
        System.out.println("Mnozenie: " + cn.multiply(new ComplexNumber(2, -2)));

        ComplexNumber cn2 = new ComplexNumber(8, -6);
        System.out.println("Wynik dzielenia: " + cn2.divide(new ComplexNumber(4, 2)));

        System.out.println("EXP: " + ComplexNumber.exp(cn2));

        System.out.println("\n&&---------------------WEKTORY---------------------&&\n");

        Vector v = new Vector(new ComplexNumber[]{cn, cn2, new ComplexNumber(4, 5)});

        Vector v2 = new Vector(new ComplexNumber[]{new ComplexNumber(5, 7), new ComplexNumber(3, 6), new ComplexNumber(2, 2)});

        System.out.println("Suma wektorów: " + v.sum(v2));
        System.out.println("Mnożenie przez skalar: " + v.multiplyBySkalar(new ComplexNumber(1, 1)));
        System.out.println("Iloczyn skalarny: " + v.skalarMultiplying(v2));
        System.out.println("Norma wektora: " + v.normOfVector(v2));

        ComplexNumber zad1 = new ComplexNumber(1, 0);

        ComplexNumber pom = new ComplexNumber(0, (Math.PI/4 + 1));
        ComplexNumber e = ComplexNumber.exp(new ComplexNumber(0, Math.PI/4));
        Vector vec = new Vector(new ComplexNumber[]{zad1, e.add(new ComplexNumber(1, 0))});
//        ComplexNumber zad2 = ComplexNumber.exp(pom.add(new ComplexNumber(1, 0)));

//        Vector vector = new Vector(new ComplexNumber[]{zad1, zad2});
        System.out.println("Zadanie: " + vec.skalarMultiplying(vec));


        System.out.println("\n&&---------------------QUBITY---------------------&&\n");

        System.out.println(new Qubit());
        Qubit q = new Qubit(new ComplexNumber(0, 0), new ComplexNumber(1, 0));
        Qubit entry = new Qubit(new ComplexNumber(0, 0), new ComplexNumber(1, 0));
        Qubit entry2 = new Qubit(new ComplexNumber(1, 0), new ComplexNumber(0, 0));
        System.out.println(new Qubit());
        System.out.println(Qubit.PauliZ(q));
        System.out.println(Qubit.Measure(entry));
        System.out.println(Qubit.Measure(entry2));

        System.out.println("\n");

        for (int i = 0; i < 10; i++) {
            Qubit qTest = new Qubit();
            System.out.println(Qubit.Measure(qTest));
        }

        System.out.println("\n");

        Qubit doPomiarow = new Qubit();
        System.out.println(doPomiarow + "\n");
        for (int i = 0; i < 100; i++) {
            System.out.println(Qubit.Measure(doPomiarow));
            try {
                Thread.sleep(5);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

    }
}
