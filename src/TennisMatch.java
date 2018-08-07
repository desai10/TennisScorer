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

    private String getPointsString(int player) {
        if(points.get(0) >= 3 && points.get(1) >= 3) {
            if(points.get(player) == points.get(getOtherPlayer(player))) {
                return "Duece";
            }
            if(points.get(player) > points.get(getOtherPlayer(player))) {
                return "Advantage";
            }
            else {
                return "-";
            }
        }
        else {
            return Integer.toString(points.get(player));
        }
    }

    public void displayScoreBoard() {
        System.out.print("Player:\tA\tB\n");
        System.out.print("Sets:\t"+sets.get(0)+"\t"+sets.get(1)+"\n");
        System.out.print("Games:\t"+games.get(0)+"\t"+games.get(1)+"\n");
        System.out.print("Points:\t"+getPointsString(0)+"\t"+getPointsString(1)+"\n");
    }

    public void processMatch(String matchStatus) {
        for(int i=0;i<matchStatus.length();i++) {
            if(matchStatus.charAt(i) == 'A') {
                incrementPoints(0);
            }
            else {
                incrementPoints(1);
            }
        }
        displayScoreBoard();
    }

    public void incrementPoints(int player) {
        if(isGamePoint(player)) {
            incrementGames(player);
        }
        else {
            points.set(player, points.get(player) + 1);
        }
    }

    private boolean isGamePoint(int player) {
        return points.get(player) - points.get(getOtherPlayer(player)) >= 1 && points.get(player) >= 3;
    }
    private int getOtherPlayer(int player) {
        return 1 - player;
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
        games.set(player, games.get(player) + 1);
    }

    public void incrementSets(int player) {
        int set_score = sets.get(player);
        sets.set(player,set_score+1);
        updateGamesNPoints();
    }

    public void updateGamesNPoints(){
        for(int i=0;i<games.size();i++) {
            games.set(i, 0);
            points.set(i, 0);
        }
    }

}
