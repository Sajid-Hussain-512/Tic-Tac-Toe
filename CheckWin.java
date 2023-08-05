import java.util.*;
public class CheckWin
{
    public static List winCheck(List<List<String>> cState,List<Player> P)
    {
        List result = new ArrayList<>();

        for(List<String> rows: cState)
        {
            if(checkRows(rows))
            {
                result.add(true);                
                result.add(rows.get(0).trim().equals(P.get(0).getAvatar())?P.get(0).getName():P.get(1).getName());
                return result;
                // System.out.println("       "+" WON");
                // return true;
            }   
        }

        for(int cols=0;cols<3;cols++)
        {
            if(checkCols(cState,cols))
            {
                result.add(true);                
                result.add(cState.get(0).get(cols).trim().equals(P.get(0).getAvatar())?P.get(0).getName():P.get(1).getName());
                return result;
                // System.out.println("       "+()+" WON");
                // return true;
            }
        }

        // Checking Diagonal 1
        if( cState.get(0).get(0).equals(cState.get(1).get(1)) && cState.get(0).get(0).equals(cState.get(2).get(2)))
        {
            result.add(true);
            result.add(cState.get(0).get(0).trim().equals(P.get(0).getAvatar())?P.get(0).getName():P.get(1).getName());
            return result;
            // System.out.println("       "+()+" WON");
            // return true;
        }

        // Checking Diagonal 2
        if( cState.get(0).get(2).equals(cState.get(1).get(1)) && cState.get(0).get(2).equals(cState.get(2).get(0)))
        {
            result.add(true);
            result.add(cState.get(0).get(2).trim().equals(P.get(0).getAvatar())?P.get(0).getName():P.get(1).getName());
            return result;
            // System.out.println("       "+()+" WON");
            // return true;
        }
        result.add(false);
        return result;
    }

    // Checking Rows
    public static boolean checkRows(List<String> row)
    {
        boolean win = false;
        if( (row.get(0).trim().equals(row.get(1).trim())) && (row.get(0).trim().equals(row.get(2).trim())) )
            win = true;

        return win;
    }

    // Checking Columns
    public static boolean checkCols(List<List<String>> cState, int col)
    {
        boolean win = false;
        if( (cState.get(0).get(col).trim().equals(cState.get(1).get(col).trim())) && (cState.get(0).get(col).trim().equals(cState.get(2).get(col).trim())) )
            win = true;

        return win;
    }
    
}