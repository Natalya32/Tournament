package ru.netology.javaqa.javaqamvn;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strength1;
        int strength2;
        Player player1 = findByName(playerName1);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName1 + "is not registered"
            );
        } else {
            strength1 = player1.strength;
        }

        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName2 + "is not registered"
            );
        } else {
            strength2 = player2.strength;
        }

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else return 0;
    }

    public Player findByName(String Name) {
        for (Player player : players) {
            if (player.getName().equals(Name)) {
                return player;
            }
        }
        return null;
    }
}
