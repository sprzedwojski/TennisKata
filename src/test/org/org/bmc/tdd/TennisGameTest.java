package org.bmc.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TennisGameTest {

    private org.bmc.tdd.TennisGame game;

    @BeforeEach
    void setUp() {
        game = new org.bmc.tdd.TennisGame();
    }

    @Test
    public void gameShouldStartWithZeroScore() {
        Assertions.assertThat(game.getScore())
                .isEqualTo("Love all");
    }

    @Test
    public void gameShouldReturnScoreAfterFirstPointsPlayerOne() {
        game.playerOneScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Fifteen,Love");
    }

    @Test
    public void gameShouldReturnScoreAfterFirstPointsPlayerTwo() {
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Love,Fifteen");
    }

    @Test
    public void gameShouldReturnScoreAfterPlayerTwoScoresTwice() {
        game.playerTwoScored();
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Love,Thirty");
    }

    @Test
    public void gameShouldReturnScoreAfterPlayerTwoScoresThreeTimes() {
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Love,Forty");
    }

    @Test
    public void gameShouldReturnScoreAfterPlayerOneScoresOnceAndPlayerTwoScoresThreeTimes() {
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Fifteen,Forty");
    }

    @Test
    public void gameShouldEndAfterPlayerOneScoresFourTimes() {
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Game won by Radwańska");
    }

    @Test
    public void gameShouldBeInADeuceAfterEachPlayerScoresThreeTimes() {
        generateDeuce();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Deuce");
    }

    @Test
    public void gameShouldBeInAdvantageForPlayerOneWhenOnlyOnePointAfterDeuceIsScored() {
        generateDeuce();
        game.playerOneScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Advantage Radwańska");
    }

    @Test
    public void gameShouldBeInAdvantageForPlayerTwoWhenOnlyOnePointAfterDeuceIsScored() {
        generateDeuce();
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Advantage Janowicz");
    }

    @Test
    public void gameShouldBeWonByPlayerOneOnePointScoredAfterAdvantage() {
        generateDeuce();
        game.playerOneScored();
        game.playerOneScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Game won by Radwańska");
    }

    @Test
    public void gameShouldBeWonByPlayerTwoOnePointScoredAfterAdvantage() {
        generateDeuce();
        game.playerTwoScored();
        game.playerTwoScored();
        Assertions.assertThat(game.getScore())
                .isEqualTo("Game won by Janowicz");
    }

    private void generateDeuce() {
        game.playerOneScored();
        game.playerOneScored();
        game.playerOneScored();
        game.playerTwoScored();
        game.playerTwoScored();
        game.playerTwoScored();
    }


}