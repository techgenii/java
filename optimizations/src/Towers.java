public class Towers {

    // Towers of Hanoi
    // Speed:  , Size:
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Move Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Move Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    // Towers of Hanoi - Non-recursive version
    // Speed: O(n) , Size:
    public static void doTowersF(long iDisk) {
        int m;
        System.out.println("Total Disks = " + iDisk);
        for (m=1; m < (1 << iDisk); m++)
        {
            long p1 = ((m&m-1)%3) + 1;
            long p2 = (((m|m-1)+1)%3) + 1;
            int dsk = ctz(m) + 1;
            System.out.printf("Move Disk %d ", dsk);
            System.out.printf("from Peg %d to Peg %d\n", p1, p2);
        }
        System.out.println("Done!");
    }

    public static int ctz(long x) {
        int n = 0;

        x = ~x & (x - 1);
        while(x != 0) {
            n = n + 1;
            x = x >> 1;
        }
        return n;
    }


    public static void main(String[] args) {

        System.out.println("Towers of Hanoi");

        // Towers of Hanoi
        System.out.println("-- Towers of Hanoi: Recursion --");
        doTowers(3, '1', '2', '3');
        doTowers(4, '1', '2', '3');
        doTowers(5, '1', '2', '3');

        // Towers of Hanoi
        System.out.println("-- Towers of Hanoi: Non-Recusive --");
        doTowersF(3);
        doTowersF(4);
        doTowersF(5);
    }
}
