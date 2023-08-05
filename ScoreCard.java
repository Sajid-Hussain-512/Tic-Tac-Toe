import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ScoreCard
{
    public void updateScore(boolean won,boolean lost,int level)
    {
        try {
            // FileReader filewriter = new FileWriter("scorecard.txt");            
            BufferedReader bufferedReader = new BufferedReader(new FileReader("scorecard.txt"));            

            String line = null;
            // List<Integer> score = new ArrayList<>();
            List<List<Integer>> levelscore = new ArrayList<>();

            IntStream.range(0, 3).forEach(i -> {
                    try {
                        levelscore.add(
                            Stream.of(bufferedReader.readLine().replaceAll("[\\[\\]\\s$]","").split(","))
                            .map(Integer::parseInt)
                            .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

            bufferedReader.close();
            // Changing Scores            
            //Played+=1
            levelscore.get(level-1).set(0, levelscore.get(level-1).get(0)+1);            
            int status = won ? 1 : lost ? 2 : 3;
            //Status+=1
            levelscore.get(level-1).set(status, levelscore.get(level-1).get(status)+1);           
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("scorecard.txt"));
            // Update the score in the file
            bufferedWriter.write(
                levelscore.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
            );

            bufferedWriter.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    public void showScore()
    {
        Map<Integer,String> levels = new HashMap<>();
        levels.put(1,"EASY");
        levels.put(2,"MEDIUM");
        levels.put(3,"HARD");               
        // System.out.println(levels);
        System.out.println("\t--------------------------");
        System.out.println("\t\t SCORECARD");
        System.out.println("\t--------------------------");        
        try {            
            BufferedReader bufferedReader = new BufferedReader(new FileReader("scorecard.txt"));
            String line = null;

            IntStream.range(0, 3).forEach(i -> {                
                    try {  
                        List<Integer> score = new ArrayList<>();
                        score = Stream.of(bufferedReader.readLine().replaceAll("[\\[\\]\\s$]","").split(","))
                        .map(Integer::parseInt)
                        .collect(toList()
                        );

                        System.out.println("\t\t   "+levels.get(i+1));
                        System.out.println("\t--------------------------");
                        System.out.format("\t|  Played\t|\t%s|\n",score.get(0));
                        System.out.format("\t|  WON   \t|\t%s|\n",score.get(1));
                        System.out.format("\t|  LOST  \t|\t%s|\n",score.get(2));
                        System.out.format("\t|  DRAW  \t|\t%s|\n",score.get(0)-(score.get(1) + score.get(2)));

                        System.out.println("\t--------------------------");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });            
        }

        catch(FileNotFoundException e) {
            System.out.println(e);
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
