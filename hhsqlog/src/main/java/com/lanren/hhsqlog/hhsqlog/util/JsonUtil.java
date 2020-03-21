package com.lanren.hhsqlog.hhsqlog.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    public final static boolean isJSONValid2(String jsonInString ) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
