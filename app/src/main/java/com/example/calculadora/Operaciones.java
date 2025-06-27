package com.example.calculadora;

    public class Operaciones {
        public static double suma(double a, double b) {
            return a + b;
        }

        public static double resta(double a, double b) {
            return a - b;
        }

        public static double division(double a, double b) {
            return b != 0 ? a / b : 0;
        }

        public static double multiplicacion(double a, double b) {
            return a * b;
        }
    }


