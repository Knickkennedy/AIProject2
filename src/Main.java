import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Human> males = new ArrayList<Human>();
        ArrayList<Human> females = new ArrayList<Human>();

        Random random = new Random(1); // We feed a seed so the TA can get the same results as I do

        for(int i = 0; i < 20; i++){
            int maleHeight = (int)Math.round(random.nextGaussian()*8 + 68);
            int maleWeight = (int)Math.round(random.nextGaussian()*20 + 166);

            males.add(new Human(maleHeight, maleWeight, Human.Gender.MALE));
        }

        System.out.print(males);
    }
}
