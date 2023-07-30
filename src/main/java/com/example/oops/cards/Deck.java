package com.example.oops.cards;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Deck {

    private static List<Card> cards = buildCards().get();

    public static void main(String[] args) {

        cards.forEach(System.out::println);
        System.out.println(cards.size());

        System.out.println(new Deck().checkRank(cards.get(1), cards.get(5)));
        Collections.shuffle(cards);
        System.out.println(new Deck().sortCards(cards));

    }

    private Card checkRank(Card card1, Card card2) {
        return card1.getRanks().compareTo(card2.getRanks()) < 0 ? card1 : card2;
    }

    private List<Card> sortCards(List<Card> cards) {
        return cards.stream().sorted(Comparator.comparing(Card::getSuits).thenComparing(Card::getRanks)).collect(Collectors.toList());
    }

    @PostConstruct
    private static Supplier<List<Card>> buildCards() {
        List<Card> cards = new ArrayList<>();
        return () -> {
          for (Suits suits : Suits.values()) {
              for (Rank rank: Rank.values()) {
                  cards.add(new Card(suits, rank));
              }
          }
          return cards;
        };
    }
}
