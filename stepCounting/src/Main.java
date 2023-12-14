import Plot.PlotWindow;
import Plot.ScatterPlot;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String data = readFile("data/4-100-step-running.csv");
        String[] lines = data.split("\n");
        ArrayList<Double> accx  = getColumnAsList(lines, 0);
        ArrayList<Double> accy  = getColumnAsList(lines, 1);
        ArrayList<Double> accz  = getColumnAsList(lines, 2);
        ArrayList<Double> gyrox  = getColumnAsList(lines, 3);
        ArrayList<Double> gyroy  = getColumnAsList(lines, 4);
        ArrayList<Double> gyroz  = getColumnAsList(lines, 5);
        ArrayList<Double> accmags = getMagnitudes(accx, accy, accz);
        ArrayList<Double> gyromags = getMagnitudes(gyrox, gyroy, gyroz);
        ArrayList<Integer> peakIndexes = getPeakIndexes(accmags);
        ArrayList<Double> peakValues = getValuesAt(peakIndexes, accmags);

        ScatterPlot plt = new ScatterPlot(100, 100, 1100, 700);
        for (int i = 0; i < accmags.size(); i++) {
            double index = i;
            double value = accmags.get(i);
            plt.plot(0, index, value).strokeColor("red").strokeWeight(2).style("-");
        }

        // Plot the peaks as data set 1
        for (int i = 0; i < peakIndexes.size(); i++) {
            double index = peakIndexes.get(i);
            double value = peakValues.get(i);
            plt.plot(1, index, value).strokeColor("blue").strokeWeight(5).style(".");
        }

        PlotWindow window = PlotWindow.getWindowFor(plt, 1200,800);
        window.show();



        // Create ScatterPlot with display upper left (100, 100) to lower right (1100, 700)
/*
        ScatterPlot plt = new ScatterPlot(100, 100, 1100, 700);

        for (int i = 0; i < 1000; i++) {
            double x = i;           // x-value is index of the value
            double y = accmags.get(i);    // y-value is the value itself
            plt.plot(0, x, y).strokeColor("red").strokeWeight(2).style("-");
        }

        PlotWindow window = PlotWindow.getWindowFor(plt, 1200,800);
        window.show();


 */
    }



    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static ArrayList<Double> getColumnAsList(String[] lines, int columnnumber){
        ArrayList<Double> columlist = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            String[] linesnew = (lines[i].split(","));
            double val = Double.parseDouble((linesnew[columnnumber]).trim());
            columlist.add(val);
        }
        return columlist;
    }

    public static ArrayList<Double> getMagnitudes(ArrayList<Double>x, ArrayList<Double>y, ArrayList<Double>z){
        ArrayList<Double> mags = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            double val = magnitude(x.get(i), y.get(i), z.get(i));
            mags.add(val);
        }return mags;
    }
    public static double magnitude(double x, double y, double z){
        return Math.sqrt(((x*x) + (y*y) + (z*z)));
    }

    public static ArrayList<Double> peaks(ArrayList<Double> mags){
        ArrayList<Double> peaks = new ArrayList<>();
        for (int i = 1; i < mags.size()-1; i++) {
            if(mags.get(i)>mags.get(i-1)&&mags.get(i)>mags.get(i+1)){
                peaks.add(mags.get(i));
            }
        } return peaks;
    }

    public static ArrayList<Integer> getPeakIndexes(ArrayList<Double> data){
        ArrayList<Integer> peakLocations = new ArrayList<>();
        for (int i = 1; i < data.size()-1; i++) {
            if(data.get(i)>data.get(i-1)&&data.get(i)>data.get(i+1)){
                peakLocations.add(i);
            }
        } return peakLocations;
    }

    public static ArrayList<Double> getValuesAt(ArrayList<Integer> peakLocations, ArrayList<Double> data){
        ArrayList<Double> yValues= new ArrayList<>();
        for (int i = 0; i < peakLocations.size(); i++) {
            double val = data.get(peakLocations.get(i));
            yValues.add(val);
        }return yValues;

    }


}
