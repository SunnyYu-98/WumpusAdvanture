import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame
{
    private final static int WIDTH = 500;
    private final static int HEIGHT = 550;

    public Gui()
    {
        super("Game of Zuul");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(Gui.WIDTH,Gui.HEIGHT);
        getContentPane().setBackground(Color.orange);
        // setLayout(new FlowLayout());
        setLayout(null);


        JLabel commands = new JLabel("Available Commands:");
        commands.setSize(250,70);
        commands.setLocation(115,10);
        add(commands);

        JLabel go = new JLabel("go");
        go.setSize(70,70);
        go.setLocation(115,40);
        add(go);

        JLabel quit = new JLabel("quit");
        quit.setSize(70,70);
        quit.setLocation(115,60);
        add(quit);

        JLabel help = new JLabel("help");
        help.setSize(70,70);
        help.setLocation(115,80);
        add(help);

        JLabel shoot = new JLabel("shoot");
        shoot.setSize(70,70);
        shoot.setLocation(115,100);
        add(shoot);

        JLabel grab = new JLabel("grab");
        grab.setSize(70,70);
        grab.setLocation(115,120);
        add(grab);

        JLabel items = new JLabel("items");
        items.setSize(70,70);
        items.setLocation(115,140);
        add(items);

        JLabel drop = new JLabel("drop");
        drop.setSize(70,70);
        drop.setLocation(115,160);
        add(drop);

        JLabel use = new JLabel("use");
        use.setSize(70,70);
        use.setLocation(115,180);
        add(use);

        JLabel directions = new JLabel("Available Directions:");
        directions.setSize(250,70);
        directions.setLocation(115,230);
        add(directions);

        JLabel north = new JLabel("north");
        north.setSize(70,70);
        north.setLocation(115,260);
        add(north);

        JLabel south = new JLabel("south");
        south.setSize(70,70);
        south.setLocation(115,280);
        add(south);

        JLabel west = new JLabel("west");
        west.setSize(70,70);
        west.setLocation(115,300);
        add(west);

        JLabel east = new JLabel("east");
        east.setSize(70,70);
        east.setLocation(115,320);
        add(east);

    }
}
