package com.matheusportela;

public class RotatingProgressPrinter implements ProgressPrinter {
    @Override
    public String printProgress(int step, int maxSteps, int length) {
        String result = "";
        int printState = (100*step/maxSteps) % 4;

        switch (printState) {
            case 0:
                result = "|";
                break;
            case 1:
                result = "/";
                break;
            case 2:
                result = "-";
                break;
            case 3:
                result = "\\";
                break;
        }

        return result;
    }
}
