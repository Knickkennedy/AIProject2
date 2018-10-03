import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.ArrayList;

public class ScatterPlot extends JFrame {

    public ScatterPlot(String title, ArrayList<Human> males, ArrayList<Human> females){
        super(title);

        XYDataset dataset = createDataSet(males, females);
        JFreeChart chart = ChartFactory.createScatterPlot("Comparing Height and Weight Across Gender", "Height in Inches", "Weight in Pounds", dataset);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataSet(ArrayList<Human> males, ArrayList<Human> females){
        XYSeriesCollection collection = new XYSeriesCollection();
        XYSeries maleSeries = new XYSeries("Men");

        for(Human male : males){
            maleSeries.add(male.getHeightInInches(), male.getWeightInPounds());
        }

        collection.addSeries(maleSeries);

        XYSeries femaleSeries = new XYSeries("Women");

        for(Human female : females){
            femaleSeries.add(female.getHeightInInches(), female.getWeightInPounds());
        }

        collection.addSeries(femaleSeries);
        return collection;
    }
}
