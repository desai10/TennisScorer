import java.util.ArrayList;
import java.util.List;

public class TennisMatch {

    private List<Integer> sets;
    private List<Integer> games;
    private List<Integer> points;

    public TennisMatch() {
        sets = new ArrayList<>(2);
        games = new ArrayList<>(2);
        points = new ArrayList<>(2);
        for(int i=0;i<2;i++) {
            sets.add(0);
            games.add(0);
            points.add(0);
        }
    }

    public void displayScoreBoard(String matchStatus) {
    	System.out.println("Player:   A   B");
    	System.out.printf("sets:  %4d%4d\n",sets.get(0),sets.get(1));
    	System.out.printf("games: %4d%4d\n",games.get(0),games.get(1));
    	System.out.printf("points:%4d%4d\n",points.get(0),points.get(1));
    }

    public void processMatch(String matchStatus) {

        displayScoreBoard(matchStatus);
    }

    public void incrementPoints(int player) {

    }
    private boolean isSetPoint(int player) {
    	return ((games.get(player)-games.get(1-player)>=1) && games.get(player)>=6);
    }
    public void incrementGames(int player) {
    	if (isSetPoint(player)) {
    		incrementSets(player);
    		games.set(0, 0);
			games.set(1, 0);
    	}
    	games.set(player,games.get(player)+1);

    }

    public void incrementSets(int player) {

    }

}
