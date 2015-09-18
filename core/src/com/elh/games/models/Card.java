package com.elh.games.models;

/**
 * Created by a507762 on 18/09/2015.
 */
public class Card {

    private String name;
    private String texture;

    public Card(String name, String texture) {
        this.name = name;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
