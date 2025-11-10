public class WorldPopulationGrowth{
    public static void main(String[] args){
        double currentPopulation = 8211527008.0; 
        double growthRate = 0.84; 
        
        System.out.println("Year\tPopulation\tIncrease");
        System.out.println("----\t----------\t--------");
        
        double population = currentPopulation;
        int doublingYear = 0;
        
        for (int year = 1; year <= 75; year++) {
            double increase = population * (growthRate / 100);
            population += increase;
            
            System.out.printf("%d\t%.0f\t%.0f%n", year, population, increase);
            
            // Check if population has doubled
            if (doublingYear == 0 && population >= 2 * currentPopulation) {
                doublingYear = year;
            }
        }
        
        if (doublingYear != 0) {
            System.out.printf("%nPopulation will double in year %d%n", doublingYear);
        } else {
            System.out.println("%nPopulation will not double within 75 years");
        }
    }
}