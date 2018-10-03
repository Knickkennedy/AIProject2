import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Human> allHumans = new ArrayList<Human>();
        ArrayList<Human> males = new ArrayList<Human>();
        ArrayList<Human> females = new ArrayList<Human>();
        double learningConstant = 0.3;
        double firstWeight = 5.0/3.0;
        double secondWeight = -1.0;
        double bias = 38.33;
        int stoppingPoint = 1000;
        double stoppingCriterion = 0.00010;
        ArrayList<Human> correct = new ArrayList<Human>();

        Random random = new Random(75); // You can feed a seed here

        for (int i = 0; i < 2000; i++) {

            double maleHeight = random.nextGaussian() * 4 + 68;                   // This sets a standard deviation of 6 inches and a mean height of 5'8 inches for the set of data for males
            double maleWeight;

            if (maleHeight > 68)                                                 // Generally speaking taller people will weigh slightly more than shorter people as a general rule
                maleWeight = random.nextGaussian() * 15 + 170;
            else
                maleWeight = random.nextGaussian() * 15 + 160;

            Human male = new Human(maleHeight, maleWeight, Human.Gender.MALE, firstWeight, secondWeight, bias);
            males.add(male);
            allHumans.add(male);
        }

        for (int j = 0; j < 2000; j++) {
            double femaleHeight = random.nextGaussian() * 5 + 65;                 // Standard deviation of 6 inches and average female height of 5'5
            double femaleWeight;

            if (femaleHeight > 65)                                               // Generally speaking taller people will weigh slightly more than shorter people as a general rule
                femaleWeight = random.nextGaussian() * 10 + 140;
            else
                femaleWeight = random.nextGaussian() * 10 + 130;

            Human female = new Human(femaleHeight, femaleWeight, Human.Gender.FEMALE, firstWeight, secondWeight, bias);
            females.add(female);
            allHumans.add(female);

        }

        System.out.println(String.format("Initial Weights: %s %s %s", firstWeight, secondWeight, bias));

        for(int i = 0; i < stoppingPoint; i++){
            for(int j = 0; j < 3000; j++){
                Human human = allHumans.get(j);

                human.setExpectedGender(firstWeight, secondWeight, bias);

                System.out.printf("Expected Gender: %s, Actual Gender: %s\n", human.getExpectedGender(), human.getGender());
                if(human.getExpectedGender() != human.getGender()) {
                    double weightShift = learningConstant * (human.desiredGender - human.actualGender);
                    firstWeight += (weightShift * human.getHeightInInches());
                    secondWeight += (weightShift * human.getWeightInPounds());
                    bias += weightShift;
                }
            }
        }

        System.out.println(String.format("Final Weights: %.2f %.2f %.2f", firstWeight, secondWeight, bias));

        ScatterPlot scatterPlot = new ScatterPlot("Example Chart", males, females);
        scatterPlot.setSize(1600, 800);
        scatterPlot.setLocationRelativeTo(null);
        scatterPlot.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scatterPlot.setVisible(true);
    }
}
