package org.example;
public  class Main{
    public static void main(String[] args) {
        BresenhamLineChart chart = new BresenhamLineChart();
        chart.drawLine(0, 0, 10, 10);
        chart.showChart();
    }
}