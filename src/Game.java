import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Game
{
    private Parser parser;
    private Room currentRoom;

    private ArrayList<Wumpus> wumpuses;
    private Pit [] pits;

    private Player player;
    private HashMap<Character, Integer> startingPoint; //the starting room of the game (x,y,z)

    public Game()
    {
        createRooms();
        parser = new Parser();
        Gui gui = new Gui();
        gui.setVisible(true);
    }

    private void createRooms()
    {
        String east = "east";
        String west = "west";
        String north = "north";
        String south = "south";
        String up = "up";
        String down = "down";

        Room lobby, treatyRoom, eventRoom, cabinetRoom, entranceRoom      //5
                , operationCenter, bunker, safeRoom, ovalOffice,          //4
                artRoom, queensRoom, showRoom, lincolnSittingRoom,        //4
                diplomaticRecepRoom, presidentsBedRoom, studyRoom,        //3
                conferenceRoom, situationRoom, mapRoom, library,          //4
                famDiningRoom, securityRoom, securityRoom2, serverRoom,   //4
                monitorRoom, guestBunker, guestDiningRoom, bowlingRoom,   //4
                servantRoom, kitchen, infoTechRoom, adminRoom;            //4
        //----------------------------------------------------------- = 32 in total

        //Create Room Objects and Set Descriptions-----------------------------------------------------
        //if z=0, it's on the first floor. if z=-1, it's in the basement.
        //-------------------First Floor--------------------
        //rooms at y = 1, z = 0
        securityRoom = new Room("in Security Room",1,1,0);
        showRoom = new Room("in the Show Room",2,1,0);
        entranceRoom = new Room("at main entrance of the White House",3,1,0);
        securityRoom2 = new Room("in Security Room #2",4,1,0);

        //rooms at y = 2, z = 0
        monitorRoom = new Room("in the Monitor Room",1,2,0);
        eventRoom = new Room("in the Event Room",2,2,0);
        lobby = new Room("in the Lobby",3,2,0);
        treatyRoom = new Room("in the Treaty Room",4,2,0);

        //rooms at y = 3, z = 0
        servantRoom = new Room("in the Servant Room",1,3,0);
        conferenceRoom = new Room("in the Conference Room",2,3,0);
        cabinetRoom = new Room("in the Cabinet Room",3,3,0);
        artRoom = new Room("in the Art Room",4,3,0);

        //rooms at y = 4, z = 0
        kitchen = new Room("in the Kitchen",1,4,0);
        infoTechRoom = new Room("in the Information Technology Office",2,4,0);
        diplomaticRecepRoom = new Room("in the Diplomatic Reception Room",3,4,0);
        mapRoom = new Room("in the Map Room",4,4,0);

        //---------------------Basement-----------------------
        //rooms at y = 1, z = -1
        studyRoom = new Room("in the Study Room",1,1,-1);
        guestDiningRoom = new Room("in the Guest Dining Room",2,1,-1);
        lincolnSittingRoom = new Room("in the Lincoln Sitting Room",3,1,-1);
        queensRoom = new Room("in the Queen's Room",4,1,-1);

        //rooms at y = 2, z = -1
        adminRoom = new Room("in the Administrative Office",1,2,-1);
        guestBunker = new Room("in the Guest Bunker",2,2,-1);
        situationRoom = new Room("in the Situation Room",3,2,-1);
        presidentsBedRoom = new Room("in the President's Bed Room",4,2,-1);

        //rooms at y = 3, z = -1
        safeRoom = new Room("in the Safe Room",1,3,-1);
        library = new Room("in the Library",2,3,-1);
        operationCenter = new Room("in the Emergency Operation Center",3,3,-1);
        ovalOffice = new Room("in the Oval Office",4,3,-1);

        //rooms at y = 4, z = -1
        bowlingRoom = new Room("in the Bowling Alley",1,4,-1);
        famDiningRoom = new Room("in the Family Dining Room",2,4,-1);
        bunker = new Room("in the nuclear-protected, indestructible Bunker",3,4,-1);
        serverRoom = new Room("in the Server Room",4,4,-1);
        //-----------------------------------------------------------------------------------------------


        //Set exits--------------------------------------------------------------------------------------
        //=====================Ground Floor=====================
        lobby.setExits(south, entranceRoom);
        lobby.setExits(north, cabinetRoom);
        lobby.setExits(west, eventRoom);
        lobby.setExits(east, treatyRoom);

        treatyRoom.setExits(south, securityRoom2);
        treatyRoom.setExits(west, lobby);
        treatyRoom.setExits(north, artRoom);

        securityRoom2.setExits(north, treatyRoom);
        securityRoom2.setExits(west, entranceRoom);

        entranceRoom.setExits(east, securityRoom2);
        entranceRoom.setExits(north, lobby);
        entranceRoom.setExits(west, showRoom);

        showRoom.setExits(north, eventRoom);
        showRoom.setExits(east, entranceRoom);
        showRoom.setExits(west, securityRoom);
        showRoom.setExits(down, guestDiningRoom);

        securityRoom.setExits(east, showRoom);
        securityRoom.setExits(north, monitorRoom);

        monitorRoom.setExits(down, adminRoom);
        monitorRoom.setExits(south, securityRoom);
        monitorRoom.setExits(north, servantRoom);
        monitorRoom.setExits(east, eventRoom);

        eventRoom.setExits(down, guestBunker);
        eventRoom.setExits(south, showRoom);
        eventRoom.setExits(north, conferenceRoom);
        eventRoom.setExits(west, monitorRoom);
        eventRoom.setExits(east, lobby);

        servantRoom.setExits(south, monitorRoom);
        servantRoom.setExits(north, kitchen);
        servantRoom.setExits(east, conferenceRoom);

        conferenceRoom.setExits(south, eventRoom);
        conferenceRoom.setExits(north, infoTechRoom);
        conferenceRoom.setExits(west, servantRoom);
        conferenceRoom.setExits(east, cabinetRoom);

        cabinetRoom.setExits(south, lobby);
        cabinetRoom.setExits(north, diplomaticRecepRoom);
        cabinetRoom.setExits(west, conferenceRoom);
        cabinetRoom.setExits(east, artRoom);

        artRoom.setExits(south, treatyRoom);
        artRoom.setExits(north, mapRoom);
        artRoom.setExits(west, cabinetRoom);

        kitchen.setExits(south, servantRoom);
        kitchen.setExits(east, infoTechRoom);

        infoTechRoom.setExits(west, kitchen);
        infoTechRoom.setExits(south, conferenceRoom);
        infoTechRoom.setExits(east, diplomaticRecepRoom);

        diplomaticRecepRoom.setExits(down, bunker);
        diplomaticRecepRoom.setExits(west, infoTechRoom);
        diplomaticRecepRoom.setExits(south, cabinetRoom);
        diplomaticRecepRoom.setExits(east, mapRoom);

        mapRoom.setExits(south, artRoom);
        mapRoom.setExits(west, diplomaticRecepRoom);
        //=====================Ground Floor DONE=====================

        //=====================Basement=====================
        studyRoom.setExits(north, adminRoom);
        studyRoom.setExits(east, guestDiningRoom);

        guestDiningRoom.setExits(west, studyRoom);
        guestDiningRoom.setExits(east, lincolnSittingRoom);
        guestDiningRoom.setExits(north, guestBunker);
        guestDiningRoom.setExits(up, showRoom);

        lincolnSittingRoom.setExits(north, situationRoom);
        lincolnSittingRoom.setExits(west, guestDiningRoom);
        lincolnSittingRoom.setExits(east, queensRoom);

        queensRoom.setExits(north, presidentsBedRoom);
        queensRoom.setExits(west, lincolnSittingRoom);

        adminRoom.setExits(south, studyRoom);
        adminRoom.setExits(north, safeRoom);
        adminRoom.setExits(east, guestBunker);
        adminRoom.setExits(up, monitorRoom);

        guestBunker.setExits(north, library);
        guestBunker.setExits(south, guestDiningRoom);
        guestBunker.setExits(west, adminRoom);
        guestBunker.setExits(east, situationRoom);
        guestBunker.setExits(up, eventRoom);

        situationRoom.setExits(south, lincolnSittingRoom);
        situationRoom.setExits(north, operationCenter);
        situationRoom.setExits(west, guestBunker);
        situationRoom.setExits(east, presidentsBedRoom);

        presidentsBedRoom.setExits(south, queensRoom);
        presidentsBedRoom.setExits(north, ovalOffice);
        presidentsBedRoom.setExits(west, situationRoom);

        ovalOffice.setExits(south, presidentsBedRoom);
        ovalOffice.setExits(north, serverRoom);
        ovalOffice.setExits(west, operationCenter);

        operationCenter.setExits(south, situationRoom);
        operationCenter.setExits(north, bunker);
        operationCenter.setExits(west, library);
        operationCenter.setExits(east,ovalOffice);

        library.setExits(south,guestBunker);
        library.setExits(north,famDiningRoom);
        library.setExits(west,safeRoom);
        library.setExits(east,operationCenter);

        safeRoom.setExits(north,bowlingRoom);
        safeRoom.setExits(south,adminRoom);
        safeRoom.setExits(east,library);

        bowlingRoom.setExits(south,safeRoom);
        bowlingRoom.setExits(east,famDiningRoom);

        famDiningRoom.setExits(south,library);
        famDiningRoom.setExits(west,bowlingRoom);
        famDiningRoom.setExits(east,bunker);

        bunker.setExits(south,operationCenter);
        bunker.setExits(east,serverRoom);
        bunker.setExits(west,famDiningRoom);
        bunker.setExits(up,diplomaticRecepRoom);

        serverRoom.setExits(south,ovalOffice);
        serverRoom.setExits(west,bunker);
        //==================Basement DONE==================
        //DONE setting exits-----------------------------------------------------------------------------

        currentRoom = entranceRoom; //start game in the Entrance Room
        startingPoint = new HashMap<>();
        startingPoint.put('x',currentRoom.getX());
        startingPoint.put('y',currentRoom.getY());
        startingPoint.put('z',currentRoom.getZ());

        wumpuses = new ArrayList<>();
        wumpuses.add(new Wumpus(bowlingRoom));
        wumpuses.add(new Wumpus(conferenceRoom));

        pits = new Pit[] {new Pit(ovalOffice), new Pit(guestBunker), new Pit(studyRoom),
                new Pit(kitchen), new Pit(artRoom), new Pit(securityRoom2)};

        player = new Player(5);
        operationCenter.getItemsInRoom().add(Item.GOLD_INDEX,new Item("Gold","gold you have been looking for!",7));
    }

    public void play()
    {
        printWelcome();

        boolean finished = false;
        while (!finished)
        {
            UserCommand command = parser.getUserCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye.");
        System.exit(0);
    }

    private void printWelcome()
    {
        System.out.println("\nWelcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.\n");
        System.out.println(currentRoom.getLongDescription());
    }
    private boolean processCommand(UserCommand userInput)
    {
        boolean wantToQuit = false;

        if(userInput.isUnknown())
        {
            System.out.println("i don't know what you mean...");
            return false;
        }

        String userCommandWord = (userInput.getCommandWord()).toLowerCase();
        switch (userCommandWord)
        {
            case "help":
                printHelp();
                break;
            case "go":
                wantToQuit = goRoom(userInput);
                break;
            case "shoot":
                shoot(userInput);
                break;
            case "grab":
                grab(userInput);
                break;
            case "items":
                items();
                break;
            case "drop":
                drop();
                break;
            case "use":
                use();
                break;
            case "quit":
                wantToQuit = quit(userInput);
                break;
        }
        return wantToQuit;
    }

    private void printHelp()
    {
        System.out.println("You are lost and lonely. You wander");
        System.out.println("around at the White House");
        System.out.println("\nYour command words are: ");
        parser.showCommands();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean goRoom(UserCommand userInput)
    {
        int currentX;
        int currentY;
        int currentZ;
        boolean breeze = false; //indicates if there is a breeze
        boolean smellBad = false; //indicates if something smells bad

        if(!userInput.hasDirection())
        {
            //if there is no second word, we don't know where to go...
            System.out.println("Go Where? ");
            currentRoom.getLongDescription();
            return false;
        }
        String direction = userInput.getDirection();

        //Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if(nextRoom==null)
        {
            System.out.println("There is no door!");
            return false;
        }
        else
        {
            currentRoom = nextRoom;
            currentX = currentRoom.getX();
            currentY = currentRoom.getY();
            currentZ = currentRoom.getZ();

            if(currentX == startingPoint.get('x') &&
                    currentY == startingPoint.get('y') &&
                    currentZ == startingPoint.get('z'))
            {
                System.out.println("Congratulations! You have beat the game!");
                System.out.println("You finished the game with the score of " + player.getScore());
                return true;
            }

            int big; //for the for loop
            if(pits.length > wumpuses.size())
                big = pits.length;
            else
                big = wumpuses.size();

            for(int i = 0; i < big; i++)
            {
                try
                {
                    if (currentZ == pits[i].getZ())
                    {
                        if ((currentX == pits[i].getX()) && (currentY == pits[i].getY()))
                        {
                            System.out.println("You just stepped into a pit!");
                            System.out.println("GAME OVER!!!");
                            return true;
                        }
                        else if(currentX == pits[i].getX())
                        {
                            if(currentY+1 == pits[i].getY() || currentY-1 == pits[i].getY())
                                breeze = true;
                        }
                        else if(currentY == pits[i].getY())
                        {
                            if(currentX+1 == pits[i].getX() || currentX-1 == pits[i].getX())
                                breeze = true;
                        }
                    }
                    if (currentZ == wumpuses.get(i).getZ())
                    {
                        if ((currentX == wumpuses.get(i).getX()) && (currentY == wumpuses.get(i).getY()))
                        {
                            System.out.println("You were attacked by a Wumpus.");
                            System.out.println("You just lost " + Wumpus.DAMAGE + " of your health :(");
                            player.setHealth(player.getHealth() - Wumpus.DAMAGE);

                            if (player.getHealth() <= 0)
                            {
                                System.out.println("You just died because you lost all your health.");
                                return true;
                            }
                            else
                            {
                                System.out.println("You now have " + player.getHealth() + " of health.");
                            }
                        }
                        else if ((currentX == wumpuses.get(i).getX()))
                        {
                            if(currentY+1 == wumpuses.get(i).getY() || currentY-1 == wumpuses.get(i).getY())
                                smellBad = true;
                        }
                        else if ((currentY == wumpuses.get(i).getY()))
                        {
                            if(currentX+1 == wumpuses.get(i).getX() || currentX-1 == wumpuses.get(i).getX())
                                smellBad = true;
                        }
                    }
                }
                catch (IndexOutOfBoundsException e)
                {
                    //To use the for loop without having the OutOfBounds Exception
                }
            }
            System.out.println(currentRoom.getLongDescription());

            if(breeze)
                System.out.println("You feel a breeze");
            if(smellBad)
                System.out.println("Something smells bad");


            for(Item i : currentRoom.getItemsInRoom())
            {
                if(i != null)
                {
                    if (i.getName().equals("Gold"))
                        System.out.println("Something is really really shiny");
                }
            }
            return false;
        }
    }
    private void shoot(UserCommand userInput) //return true if all Wumpuses are destroyed
    {
        if(!userInput.hasDirection())
        {
            //if there is no second word, we don't know where to shoot...
            System.out.println("Shoot Where? ");
            currentRoom.getLongDescription();
            return;
        }
        else if(player.getAmmoCount() == 0)
        {
            System.out.println("You are out of ammo.");
            System.out.println("You can get more if you find some.");
            return;
        }

        String direction = userInput.getDirection();

        if(currentRoom.getExit(direction) == null)
        {
            System.out.println("There is no room in this direction.");
            return;
        }
        else
        {
            player.setAmmoCount(player.getAmmoCount()-1);

            boolean [] hitStatuses = new boolean[wumpuses.size()];
            for(int i = 0; i < wumpuses.size(); i++)
            {
                hitStatuses[i] = wumpuses.get(i).checkIfWumpusIsHit(currentRoom,direction);

                if(hitStatuses[i])
                {
                    System.out.println("You destroyed a Wumpus!!");
                    wumpuses.remove(i);
                    if(wumpuses.size() == 0)
                    {
                        System.out.println("Congratulations! You have killed all of the Wumpuses!");
                        System.out.println("You earned "+ Wumpus.DESTROY_WUMPUS_POINTS + " points!");
                        player.setScore(player.getScore() + Wumpus.DESTROY_WUMPUS_POINTS);
                        System.out.println("Your score is now " + player.getScore());
                        return;
                    }
                    else
                    {
                        player.setScore(player.getScore() + Wumpus.DESTROY_WUMPUS_POINTS);
                        System.out.println("You have " + wumpuses.size() + " more Wumpuses to kill.");
                        System.out.println("Your score is now " + player.getScore());
                        return;
                    }
                }
            }
            System.out.println("You missed.");
        }
    }
    private void grab(UserCommand userInput)
    {
        ArrayList<Item> itemsInRoom = new ArrayList<>();
        itemsInRoom = currentRoom.getItemsInRoom();
        boolean goldObtained = false;
        double weightAllowed = Player.MAX_INVENTORY_WEIGHT - player.getInventoryWeight();
        String overWeightedItems = "";

        if(itemsInRoom.get(Item.GOLD_INDEX) == null &&
                itemsInRoom.get(0) == null)
        {
            System.out.println("There is no item to grab");
            return;
        }

        String outputString = "You just grabbed ";
        for(int i = 0; i < itemsInRoom.size(); i++)
        {
            if (itemsInRoom.get(i) == null)
                continue;

            if (itemsInRoom.get(i).getWeight() > weightAllowed)
            {
                overWeightedItems += itemsInRoom.get(i).getName();
                continue; //skip to the next item
            }

            switch(itemsInRoom.get(i).getName())
            {
                case "Cookie":
                case "Steak":
                case "Hamburger":
                case "Super Drink":
                    outputString += (itemsInRoom.get(i)).getDescription();
                    player.addItemToInventory(itemsInRoom.get(i));
                    player.setInventoryWeight(player.getInventoryWeight()+itemsInRoom.get(i).getWeight());
                    player.setScore(player.getScore()+Item.OBTAINED_FOOD_SCORE);
                    outputString += "\nYour score is now " + player.getScore();
                    itemsInRoom.set(i,null);
                    break;
                case "Ammo":
                    outputString += (itemsInRoom.get(i)).getDescription();
                    player.addItemToInventory(itemsInRoom.get(i));
                    player.setInventoryWeight(player.getInventoryWeight()+itemsInRoom.get(i).getWeight());
                    player.setScore(player.getScore()+Item.OBTAINED_AMMO_SCORE);
                    player.setAmmoCount(player.getAmmoCount()+1);
                    itemsInRoom.set(i,null);
                    outputString += "\nYour score is now " + player.getScore();
                    break;
                case "Gold":
                    outputString += (itemsInRoom.get(i)).getDescription();
                    player.addItemToInventory(itemsInRoom.get(i));
                    player.setInventoryWeight(player.getInventoryWeight()+itemsInRoom.get(i).getWeight());
                    player.setScore(player.getScore()+Item.OBTAINED_GOLD_SCORE);
                    goldObtained = true;
                    itemsInRoom.set(i,null);
                    outputString += "Your score is now " + player.getScore();
                    break;
            }
        }

        if(outputString.equals("You just grabbed "))
        {
            System.out.println("current weight: " + player.getInventoryWeight());
            System.out.println("You cannot grab " + overWeightedItems + " because it will exceed your weight limit, " +
                    "which is " + Player.MAX_INVENTORY_WEIGHT + " lbs");
        }
        else
            System.out.println(outputString);

        if(goldObtained)
            System.out.println("Now go back to the starting point to win the game. (The room you started at)");

    }
    public void items()
    {
        ArrayList<Item> playerInventory = player.getInventory();
        if(!playerInventory.isEmpty())
        {
            System.out.println("\n--------Inventory--------");
            for (Item i : playerInventory)
                System.out.println(i + "\n");

            System.out.println("Total Weight: " + player.getInventoryWeight() + " lbs.");
        }
        else
            System.out.println("You don't have anything in your inventory.");
    }
    public void drop()
    {
        ArrayList<Item> playerInventory = player.getInventory();
        ArrayList<Item> itemsInRoom = new ArrayList<>();
        itemsInRoom = currentRoom.getItemsInRoom();
        Scanner kb = new Scanner(System.in);

        if(!playerInventory.isEmpty())
        {
            System.out.println("Which item would you like to drop?\n");

            for (int i = 0; i < playerInventory.size(); i++)
            {
                System.out.println(i + ".\n" + playerInventory.get(i)+ "\n");
            }
            System.out.println("Input the item number to drop.");
            try
            {
                int itemID = kb.nextInt();
                while(itemID < 0 || itemID > playerInventory.size()-1)
                {
                    System.out.println("Input a number between 0 and " + (playerInventory.size()-1));
                    itemID = kb.nextInt();
                }
                System.out.println("\nYou dropped\n" + playerInventory.get(itemID) + "\n");
                itemsInRoom.add(0,playerInventory.get(itemID));
                player.removeItemFromInventory(playerInventory.get(itemID));
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please input an integer next time.");
            }
        }
        else
            System.out.println("You don't have anything in your inventory.");

    }
    public void use()
    {
        ArrayList<Item> playerInventory = player.getInventory();
        ArrayList<Item> itemsInRoom = new ArrayList<>();
        itemsInRoom = currentRoom.getItemsInRoom();
        Scanner kb = new Scanner(System.in);

        if(!playerInventory.isEmpty())
        {
            System.out.println("Which item would you like to use?\n");

            for (int i = 0; i < playerInventory.size(); i++)
            {
                System.out.println(i + ".\n" + playerInventory.get(i)+ "\n");
            }
            System.out.println("Input the item number to use.");
            try
            {
                int itemID = kb.nextInt();
                while (itemID < 0 || itemID > playerInventory.size() - 1)
                {
                    System.out.println("Input a number between 0 and " + (playerInventory.size() - 1));
                    itemID = kb.nextInt();
                }

                String healthIncreasedString = "Your health has increased by ";
                boolean displayHealthString = false; //determines if
                //the healthIncreasedString should be displayed

                switch (playerInventory.get(itemID).getName())
                {
                    case "Cookie":
                        player.setHealth(player.getHealth()+Item.COOKIE_HEALTH_ADD);
                        healthIncreasedString += Item.COOKIE_HEALTH_ADD;
                        displayHealthString = true;
                        break;
                    case "Steak":
                        player.setHealth(player.getHealth()+Item.STEAK_HEALTH_ADD);
                        healthIncreasedString += Item.STEAK_HEALTH_ADD;
                        displayHealthString = true;
                        break;
                    case "Hamburger":
                        player.setHealth(player.getHealth()+Item.HAMBURGER_HEALTH_ADD);
                        healthIncreasedString += Item.HAMBURGER_HEALTH_ADD;
                        displayHealthString = true;
                        break;
                    case "Super Drink":
                        player.setHealth(player.getHealth()+Item.SUPER_DRINK_HEALTH_ADD);
                        healthIncreasedString += Item.SUPER_DRINK_HEALTH_ADD;
                        displayHealthString = true;
                        break;
                    case "Ammo":
                        player.setAmmoCount(player.getAmmoCount() + 1);
                        System.out.println("Your ammo count is now " + player.getAmmoCount());
                        break;
                    case "Gold":
                        System.out.println("You cannot use " + playerInventory.get(itemID).getName());
                        break;

                }
                player.setInventoryWeight(player.getInventoryWeight() - playerInventory.get(itemID).getWeight());
                System.out.println("\nYou used\n" + playerInventory.get(itemID) + "\n");
                player.removeItemFromInventory(playerInventory.get(itemID));

                if(displayHealthString)
                    System.out.println(healthIncreasedString);
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please input an integer next time.");
            }
        }
        else
            System.out.println("You don't have anything in your inventory.");
    }
    private boolean quit(UserCommand command)
    {
        return (command.getCommandWord()).equals("quit");
    }
}
