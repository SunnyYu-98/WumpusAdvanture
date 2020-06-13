import java.util.HashMap;

public class CommandWords
{
    //A mapping between a command word and the CommandWord
    //associate with it.
    private HashMap<String, CommandWord> validCommands;

    //Constructor: Initialize the command words
    public CommandWords()
    {
        validCommands = new HashMap<>();
        for (CommandWord command : CommandWord.values())
        {
            if(command != CommandWord.UNKNOWN)
            {
                validCommands.put((command.toString()), command);
            }
        }
    }

    //Find the CommandWord associated with a command word
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command!=null)
        {
            return command;
        }
        else
        {
            return CommandWord.UNKNOWN;
        }
    }

    //Check if a given String is a valid command
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    //Print out all of the commands
    public void showAll()
    {
        for(String command : validCommands.keySet())
        {
            System.out.println(command + " ");
        }
        System.out.println();
    }
}
