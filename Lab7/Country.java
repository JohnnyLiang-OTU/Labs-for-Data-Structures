public class Country
{
    String name;
    int population;

    Country(String name, int population)
    {
        this.name = name;
        this.population = population;
    }

    public String toString()
    {
        return String.format("%s: %,d", name, population);
    }
}