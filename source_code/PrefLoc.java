import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.stream.Collectors;

public class PrefLoc
{
    List<String> corner = Stream.of("A1","A3","C1","C3").collect(Collectors.toList());

    /*
     * Find A Location Based On Level
     */
    public String gimmeloc(Board b, String myAvatar, int turns, List<String>availablePos, int level)
    {
        String location=null;        
        //Hard Level
        if(level == 3 && turns == 2) {                
            if(b.board.get(1).get(1).equals("B2")) {
                return "B2";
            }
            else {
                return corner.get((int)(Math.random()*corner.size()));
            }
        }

        //Medium && Hard Level
        if(level != 1 && turns > 3) {
            location=mostPref(b,myAvatar);
            if(location != null) {
                return location;
            }
        }

        //Easy Level && When Not Found
        return availablePos.get((int)(Math.random()*availablePos.size()));
    }    

    /*
     * Find the most Preferred Location
     */
    public String mostPref(Board b,String myAvatar)
    {
        List<String> locs = new ArrayList<>();
        // System.out.println(myAvatar);        

        //Checking Rows
        for(int i=0;i<3;i++) {
            if((b.board.get(i).get(0).equals(b.board.get(i).get(1))) && (b.board.get(i).get(2).equals("C"+(i+1)))) {
                if(b.board.get(i).get(0).equals(myAvatar.trim())) {
                    return "C"+(i+1);
                }
                locs.add("C"+(i+1));
            }

            if((b.board.get(i).get(0).equals(b.board.get(i).get(2))) && (b.board.get(i).get(1).equals("B"+(i+1)))) {
                if(b.board.get(i).get(0).equals(myAvatar.trim())) {
                    return "B"+(i+1);
                }
                locs.add("B"+(i+1));
            }

            if((b.board.get(i).get(1).equals(b.board.get(i).get(2))) && (b.board.get(i).get(0).equals("A"+(i+1)))) {
                if(b.board.get(i).get(1).equals(myAvatar.trim())) {
                    return "A"+(i+1);
                }
                locs.add("A"+(i+1));
            }
        }

        //Checking Columns
        for(int i=0;i<3;i++) {
            if((b.board.get(0).get(i).equals(b.board.get(1).get(i))) && (b.board.get(2).get(i).equals((char)(i+65)+"3"))) {
                if(b.board.get(0).get(i).trim().equals(myAvatar)) {
                    return (char)(i+65)+"3";
                }
                locs.add((char)(i+65)+"3");
            }

            if((b.board.get(0).get(i).equals(b.board.get(2).get(i))) && (b.board.get(1).get(i).equals((char)(i+65)+"2"))) {
                if(b.board.get(0).get(i).trim().equals(myAvatar)) {
                    return (char)(i+65)+"2";
                }
                locs.add((char)(i+65)+"2");
            }

            if((b.board.get(1).get(i).equals(b.board.get(2).get(i))) && (b.board.get(0).get(i).equals((char)(i+65)+"1"))) {
                if(b.board.get(1).get(i).trim().equals(myAvatar)) {
                    return (char)(i+65)+"1";
                }
                locs.add((char)(i+65)+"1");
            }

        }

        //Checking Diagonal 1
        if((b.board.get(0).get(0).equals(b.board.get(1).get(1))) && (b.board.get(2).get(2).equals("C3"))) {
            if(b.board.get(0).get(0).trim().equals(myAvatar)) {
                return "C3";
            }
            locs.add("C3");
        }

        if((b.board.get(0).get(0).equals(b.board.get(2).get(2))) && (b.board.get(1).get(1).equals("B2"))) {
            if(b.board.get(0).get(0).trim().equals(myAvatar)) {
                return "B2";
            }
            locs.add("B2");
        }

        if((b.board.get(1).get(1).equals(b.board.get(2).get(2))) && (b.board.get(0).get(0).equals("A1"))) {
            if(b.board.get(1).get(1).trim().equals(myAvatar)) {
                return "A1";
            }
            locs.add("A1");
        }

        //Checking Diagonal 2
        if((b.board.get(0).get(2).equals(b.board.get(1).get(1))) && (b.board.get(2).get(0).equals("A3"))) {
            if(b.board.get(0).get(2).trim().equals(myAvatar)) {       
                return "A3";
            }
            locs.add("A3");
        }

        if((b.board.get(0).get(2).equals(b.board.get(2).get(0))) && (b.board.get(1).get(1).equals("B2"))) {
            if(b.board.get(0).get(2).trim().equals(myAvatar)) {       
                return "B2";
            }
            locs.add("B2");
        }

        if((b.board.get(1).get(1).equals(b.board.get(2).get(0))) && (b.board.get(0).get(2).equals("C1"))) {
            if(b.board.get(1).get(1).trim().equals(myAvatar)) {                
                return "C1";
            }
            locs.add("C1");
        }

        //Counter Attacking Opponent
        if(locs.size()>0) {
            return locs.get((int)Math.random()*locs.size());
        }

        //Didn't Find A Preferred Location
        return null;
    }
}

