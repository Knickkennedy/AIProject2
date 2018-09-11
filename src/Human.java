public class Human {
    enum Gender{
        MALE, FEMALE;

        @Override
        public String toString(){
            return this.name().toLowerCase();
        }
    }

    private double heightInInches;
    private double weightInPounds;
    private Gender gender;

    public Human(double heightInInches, double weightInPounds, Gender gender) {
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.gender = gender;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
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
