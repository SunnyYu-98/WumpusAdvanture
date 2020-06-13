public class Gold extends Item
{
    private int x;
    private int y;
    private int z;

    public Gold(Room location, String name, String description, double weight)
    {
        super(location, name, description, weight);
        x = location.getX();
        y = location.getY();
        z = location.getZ();
    }
    public Gold(int x, int y, int z, String name, String description, double weight)
    {
        super(name, description, weight);
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
}
