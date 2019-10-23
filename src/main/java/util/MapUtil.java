package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.apache.log4j.Logger;

public class MapUtil {

    static Logger logger = Logger.getLogger(MapUtil.class);

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
