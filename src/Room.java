import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;

public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private int x; //location on the x-axis
    private int y; //location on the y-axis
    private int z; //location on the z-axis
    public final static Item [] ITEMS = new Item[]
            {new Item("Cookie", ("a cookie that can add your health by "+ Item.COOKIE_HEALTH_ADD),1),
                    new Item("Steak",("steak that can add your health by " +Item.STEAK_HEALTH_ADD),5),
                    new Item("Hamburger",("hamburger that can add your health by "+Item.HAMBURGER_HEALTH_ADD),3.5),
                    new Item("Super Drink",("super drink that can add your health by "+Item.SUPER_DRINK_HEALTH_ADD),0.5),
                    new Item("Ammo",("an ammo that you can use to shoot the Wumpus"),0.1),null, null, null, null};
    //Potential items that a room can have
    //four elements are null so some rooms doesnt have items

    private ArrayList<Item> items;

    public Room(String description, int x, int y, int z)
    {
        this.setDescription(description);
        this.x = x;
        this.y = y;
        this.z = z;
        exits = new HashMap<>();

        Random random = new Random();

        int randomNum = random.nextInt(ITEMS.length);
        boolean hasSecondItemOrNot = random.nextBoolean();//randomly generated boolean value that
        //determines if the room has a second item or not

        items = new ArrayList<>();
        items.add(ITEMS[randomNum]);

        if(hasSecondItemOrNot)
        {
            randomNum = random.nextInt(ITEMS.length-5)+5;
            items.add(ITEMS[randomNum]);
        }
        else
        {
            items.add(null);
        }
        items.add(Item.GOLD_INDEX,null);
    }
    public Room(Room obj) //copy constructor
    {
        this.description = obj.description;
        this.exits = obj.exits;
        this.x = obj.x;
        this.y = obj.y;
        this.z = obj.z;
        this.items = obj.items;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setExits(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }
    public String getShortDescription()
    {
        return description;
    }
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    private String getExitString()
    {
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys)
        {
            returnString += " " + exit;
        }
        return returnString;
    }


    public ArrayList<Item> getItemsInRoom()
    {
        return items;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }
    public HashMap<String, Room> getExitsHashMap()
    {
        return exits;
    }
    public Room getExit(String direction)
    {
        Room copy;
        copy = exits.get(direction);

        return copy;
    }
    @Override
    public String toString()
    {
        return  getLongDescription() +
                getExitString();
        //x,y,z
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }

}
