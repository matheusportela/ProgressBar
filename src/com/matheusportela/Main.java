package com.matheusportela;

public class Main {

    public static void main(String[] args) {
        SimpleProgressBar progressBar = new SimpleProgressBar(100, new ArrowProgressPrinter());

        for (int i = 0; i <= progressBar.getMaxSteps(); i++) {
            try {
                progressBar.update(i);
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }
    }
}
