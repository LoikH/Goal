package com.elh.games.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.elh.games.models.Ball;
import com.elh.games.models.Card;
import com.elh.games.models.CardDefensive;
import com.elh.games.models.CardOffensive;
import com.elh.games.utils.TypeCardDefensive;
import com.elh.games.utils.TypeCardOffensive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by a507762 on 18/09/2015.
 */
public class GameController {

    private List<Card> deck;
    private List<Card> clearDeck;

    private List<Card> deckP1;
    private List<Card> deckP2;
    
    private Ball ball;

    Random randomGenerator = new Random();;

    public GameController() {
        initGame();
        logGame();
    }

    private void initGame(){
        this.deck = initDeck();
        this.clearDeck = new ArrayList<Card>(0);
        this.deckP1 = initDeckPlayer();
        this.deckP2 = initDeckPlayer();
        initBall();
    }

    private void initBall() {
        if(ball==null){
            ball = new Ball(0,0);
        }else{
            ball.setPosX(0);
            ball.setPosY(0);
        }
    }

    private List<Card> initDeckPlayer() {
        ArrayList<Card> deckplayer = new ArrayList<Card>(8);

        for (int i = 0;i<8; i++){
            takeCard(deckplayer);
        }

        return deckplayer;
    }

    private void takeCard(ArrayList<Card> deckplayer) {
        int index = randomGenerator.nextInt(deck.size());
        Card card = deck.get(index);
        deckplayer.add(card);
        deck.remove(card);
        Collections.sort(deckplayer, new Comparator<Card>() {
            public int compare(Card one, Card other) {
                return one.getName().compareTo(other.getName());
            }
        });
    }

    private void removeCard(ArrayList<Card> deckplayer, int index) {
        Card card = deckplayer.get(index);
        clearDeck.add(card);
        deckplayer.remove(card);
        Collections.sort(deckplayer, new Comparator<Card>() {
            public int compare(Card one, Card other) {
                return one.getName().compareTo(other.getName());
            }
        });
    }

    private List<Card> initDeck() {

        ArrayList<Card> deckinit = new ArrayList<Card>(40);

//        create offensiveCard
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,0,4));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,4,0));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,-4,0));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,3,1));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,-3,1));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,1,3));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,-1,3));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,2,2));
        deckinit.add(new CardOffensive("Pass","", TypeCardOffensive.PASS,-2,2));

        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,0,10));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,0,8));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,0,6));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,3,9));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,-3,9));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,4,6));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,-4,6));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,1,7));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,-1,7));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,3,6));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,-3,6));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,-5,5));
        deckinit.add(new CardOffensive("Shoot","", TypeCardOffensive.SHOT,5,5));

        deckinit.add(new CardOffensive("Free Kick","", TypeCardOffensive.FREEKICK,3,3));
        deckinit.add(new CardOffensive("Free Kick","", TypeCardOffensive.FREEKICK,3,3));
        deckinit.add(new CardOffensive("Free Kick","", TypeCardOffensive.FREEKICK,4,4));
        deckinit.add(new CardOffensive("Free Kick","", TypeCardOffensive.FREEKICK,4,4));
        deckinit.add(new CardOffensive("Free Kick","", TypeCardOffensive.FREEKICK,5,5));

        deckinit.add(new CardOffensive("Penalty","", TypeCardOffensive.PENALTY,0,0));
        deckinit.add(new CardOffensive("Penalty","", TypeCardOffensive.PENALTY,0,0));
        deckinit.add(new CardOffensive("Penalty","", TypeCardOffensive.PENALTY,0,0));

//        create defensive card
        deckinit.add(new CardDefensive("GoalKeeper", "", TypeCardDefensive.KEEPER));
        deckinit.add(new CardDefensive("GoalKeeper", "", TypeCardDefensive.KEEPER));
        deckinit.add(new CardDefensive("GoalKeeper", "", TypeCardDefensive.KEEPER));
        deckinit.add(new CardDefensive("GoalKeeper", "", TypeCardDefensive.KEEPER));
        deckinit.add(new CardDefensive("GoalKeeper", "", TypeCardDefensive.KEEPER));

        deckinit.add(new CardDefensive("Corner", "", TypeCardDefensive.CORNER));
        deckinit.add(new CardDefensive("Corner", "", TypeCardDefensive.CORNER));
        deckinit.add(new CardDefensive("Corner", "", TypeCardDefensive.CORNER));
        deckinit.add(new CardDefensive("Corner", "", TypeCardDefensive.CORNER));
        deckinit.add(new CardDefensive("Corner", "", TypeCardDefensive.CORNER));

        Collections.shuffle(deckinit);
        return deckinit;
    }

    private void logGame(){
        Gdx.app.log("GameController", "----------------");

        Gdx.app.log("GameController", "Deck player1 : "+ deckP1.size());
        for (Card card:deckP1){
            if (card instanceof CardOffensive) {
                Gdx.app.log("GameController", card.getName()+ " "+ ((CardOffensive)card).getTranslateX()+"-"+((CardOffensive)card).getTranslateY());
            }else{
                Gdx.app.log("GameController", card.getName());
            }
        }
        Gdx.app.log("GameController", "Deck player2 : "+ deckP2.size());
        for (Card card:deckP2){
            if (card instanceof CardOffensive) {
                Gdx.app.log("GameController", card.getName()+ " "+ ((CardOffensive)card).getTranslateX()+"-"+((CardOffensive)card).getTranslateY());
            }else{
                Gdx.app.log("GameController", card.getName());
            }
        }

        Gdx.app.log("GameController", "Deck principal: "+ deck.size());
        Gdx.app.log("GameController", "----------------");
    }


}
