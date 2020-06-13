import java.util.ArrayList;

public class Player
{
    public static final double MAX_HEALTH = 100;
    public static final double MAX_INVENTORY_WEIGHT = 15; //Max weight the player can carry
    private int ammoCount; //amount of ammo the player has
    private double health; //the player's health
    private double score;
    private ArrayList<Item> inventory;
    private double inventoryWeight;

    public Player()
    {
        ammoCount = 0;
        score = 0;
        health = MAX_HEALTH;
        inventory = new ArrayList<>();
        inventoryWeight = 0.0;
    }
    public Player(int ammoCount)
    {
        this.ammoCount = ammoCount;
        score = 0;
        health = MAX_HEALTH;
        inventory = new ArrayList<>();
        inventoryWeight = 0.0;
    }
    public void setAmmoCount(int ammoCount)
    {
        this.ammoCount = ammoCount;
    }
    public void setHealth(double health)
    {
        this.health = health;
    }
    public static double getMaxHealth()
    {
        return MAX_HEALTH;
    }
    public int getAmmoCount()
    {
        return ammoCount;
    }
    public double getHealth()
    {
        return health;
    }
    public double getScore()
    {
        return score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public void addItemToInventory(Item newItem)
    {
        this.inventory.add(0,newItem);
    }

    public void removeItemFromInventory(Item item)
    {
        this.inventory.remove(item);
    }


    public void setInventoryWeight(double inventoryWeight)
    {
        this.inventoryWeight = inventoryWeight;
    }

    public double getInventoryWeight()
    {
        double total = 0.0;
        for(Item i : inventory)
            total += i.getWeight();
        return total;
    }

    @Override
    public String toString()
    {
        return "Ammo Count: " + ammoCount +
                "Health: " + health + "\n"+
                "Score: " + score;
    }
}
