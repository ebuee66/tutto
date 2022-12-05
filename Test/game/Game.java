package game;

import GameMaterial.Card;
import Gameplay.Game;
import Gameplay.Player;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;

class UtilsTest {

    @Test
    void testNumberPlayers() {
        int numPlayers = Game.numberofPlayers();
        Assert.assertTrue(numPlayers >= 2 && numPlayers <= 4);
    }

    @Test
    void testSortPlayers2() {
        int numPlayers = 2;

        ArrayList<Player> listPlayerInput = Game.sortPlayers(numPlayers);
        int asciiValuePlayer0 = listPlayerInput.get(0).getName().substring(0,1).charAt(0);
        int asciiValuePlayer1 = listPlayerInput.get(1).getName().substring(0,1).charAt(0);
        Assert.assertTrue(asciiValuePlayer0 <= asciiValuePlayer1);
    }

    @Test
    void testSortPlayers3() {
        int numPlayers = 3;

        ArrayList<Player> listPlayerInput = Game.sortPlayers(numPlayers);
        int asciiValuePlayer0 = listPlayerInput.get(0).getName().substring(0,1).charAt(0);
        int asciiValuePlayer1 = listPlayerInput.get(1).getName().substring(0,1).charAt(0);
        int asciiValuePlayer2 = listPlayerInput.get(2).getName().substring(0,1).charAt(0);
        Assert.assertTrue(asciiValuePlayer0 <= asciiValuePlayer1 && asciiValuePlayer1 <= asciiValuePlayer2);
    }

    @Test
    void testSortPlayers4() {
        int numPlayers = 4;

        ArrayList<Player> listPlayerInput = Game.sortPlayers(numPlayers);
        int asciiValuePlayer0 = listPlayerInput.get(0).getName().substring(0,1).charAt(0);
        int asciiValuePlayer1 = listPlayerInput.get(1).getName().substring(0,1).charAt(0);
        int asciiValuePlayer2 = listPlayerInput.get(2).getName().substring(0,1).charAt(0);
        int asciiValuePlayer3 = listPlayerInput.get(3).getName().substring(0,1).charAt(0);
        Assert.assertTrue(asciiValuePlayer0 <= asciiValuePlayer1 && asciiValuePlayer1 <= asciiValuePlayer2 && asciiValuePlayer2 <= asciiValuePlayer3);
    }

    @Test
    void testCreateDeck() {
        ArrayList<Card> deckCards = Game.Deck();
        Assert.assertEquals(deckCards.size(), Player.TOTALNUMDICES);
    }

    @Test
    void testGetRandomCard() {
        ArrayList<Card> deckCards = Game.Deck();
        for(int i = 0 ; i< deckCards.size()- 1; i++) {
            deckCards.get(i).setUsed(true);
        }
        Card c = Game.getRandomCard(deckCards);
        Assert.assertEquals(c, deckCards.get(Player.TOTALNUMDICES-1));
    }

    @Test
    void testRestFirstPlayer() {

        ArrayList<Player> listPlayer = Game.sortPlayers(3);
        listPlayer.get(0).setFinalPoints(4000);
        listPlayer.get(1).setFinalPoints(3000);
        listPlayer.get(2).setFinalPoints(2000);

        Game.otherPlayers(listPlayer, listPlayer.get(0));
        Assert.assertEquals(listPlayer.get(0).getFinalPoints(), 4000);
    }

    @Test
    void testRestFirstPlayer2() {

        ArrayList<Player> listPlayer = Game.sortPlayers(3);
        listPlayer.get(0).setFinalPoints(4000);
        listPlayer.get(1).setFinalPoints(3000);
        listPlayer.get(2).setFinalPoints(2000);

        Game.otherPlayers(listPlayer, listPlayer.get(1));
        Assert.assertEquals(listPlayer.get(0).getFinalPoints(), 3000);
    }

    @Test
    void testRestFirstPlayer3() {

        ArrayList<Player> listPlayer = Game.sortPlayers(3);
        listPlayer.get(0).setFinalPoints(4000);
        listPlayer.get(1).setFinalPoints(4000);
        listPlayer.get(2).setFinalPoints(2000);

        Game.otherPlayers(listPlayer, listPlayer.get(2));
        Assert.assertTrue(listPlayer.get(0).getFinalPoints()==3000 && listPlayer.get(1).getFinalPoints()==3000);
    }
}