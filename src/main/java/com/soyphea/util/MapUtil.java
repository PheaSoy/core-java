package com.soyphea.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soyphea.model.User;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
public class MapUtil {

    static Logger logger = LogManager.getLogger(MapUtil.class);

    static ObjectMapper objectMapper = new ObjectMapper();

    public static User fromJsonString(String json) {
        User user = null;
        try {
            user = objectMapper.readValue(json, User.class);
        } catch (Exception ex) {
            logger.error("Casts error.", ex);
        }
        return user;
    }
}
