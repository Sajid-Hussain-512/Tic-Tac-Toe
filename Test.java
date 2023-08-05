public class Test
{
    public static void main(String... args)
    {
        Board b = new Board();
        // b.updated("B2","@");
        // b.updated("B3","@");
        // b.updated("A1","@");
        // b.updated("A2","@");
        // b.updated("C3","@");
        // b.updated("C1","@");

        // b.updated("","@");
        b.updated("B2","@");
        b.updated("A3","@");
        b.updated("C3","@");
        b.print();
        PrefLoc p=new PrefLoc();
        p.mostPref(b,"X");
    }
}
