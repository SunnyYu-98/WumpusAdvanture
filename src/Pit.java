public class Pit
{
    private Room location;
    private int x;
    private int y;
    private int z;


    /*
    public Pit()
    {

    }
    */
    public Pit(Room location)
    {
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }
    public Pit(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;

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
    /*
    public void setLocation(Room location)
    {
        this.location = location;
    }

    //******Privacy Leak?*********
    public Room getLocation()  //*
    {                          //*
        return location;       //*
    }                          //*
    //******Privacy Leak?*********
    */
}
