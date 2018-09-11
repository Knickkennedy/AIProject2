import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Human> males = new ArrayList<Human>();
        ArrayList<Human> females = new ArrayList<Human>();

        Random random = new Random(); // We feed a seed so the TA can get the same results as I do

        for(int i = 0; i < 2000; i++){
            double maleHeight = random.nextGaussian()*8 + 68;
            double maleWeight = random.nextGaussian()*20 + 166;

            males.add(new Human(maleHeight, maleWeight, Human.Gender.MALE));

            double femaleHeight = random.nextGaussian()*6 + 64;
            double femaleWeight = random.nextGaussian()*10 + 140;

            females.add(new Human(femaleHeight, femaleWeight, Human.Gender.FEMALE));
        }

        ScatterPlot scatterPlot = new ScatterPlot("Example Chart", males, females);
        scatterPlot.setSize(1600, 800);
        scatterPlot.setLocationRelativeTo(null);
        scatterPlot.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scatterPlot.setVisible(true);

    }
}
