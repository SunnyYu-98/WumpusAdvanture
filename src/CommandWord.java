public enum CommandWord
{
    //A value for each command word along with its
    //corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), SHOOT("shoot"), GRAB("grab"),
    ITEMS("items"),DROP("drop"), USE("use"), UNKNOWN("?");

    //The command String
    private String commandString;

    //Initialize with the corresponding command string
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }

    //return the command word as a string
    public String toString()
    {
        return commandString;
    }
}
