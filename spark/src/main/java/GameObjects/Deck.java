package GameObjects;

import Cards.*;
import java.util.*;

public class Deck{
    Stack<CardObject> deck = new Stack<CardObject>();
    Game currentGame;

    public Deck standard(){
        deck.removeAllElements();
        addNewCard("negate", 5);
        addNewCard("attack", 4);
        addNewCard("skip", 4);
        addNewCard("favor", 4);
        addNewCard("shuffle", 4);
        addNewCard("seethefuture", 5);
        return this;
    }

    public void addCard(CardObject card){
        deck.add(card);
    }

    public void addNewCard(String cardName, int num){
        for (int i = 0; i < num; i++){
            deck.add(CardFactory.makeCard(cardName));
        }
    }

    public CardObject draw(){
        CardObject card = deck.pop();
        card.onDraw(currentGame);

        return card;
    }

    public String peek(int num){
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 0; i < num; i++){
            s.add(deck.peek().name);
        }

        String str = String.join(", ", s);
        return str;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}