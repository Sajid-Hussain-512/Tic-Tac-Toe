import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors;
public class Game
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws IOException
    {
        Game g=new Game();
        g.startGame();
    }

    public void startGame()throws IOException
    {
        boolean wannaplay=true;
        System.out.println("        TIC TAC TOE");
        do {
            System.out.println("\n1. vs Computer");
            System.out.println("2. Two Player");
            System.out.println("3. SCORECARD");
            System.out.println("4. EXIT");
            System.out.print("Your Choice: ");
            int choice = Integer.parseInt(br.readLine());
            int level=0;
            if(choice == 1) {
                System.out.print("Choose Level\n1: EASY\n2: MEDIUM\n3: HARD\nYour Choice: ");
                level = Integer.parseInt(br.readLine());
            }

            if(choice==4) {
                wannaplay=false;                
                continue;
            }

            if(choice == 3) {
                ScoreCard scoreCard = new ScoreCard();
                scoreCard.showScore();
                continue;
            }
            Config cnfg =new Config(choice);        
            Game g=new Game();
            g.play(cnfg.player,level);            
        }while(wannaplay);
        System.out.println("See Ya (:-D");
    }

    public void play(List<Player> P,int level)
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t  LOADING...");        
        List check=null;
        List<String> pos = Stream.of("A1","A2","A3","B1","B2","B3","C1","C2","C3").collect(Collectors.toList());        
        boolean win=false;
        PrefLoc pref = new PrefLoc();
        try {
            Thread.currentThread().sleep(3000);
            Board b=new Board();
            int player=1,row,col;           
            for(int turns=1;turns<=9;turns++) {
                b.print();   
                String location=null;
                System.out.print(P.get(player-1).getName()+"'s turn: ");
                if(P.get(player-1).getName().equalsIgnoreCase("Computer")) {
                    location = pref.gimmeloc(b,P.get(player-1).getAvatar(),turns,pos,level);
                    Thread.currentThread().sleep(1000);
                    System.out.print(location+"\n");
                    Thread.currentThread().sleep(1000);
                }
                else {
                    location=br.readLine();
                }
                while(!b.updated(location,P.get(player-1).getAvatar())) {
                    System.err.println("Make Sure You Enter Valid Position!!!");
                    System.out.print(P.get(player-1).getName()+"'s turn: ");                
                    location=br.readLine();
                }
                pos.remove(location);
                player = (player & 1)==1?2:1;

                if(turns>=5) {
                    check = CheckWin.winCheck(b.board,P);
                    win = (Boolean)check.get(0);
                    if(win)
                        break;
                }                
            }
            b.print();
            if(win) {
                System.out.println("          "+check.get(1)+" WON");
            }
            else
            {
                System.out.println("             DRAW");
            }
            System.out.println("       G A M E   O V E R ");

            ScoreCard scoreCard = new ScoreCard();
            if(P.get(1).getName().equalsIgnoreCase("Computer")) {
                if(win) {
                    win = check.get(1).toString().equalsIgnoreCase("Computer") ? false : true;
                    scoreCard.updateScore(win,!win,level);
                }
                else {
                    scoreCard.updateScore(win,win,level);
                }
            }
        }
        catch(Exception e) {
            // System.out.println(e);
            e.printStackTrace();
        }
    }

}
