import java.util.*;
public class Board
{
    List<List<String>> board = new ArrayList<>();
    public Board()
    {   
        board.add(Arrays.asList("A1","B1","C1"));
        board.add(Arrays.asList("A2","B2","C2"));
        board.add(Arrays.asList("A3","B3","C3"));
    }

    public boolean updated(String cell, String Avatar)
    {
        if(cell.length()>=2) {        
            int row=(int)cell.charAt(1)-49;
            int col=(int)cell.charAt(0)-65;
            if((row>=0 && row<=2 && col>=0 && col<=2 ) && this.board.get(row).get(col).equals(cell))
            {
                this.board.get(row).set(col,Avatar+" ");
                return true;
            }
        }
        return false;
    }

    public void print()
    {
        System.out.println("   C U R R E N T   S T A T E");
        // input.forEach(System.out::println);        
        for(int i=0;i<this.board.size();i++)
        {
            System.out.print("\t");
            for(int j=0;j<this.board.get(i).size();j++)
            {                
                if(j!=1)                                 
                    System.out.print(" "+this.board.get(i).get(j));
                else
                    System.out.print(" | "+this.board.get(i).get(j)+" |");
            }
            if(i!=this.board.size()-1)
                System.out.println("\n\t----+----+----");
        }        
        System.out.println();
    }

}
