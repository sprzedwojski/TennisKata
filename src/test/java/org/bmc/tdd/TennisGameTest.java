package org.bmc.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TennisGameTest {

    TennisGame game = new TennisGame();

    @Test
    public void shouldScoreMinusOneWithJUnit() {
        assertEquals(-1, game.getScore());
    }

    @Test
    public void shouldScoreMinusOneWithAssertJ() {
        Assertions.assertThat(game.getScore()).isEqualTo(-1);
    }

}