package ru.netology.javaqa.javaqamvn;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strength1 = 0;
        int strength2 = 0;
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player " + playerName1 + "is not registered"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player " + playerName2 + "is not registered"
            );
        }

        for (Player player : players) {
            if (player.getName() == playerName1) {
                strength1 = player.getStrength();
            }
            if (player.getName() == playerName2) {
                strength2 = player.getStrength();
            }
        }

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else return 0;
    }

    public Player findByName(String Name) {
        for (Player player : players) {
            if (player.getName() == Name) {
                return player;
            }
        }
        return null;
    }
}
