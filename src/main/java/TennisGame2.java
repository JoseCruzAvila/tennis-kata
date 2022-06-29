public class TennisGame2 implements TennisGame {
    private int pointToP1 = 0;
    private int pointToP2 = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String player = "";
        String resP1 = pointToValue(pointToP1);
        String resP2 = pointToValue(pointToP2);
        String score = resP1 + "-" + resP2;

        if (pointToP1 == pointToP2 && pointToP1 < 4)
            score = resP1 + "-All";
        
        if (pointToP1==pointToP2 && pointToP1 >= 3)
            score = "Deuce";
        
        if (pointToP1 > pointToP2)
            player = player1Name;
        
        if (pointToP2 > pointToP1)
            player = player2Name;

        if ((pointToP1 >= 3 && pointToP2 >= 3) && !player.isBlank())
            score = "Advantage " + player; 
        
        if ((pointToP1 >= 4 || pointToP2 >= 4) && Math.abs(pointToP1-pointToP2) >= 2 && !player.isBlank())
            score = "Win for " + player;
        
        return score;
    }
    
    public void setP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addP1Score();
        }
            
    }
    
    public void setP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addP2Score();
        }
            
    }
    
    public void addP1Score(){
        pointToP1++;
    }
    
    public void addP2Score(){
        pointToP2++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            addP1Score();
        else
            addP2Score();
    }

    private String pointToValue(int userPoint) {
        switch (userPoint) {
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