public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            mScore1 ++;
        else
            mScore2 ++;
    }

    public String getScore() {
        String score = "";
        String player = player1Name;
        score = scoreValue(mScore1) + "-" + scoreValue(mScore2);
        
        if (mScore1 == mScore2) {
            score = mScore1 >= 3 ? "Deuce" : scoreValue(mScore1) + "-All";
        }
        
        if ((mScore1>=4 || mScore2>=4) && mScore1 != mScore2 ) {
            if (mScore2 > mScore1)
                player = player2Name;

            score = Math.abs(mScore1 - mScore2) <= 1 ? "Advantage " : "Win for ";
            
            score += player;
        }

        return score;
    }

    private String scoreValue(int score) {
        switch (score) {
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Love";
        }
    }
}
