package com.simulation.entity;

public class Game {
    private CategoryGame categoryGame;
    private int gameID;
    private int categoryID;
    private String name;

    public CategoryGame getCategoryGame() {
        return categoryGame;
    }

    public void setCategoryGame(CategoryGame categoryGame) {
        this.categoryGame = categoryGame;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
