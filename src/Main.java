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
        double firstWeight = 0.05/0.4;
        double secondWeight = -1.0;
        double bias = 0.3;
        int stoppingPoint = 1000;
        double stoppingCriterion = 0.00010;

        double minHeight = 46.814;
        double maxHeight = 83.679;

        double minWeight = 97.829;
        double maxWeight = 218.003;

        ArrayList<Human> correct = new ArrayList<Human>();

        Random random = new Random(75); // You can feed a seed here

        for (int i = 0; i < 2000; i++) {

            double maleHeight = random.nextGaussian() * 4 + 68;                  // This sets a standard deviation of 6 inches and a mean height of 5'8 inches for the set of data for males
            maleHeight = 1/(maxHeight - minHeight) * (maleHeight - maxHeight) + 1;

	        double maleWeight;

            if (maleHeight > 68) {                                                 // Generally speaking taller people will weigh slightly more than shorter people as a general rule
	            maleWeight = random.nextGaussian() * 15 + 170;
	            maleWeight = 1/(maxWeight - minWeight) * (maleWeight - maxWeight) + 1;
            }
            else {
	            maleWeight = random.nextGaussian() * 15 + 160;
	            maleWeight = 1/(maxWeight - minWeight) * (maleWeight - maxWeight) + 1;
            }
            Human male = new Human(maleHeight, maleWeight, Human.Gender.MALE, firstWeight, secondWeight, bias);
            males.add(male);
            allHumans.add(male);
        }

        for (int j = 0; j < 2000; j++) {
            double femaleHeight = random.nextGaussian() * 5 + 65;                 // Standard deviation of 6 inches and average female height of 5'5
            femaleHeight = 1/(maxHeight - minHeight) * (femaleHeight - maxHeight) + 1;

	        double femaleWeight;

            if (femaleHeight > 65) {                                               // Generally speaking taller people will weigh slightly more than shorter people as a general rule
	            femaleWeight = random.nextGaussian() * 10 + 140;
				femaleWeight = 1/(maxWeight - minWeight) * (femaleWeight - maxWeight) + 1;
            }
            else {
	            femaleWeight = random.nextGaussian() * 10 + 130;
	            femaleWeight = 1/(maxWeight - minWeight) * (femaleWeight - maxWeight) + 1;
            }

            Human female = new Human(femaleHeight, femaleWeight, Human.Gender.FEMALE, firstWeight, secondWeight, bias);
            females.add(female);
            allHumans.add(female);

        }

        System.out.println(String.format("Initial Weights: %s %s %s", firstWeight, secondWeight, bias));

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 100; j++){
                Human human = allHumans.get(j);

				double net = human.net(firstWeight, secondWeight, bias);
				double output;

				if(net >= 1){
					output = 1.0;
				}
				else{
					output = 0.0;
				}

                double weightShift = learningConstant * (human.desiredGender - output);
                firstWeight += (weightShift * human.getHeightInInches());
                secondWeight += (weightShift * human.getWeightInPounds());
                bias += weightShift;
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
