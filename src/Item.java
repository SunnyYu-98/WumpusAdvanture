public class Item
{
    private String name;
    private String description;
    private double weight; //weight of the item (lb)

    public final static int GOLD_INDEX = 2;

    public final static double OBTAINED_FOOD_SCORE = 150.0;
    public final static double OBTAINED_AMMO_SCORE = 80.0;
    public final static double OBTAINED_GOLD_SCORE = 2500.0;

    public final static double COOKIE_HEALTH_ADD = 10.0; //amount of health added if these food is eaten
    public final static double STEAK_HEALTH_ADD = 35.0;
    public final static double HAMBURGER_HEALTH_ADD = 25.0;
    public final static double SUPER_DRINK_HEALTH_ADD = 90.0;

    public Item()
    {
        name = null;
        description = null;
        weight = 0.0;
    }

    public Item(Room location, String name, String description, double weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    public Item(String name, String description, double weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Name: " + name +
                "\nDescription: " + description +
                "\nWeight: " + weight;
    }
}
