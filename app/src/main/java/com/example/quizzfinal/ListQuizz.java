package com.example.quizzfinal;

import java.util.ArrayList;
import java.util.Arrays;

public class ListQuizz {
    private int resourceId;
    private String name;

    public ListQuizz(int resourceId, String name) {
        this.resourceId = resourceId;
        this.name = name;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }
}
