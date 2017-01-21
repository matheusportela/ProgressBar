package com.matheusportela;

public class HashProgressPrinter implements ProgressPrinter {
    @Override
    public String printProgress(int step, int maxSteps, int length) {
        StringBuilder textPercentage = new StringBuilder();

        int progressedTens = length*step/maxSteps;
        int leftTens = length - progressedTens;

        textPercentage.append('[');

        for (int i = 0; i < progressedTens; i++)
            textPercentage.append('#');

        for (int i = 0; i < leftTens; i++)
            textPercentage.append(' ');

        textPercentage.append(']');

        return textPercentage.toString();
    }
}
