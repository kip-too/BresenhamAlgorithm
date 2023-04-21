package org.example;

import org.knowm.xchart.*;

public class BresenhamLineChart {
    private CategoryChart chart;

    public BresenhamLineChart() {
        chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Bresenham Line Chart")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();
    }

    public void drawLine(int x0, int y0, int x1, int y1) {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (x0 != x1 || y0 != y1) {
            chart.addSeries("Line", new double[]{x0}, new double[]{y0});

            int e2 = err * 2;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
        chart.addSeries("Line", new double[]{x1}, new double[]{y1});
    }

    public void showChart() {
        new SwingWrapper<>(chart).displayChart();
    }


}
