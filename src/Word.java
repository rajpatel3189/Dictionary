import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import java.util.HashMap;

/**
 * Created by Raj on 3/18/2017.
 */

public class Word {


    HashMap<String,String> dictionary = new HashMap<>();

    //Inserting Key-Value pairs in the HashMap

    public void addWord(String word, String definition)
    {
        if (!dictionary.containsKey(word))
        {
            dictionary.put(word, definition);
        }
    }

    //Simple Key-Value lookup using HashMap

    public void lookupWord(String word)
    {
        String definition = null;
        if (dictionary.containsKey(word))
        {
            System.out.println(word + " " + dictionary.get(word));

        }
        else definition = "ERROR: DEFINITION NOT FOUND!";
    }


//Using Popular Graph Library from JGrapht to implement Unidirectional Graph............  http://jgrapht.org/javadoc/


    UndirectedGraph<String, DefaultEdge> synonyms = new SimpleGraph<>(DefaultEdge.class);


// Connecting two words as Synonyms using graph...
// ..Validations such as if graph is empty, if vertex already exist are done already by JGrapht library methods

    public void addSynonym(String word1, String word2)
    {
        synonyms.addVertex(word1);
        synonyms.addVertex(word2);
        synonyms.addEdge(word1, word2);
    }

    // Iterating through graph to print all Synonyms using BFS to get all the connected vertex/nodes which in our case words/synonyms

    public void lookupSynonym(String word)
    {
        if (synonyms.containsVertex(word))
        {
            BreadthFirstIterator<String, DefaultEdge> bfi = new BreadthFirstIterator<String, DefaultEdge>(synonyms, word);
            while (bfi.hasNext())
            {
                System.out.print(bfi.next() + "\t");
            }

        }
    }
}
