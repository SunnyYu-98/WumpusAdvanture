import java.util.Scanner;

public class Parser
{
    private CommandWords commands;
    private Scanner reader;

    public Parser()
    {
        commands = new CommandWords();
        reader  = new Scanner(System.in);
    }

    public UserCommand getUserCommand() //<command, direction>
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext())
        {
            word1 = tokenizer.next();
            if(tokenizer.hasNext())
            {
                word2 = tokenizer.next();
                //note: We just ignore the rest of the input line.
            }
        }
        if(word1 != null)
        {
            if(commands.isCommand(word1.toLowerCase()))
            {
                return new UserCommand(word1.toLowerCase(), word2);
            }
        }
        return new UserCommand(null, word2);

    }

    public void showCommands()
    {
        commands.showAll();
    }

}
