import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Raj on 3/18/2017.
 */

public class Main
{

    public static void main(String[] args)
    {
	// Reading the file from path line by line to get Command and Parameters as Input

        System.out.println("Enter the Text(.txt) File Location: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        Word wrd = new Word();
        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader(new FileReader(path));
            while ((strLine = br.readLine()) != null)
            {
                String[] str = strLine.split(":");

                //Based on first word of the line/string seperated by colon determine Command

                switch (str[0])
                {
                    case "addWord":
                        wrd.addWord(str[1],str[2]);
                        break;
                    case "lookupWord":
                        wrd.lookupWord(str[1]);
                        break;
                    case "addSynonym":
                        wrd.addSynonym(str[1],str[2]);
                        break;
                    case "lookupSynonyms":
                        wrd.lookupSynonym(str[1]);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Command ");
                }
            }
        }
        catch (FileNotFoundException e)
            {
            System.err.println("Unable to find the file: fileName");
        } catch (IOException e)
        {
            System.err.println("Unable to read the file: fileName");
        }
    }
}
