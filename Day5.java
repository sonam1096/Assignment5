package ASSIGNMENT5;

import java.util.Scanner;
class compitition{
    private int player;
    private String completeSets;
    private String incompleteSets;
    private int pieces;
     
    compitition(){
    	
    }
    public compitition(int player, String completeSets, String incompleteSets, int pieces) {
        this.player = player;
        this.completeSets = completeSets;
        this.incompleteSets = incompleteSets;
        this.pieces = pieces;
    }

    public int getPlayer() {
        return player;
    }

    public String getCompleteSets() {
        return completeSets;
    }

    public String getIncompleteSets() {
        return incompleteSets;
    }

    public int getPieces() {
        return pieces;
    }

    public void setCompleteSets(String completeSets) {
        this.completeSets = completeSets;
    }

    public void setIncompleteSets(String incompleteSets) {
        this.incompleteSets = incompleteSets;
    }

    public void setPiecesBuilt(int piecesBuilt) {
        this.pieces = pieces;
    }

    public String toString() {
        return "Player " + player + " completed the following sets: " + completeSets + "\n"
                + "Player " + player + " did not complete the following sets: " + incompleteSets + "\n"
                + "Player " + player + " built a total of " + pieces + " pieces\n";
    }
}

public class Day5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Lego Set Competition!");

         
        System.out.print("Enter the name of Lego Set 1: ");
        String set1 = sc.nextLine();
        System.out.print("Enter the number of pieces in Lego Set 1: ");
         double set1Pieces = Integer.parseInt(sc.nextLine());  

        System.out.print("Enter the name of Lego Set 2: ");
        String set2 = sc.nextLine();
        System.out.print("Enter the number of pieces in Lego Set 2: ");
        int set2Pieces = Integer.parseInt(sc.nextLine());  

        System.out.print("Enter the name of Lego Set 3: ");
        String set3 = sc.nextLine();
        System.out.print("Enter the number of pieces in Lego Set 3: ");
        int set3Pieces = Integer.parseInt(sc.nextLine());  

        int day = 1;
        int player1Pieces = 0;
        int player2Pieces = 0;
        boolean player1CompletedAll = false;
        boolean player2CompletedAll = false;

        while (!player1CompletedAll && !player2CompletedAll) {
            System.out.println("Day " + day);
            System.out.print("Enter the number of pieces player 1 used for building on day " + day + ": ");
            int player1DayPieces =Integer.parseInt(sc.nextLine());  
            player1Pieces =  player1Pieces+player1DayPieces;

            System.out.print("Enter the number of pieces player 2 used for building on day " + day + ": ");
            int player2DayPieces = Integer.parseInt(sc.nextLine());  
            player2Pieces =  player2Pieces+player2DayPieces;

             
            player1CompletedAll = player1Pieces >= set1Pieces && player1Pieces >= set2Pieces && player1Pieces >= set3Pieces;
            player2CompletedAll = player2Pieces >= set1Pieces && player2Pieces >= set2Pieces && player2Pieces >= set3Pieces;

            if (!player1CompletedAll && !player2CompletedAll) {
                day++;
            }
        }

        System.out.println();

        // Determine the winner and create CompetitionLog objects for each player
        compitition player1 = new compitition(1, "", "", player1Pieces);
        compitition player2 = new compitition(2, "", "", player2Pieces);

        if (player1CompletedAll && player2CompletedAll) {
            System.out.println("The competition ended in a tie!");
            player1.setCompleteSets("");
            player1.setIncompleteSets(set1 + ", " + set2 + ", " + set3);
            player2.setCompleteSets("");
            player2.setIncompleteSets(set1 + ", " + set2 + ", " + set3);
        } else if (player1CompletedAll) {
            System.out.println("Congratulations to player 1 for winning the Lego Set Competition!");
            player1.setCompleteSets(set1 + ", " + set2 + ", " + set3);
            player2.setIncompleteSets(set1 + ", " + set2 + ", " + set3);
        } else {
            System.out.println("Congratulations to player 2 for winning the Lego Set Competition!");
            player1.setIncompleteSets(set1 + ", " + set2 + ", " + set3);
            player2.setCompleteSets(set1 + ", " + set2 + ", " + set3);
        }

        // Print the logs
        System.out.println("Additional information about the competition results is below :");
        System.out.println(player1.toString());
        System.out.println(player2.toString());

        System.out.println("The competition lasted " + day + " days");
    }
}
		

		

