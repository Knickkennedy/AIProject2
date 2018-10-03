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
    private Gender expectedGender;
    public double actualGender;
    public double desiredGender;

    public Human(double heightInInches, double weightInPounds, Gender gender, double firstWeight, double secondWeight, double bias) {
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
        this.gender = gender;
        if(gender == Gender.MALE){
            desiredGender = 1.0;
        }
        else{
            desiredGender = 0.0;
        }
        setExpectedGender(firstWeight, secondWeight, bias);
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

    public Gender getExpectedGender() { return expectedGender; }

    public void setExpectedGender(double firstWeight, double secondWeight, double bias){
       double y = firstWeight*heightInInches + secondWeight*weightInPounds + bias;
        if(y >= 0){
            expectedGender = Gender.MALE;
            actualGender = 1.0;
        }
        else{
            expectedGender = Gender.FEMALE;
            actualGender = 0.0;
        }
    }

    public boolean calculateGenderPredictionForAccuracy(){
        return expectedGender == gender;
    }

    @Override
    public String toString() {
        return String.format("%.2f,%.2f,%d Predicted Gender: %s\n", getHeightInInches(), getWeightInPounds(), getGender() == Gender.MALE ? 1 : 0, expectedGender);
    }
}
