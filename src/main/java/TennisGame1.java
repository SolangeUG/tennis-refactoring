public class TennisGame1 implements TennisGame {


    private final Player playerOne;
    private final Player playerTwo;
    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1(Player playerOne, Player playerTwo) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOne.getName())
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            score = calculateScoreWhenThePointsAreEqual();
        }
        else if (m_score1>=4 || m_score2>=4) {
            score = calculateScoreWhenAtLeastOnePlayerHasFourPoints();
        }
        else {
            score = calculateScoreBetweenZeroToThreeWhenPointsAreNotEqual(score);
        }
        return score;
    }


    private String calculateScoreBetweenZeroToThreeWhenPointsAreNotEqual(String score) {
        int tempScore;
        for (int i = 1; i<3; i++) {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private String calculateScoreWhenAtLeastOnePlayerHasFourPoints() {
        String score;
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String calculateScoreWhenThePointsAreEqual() {
        String score;
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
