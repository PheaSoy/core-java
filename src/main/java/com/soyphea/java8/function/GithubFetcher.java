package com.soyphea.java8.function;

import com.soyphea.java11.MyHttpClient;
import com.soyphea.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.soyphea.util.MapUtil;

import java.util.function.Function;

public class GithubFetcher {

    public static Logger logger = LogManager.getLogger(GithubFetcher.class);

    public static Function<String, String> fetchUserAsString() {
        Function<String, String> jsonString = (gu) -> MyHttpClient.send(gu);
        return jsonString;
    }

    public static Function<String,User> convertStringToObject() {
        Function<String, User> result = fetchUserAsString().andThen(js -> MapUtil.fromJsonString(js));
        return result;
    }

    public static User getUser(String githubUser){
        User resultUser = convertStringToObject().apply(githubUser);
        logger.info("Convert result:"+resultUser);
        return  resultUser;
    }


    public static void main(String args[]) {
        getUser("sidarakeo");
    }
}
