public class TennisGame1 implements TennisGame {


    private final Player playerOne;
    private final Player playerTwo;

    public TennisGame1(Player playerOne, Player playerTwo) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String playerName) {
        if (hasPlayerOneWonThePoint(playerName)) {
            playerOne.wonPoint();
        } else {
            playerTwo.wonPoint();
        }
    }

    private boolean hasPlayerOneWonThePoint(String playerName) {
        return playerName.equals(playerOne.getName());
    }

    public String getScore() {
        String score = "";
        if (playersHaveEqualScores(playerOne.getScore(), playerTwo.getScore())) {
            return calculateScoreWhenThePointsAreEqual();
        } else if (playersHaveAtLeastFourPoints(playerOne.getScore(), playerTwo.getScore())) {
            return calculateScoreWhenAtLeastOnePlayerHasFourPoints();
        }

        return calculateScoreBetweenZeroToThreeWhenPointsAreNotEqual(score);
    }

    private boolean playersHaveAtLeastFourPoints(int scoreOne, int scoreTwo) {
        return scoreOne >= 4 || scoreTwo >= 4;
    }

    private boolean playersHaveEqualScores(int scoreOne, int scoreTwo) {
        return scoreOne == scoreTwo;
    }


    private String calculateScoreBetweenZeroToThreeWhenPointsAreNotEqual(String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOne.getScore();
            else {
                score += "-";
                tempScore = playerTwo.getScore();
            }
            score += displayScores(tempScore);
        }
        return score;
    }

    private String displayScores(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

    private String calculateScoreWhenAtLeastOnePlayerHasFourPoints() {
        String score;
        int minusResult = playerOne.getScore()-playerTwo.getScore();
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String calculateScoreWhenThePointsAreEqual() {
        String score;
        switch (playerOne.getScore())
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
