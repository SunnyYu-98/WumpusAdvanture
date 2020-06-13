public class Wumpus
{
    private Room location;
    private boolean aliveStatus; //Indicates if the Wumpus is alive or not
    private int x; //x-axis
    private int y; //y-axis
    private int z; //z-axis
    public static final double DAMAGE = 20; //amount of damage will cause if a player is attacked
    public static final int DESTROY_WUMPUS_POINTS = 1000;

    public Wumpus()
    {
        location = null;
        x = 0;
        y = 0;
        z = 0;
        aliveStatus = true;
    }
    public Wumpus(Room location)
    {
        this.location = location;
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
        aliveStatus = true;
    }
    public void setLocation(Room location)
    {
        this.location = location;
    }

    //******Privacy Leak?*********
    public Room getLocation()
    {
        return location;
    }

    public void setAliveStatus(boolean aliveStatus)
    {
        this.aliveStatus = aliveStatus;
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

    public boolean getAliveStatus()
    {
        return aliveStatus;
    }
    public boolean checkIfWumpusIsHit(Room userLocation, String shootDirection) //Return true if wumpus is destroyed
    {
        if(!aliveStatus)
            return true; //Wumpus is dead already
        if(location==null)
            return false;

        int userX = userLocation.getX(); //user's x position
        int userY = userLocation.getY(); //user's y position
        int userZ = userLocation.getZ(); //user's y position




        if(shootDirection == null)
            return false;


        switch (shootDirection)
        {
            case "north":
                if(!(userX == x) || !(userZ == z))
                    return false;
                else
                {
                    if (y > userY)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }
                //If the Wumpus is on the north
                // side of the user, the Wumpus is hit

            case "south":
                if(!(userX == x) || !(userZ == z))
                    return false;
                else
                {
                    if (y < userY)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }
                //If the Wumpus is on the south
                // side of the user, the Wumpus is hit

            case "east":
                if(!(userY == y) || !(userZ == z))
                    return false;
                else
                {
                    if (x > userX)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }

            case "west":
                if(!(userY == y) || !(userZ == z))
                    return false;
                else
                {
                    if (x < userX)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }

            case "up":
                if(!(userX == x) || !(userY == y))
                    return false;
                else
                {
                    if(z > userZ)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }
            case "down":
                if(!(userX == x) || !(userY == y))
                    return false;
                else
                {
                    if(z < userZ)
                    {
                        setLocation(null);
                        setAliveStatus(false);
                        return true;
                    }
                    return false;
                }
        }

        if(aliveStatus)
            return false;
        else
        {
            setLocation(null);
            return true;
        }

    }

}
