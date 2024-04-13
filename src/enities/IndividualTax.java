package enities;

public class IndividualTax extends TaxPayer {

    private Double healthExpenditures;

    public IndividualTax(String name, double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double healthExpendituresDescount = healthExpenditures * 0.50;
        double tax;
        double totalTax;
        if (getAnualIncome() > 20000){
            totalTax = getAnualIncome() * 0.25;
        }else{
            totalTax = getAnualIncome() * 0.15;
        }
        tax = totalTax - healthExpendituresDescount;
        return tax;
    }
}
