package com.elh.games.models;

import com.elh.games.utils.TypeCardDefensive;

/**
 * Created by a507762 on 18/09/2015.
 */
public class CardDefensive extends Card {

    private TypeCardDefensive type;

    public CardDefensive(String name, String texture) {
        super(name, texture);
    }

    public CardDefensive(String name, String texture, TypeCardDefensive type) {
        super(name, texture);
        this.type = type;
    }

    public TypeCardDefensive getType() {
        return type;
    }

    public void setType(TypeCardDefensive type) {
        this.type = type;
    }
}
