package com.Daza.utils;

import com.Daza.modules.TenJokes;

import java.util.List;

public class JsonSerializer {

    public static String toJsonArray(List<TenJokes> jokes) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < jokes.size(); i++) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append("\n"+"Joke number: " + (i+1));
            sb.append("    ").append(jokes.get(i).toJson().replace("\n", "\n    "));
        }
        sb.append("\n");
        return sb.toString();
    }
}