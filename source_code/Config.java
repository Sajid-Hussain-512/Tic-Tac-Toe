import java.io.*;
import java.util.*;
public class Config
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> Avatar = new ArrayList<>(Arrays.asList("X","O","@","$","#")); 
    List<Player> player=new ArrayList<>();
    
    public Config(int choice)throws IOException
    {
        for(int i=1;i<=choice;i++) {
            System.out.print("Enter Player " + i + " Name: ");
            addPlayer(player);
        }
        if(choice==1) {
            String avatar=Avatar.get((int)(Math.random()*Avatar.size()));
            System.out.println("Player 2: Computer");
            System.out.println("Its Avatar: "+avatar);
            player.add(new Player("Computer", avatar));
            Avatar.remove(avatar);
        }        
    }

    public void addPlayer(List<Player> player)throws IOException
    {
        String name = br.readLine();
        if(name.equalsIgnoreCase("Computer")) {
            System.err.println("Can't use " + name + " as Player's name!!!");
            System.out.print("Enter Another Name: ");
            name = br.readLine();
        }
        System.out.println("Available Avatars: "+Avatar);
        System.out.print("Choose Your Avatar: ");
        String avatar=br.readLine();
        if(Avatar.indexOf(avatar)==-1) {                
            avatar=Avatar.get((int)(Math.random()*Avatar.size()));
            System.err.println("Make Sure You Enter Valid Avatar!!!");
            System.out.println("Your avatar: "+avatar);        
        }
        player.add(new Player(name, avatar));
        Avatar.remove(avatar);        
    }
    
    /*
    public List<Player> configure(int choice)
    {        
        try
        {
            System.out.println("Before We Start the Game, Let's Configure Something....");
            System.out.print("Enter Player 1 Name: ");
            String name = br.readLine();
            System.out.println("Available Avatars: "+Avatar);
            System.out.print("Choose Your Avatar: ");
            String avatar=br.readLine();
            if(Avatar.indexOf(avatar)==-1)
            {                
                avatar=Avatar.get((int)(Math.random()*Avatar.size()));
                System.err.println("Make Sure You Enter Valid Avatar!!!\nYour avatar is "+avatar);
            }
            Player p1=new Player(name, avatar);
            Avatar.remove(avatar);
            System.out.print("Enter Player 2 Name: ");
            name = br.readLine();
            System.out.println("Available Avatars: "+Avatar);
            System.out.print("Choose Your Avatar: ");
            avatar=br.readLine();
            if(Avatar.indexOf(avatar)==-1)
            {                
                avatar=Avatar.get((int)(Math.random()*Avatar.size()));
                System.err.println("Make Sure You Enter Valid Avatar!!!\nYour avatar is "+avatar);
            }
            Player p2=new Player(name, avatar);            
            Avatar.remove(avatar);
            Players.add(p1);
            Players.add(p2);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return Players;
    }
    */
}