// public String prefloc(Board cur)
// {
// // String loc = checkRows(cur);
// // if(loc!=null) {
// // System.out.println(loc);
// // }
// // else {
// // System.out.println("No Rows Possible");
// // }

// // if(loc!=null) {
// // System.out.println(loc);
// // }
// // else {
// // System.out.println("No Columns Possible");
// // }

// // if(loc!=null) {
// // System.out.println(loc);
// // }
// // else {
// // System.out.println("Diag1 Not Possible");
// // }

// // if(loc!=null) {
// // System.out.println(loc);
// // }
// // else {
// // System.out.println("Diag2 Not Possible");
// // }

// String loc=checkRows(cur);
// if(loc!=null)
// return loc;

// loc=checkCols(cur);
// if(loc!=null)
// return loc;

// loc=checkDiags1(cur);
// if(loc!=null)
// return loc;

// loc=checkDiags2(cur);
// if(loc!=null)
// return loc;

// return null;
// }

// public String checkRows(Board b)
// {
// for(int i=0;i<3;i++) {
// if((b.board.get(i).get(0).equals(b.board.get(i).get(1))) && (b.board.get(i).get(2).equals("C"+(i+1)))) {
// return "C"+(i+1);
// }

// if((b.board.get(i).get(0).equals(b.board.get(i).get(2))) && (b.board.get(i).get(1).equals("B"+(i+1)))) {
// return "B"+(i+1);
// }

// if((b.board.get(i).get(1).equals(b.board.get(i).get(2))) && (b.board.get(i).get(0).equals("A"+(i+1)))) {
// return "A"+(i+1);
// }

// }
// return null;
// }

// public String checkCols(Board b)
// {
// for(int i=0;i<3;i++) {
// if((b.board.get(0).get(i).equals(b.board.get(1).get(i))) && (b.board.get(2).get(i).equals((char)(i+65)+"3"))) {
// return (char)(i+65)+"3";
// }

// if((b.board.get(0).get(i).equals(b.board.get(2).get(i))) && (b.board.get(1).get(i).equals((char)(i+65)+"2"))) {
// return (char)(i+65)+"2";
// }

// if((b.board.get(1).get(i).equals(b.board.get(2).get(i))) && (b.board.get(0).get(i).equals((char)(i+65)+"1"))) {
// return (char)(i+65)+"1";
// }

// }
// return null;
// }

// public String checkDiags1(Board b)
// {
// if((b.board.get(0).get(0).equals(b.board.get(1).get(1))) && (b.board.get(2).get(2).equals("C3"))) {
// return "C3";
// }

// if((b.board.get(0).get(0).equals(b.board.get(2).get(2))) && (b.board.get(1).get(1).equals("B2"))) {
// return "B2";
// }

// if((b.board.get(1).get(1).equals(b.board.get(2).get(2))) && (b.board.get(0).get(0).equals("A1"))) {
// return "A1";
// }
// return null;
// }

// public String checkDiags2(Board b)
// {
// if((b.board.get(0).get(2).equals(b.board.get(1).get(1))) && (b.board.get(2).get(0).equals("A3"))) {
// return "A3";
// }

// if((b.board.get(0).get(2).equals(b.board.get(2).get(0))) && (b.board.get(1).get(1).equals("B2"))) {
// return "B2";
// }

// if((b.board.get(1).get(1).equals(b.board.get(2).get(0))) && (b.board.get(0).get(2).equals("C1"))) {
// return "C1";
// }
// return null;
// }
