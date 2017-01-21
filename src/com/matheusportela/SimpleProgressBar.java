package com.matheusportela;

public class SimpleProgressBar implements ProgressBar {
    private static final int DEFAULT_STEPS = 100;
    private static final ProgressPrinter DEFAULT_PROGRESS_PRINTER = new HashProgressPrinter();
    private static final int PERCENTAGE_STRING_LENGTH = 20;

    private int maxSteps;
    private ProgressPrinter progressPrinter = null;

    SimpleProgressBar() {
        this(DEFAULT_STEPS, DEFAULT_PROGRESS_PRINTER);
    }

    SimpleProgressBar(int maxSteps) {
        this(maxSteps, DEFAULT_PROGRESS_PRINTER);
    }

    SimpleProgressBar(int maxSteps, ProgressPrinter progressPinter) {
        setMaxSteps(maxSteps);
        setProgressPrinter(progressPinter);
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setProgressPrinter(ProgressPrinter progressPrinter) {
        this.progressPrinter = progressPrinter;
    }

    @Override
    public void update(int step) {
        System.out.print(generateStepString(step));
    }

    private String generateStepString(int step) {
        double percentage = calculateProgressPercentage(step);
        String percentageString = progressPrinter.printProgress(step, maxSteps, PERCENTAGE_STRING_LENGTH);
        return String.format("\r%.1f%% %s (%d/%d)", percentage, percentageString, step, maxSteps);
    }

    private double calculateProgressPercentage(int step) {
        return (100.0*step)/maxSteps;
    }
}
