package com.elh.games.models;

import com.elh.games.utils.TypeCardOffensive;

/**
 * Created by a507762 on 18/09/2015.
 */
public class CardOffensive extends Card {

    private TypeCardOffensive type;
    private int translateX;
    private int translateY;

    public CardOffensive(String name, String texture) {
        super(name, texture);
    }

    public CardOffensive(String name, String texture, TypeCardOffensive type, int translateX, int translateY) {
        super(name, texture);
        this.type = type;
        this.translateX = translateX;
        this.translateY = translateY;
    }

    public TypeCardOffensive getType() {
        return type;
    }

    public void setType(TypeCardOffensive type) {
        this.type = type;
    }

    public int getTranslateX() {
        return translateX;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }
}
