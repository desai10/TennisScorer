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

    }

    public void processMatch(String matchStatus) {

        displayScoreBoard(matchStatus);
    }

    public void incrementPoints(int player) {

    }

    public void incrementGames(int player) {

    }

    public void incrementSets(int player) {

    }

}
