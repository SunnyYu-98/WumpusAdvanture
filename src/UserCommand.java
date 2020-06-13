//this class is to hold user's command
public class UserCommand
{
    private String firstWord; //user's command
    private String secondWord; //direction

    public UserCommand(String first, String second)
    {
        firstWord = first; //a command word
        if(second != null)
            secondWord = second.toLowerCase(); //direction
    }
    public String getCommandWord()
    {
        return firstWord;
    }
    public String getDirection()
    {
        return secondWord;
    }
    public boolean isUnknown()
    {
        return (firstWord == null || firstWord.equals("?"));
    }
    public boolean hasDirection()
    {
        return (secondWord != null);
    }

}
