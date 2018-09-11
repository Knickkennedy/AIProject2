public class Human {
    enum Gender{
        MALE, FEMALE;

        @Override
        public String toString(){
            return this.name().toLowerCase();
        }
    }

    private int heightInInches;
    private int weightInPounds;
    private Gender gender;

    public Human(int heightInInches, int weightInPounds, Gender gender) {
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.gender = gender;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" + "\n" +
                "heightInInches = " + heightInInches + ",\n" +
                "weightInPounds = " + weightInPounds + ",\n" +
                "gender = " + gender + "\n" +
                "}" + "\n";
    }
}
