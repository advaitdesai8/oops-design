package com.example.oops.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Card {

    private Suits suits;
    private Rank ranks;
}
