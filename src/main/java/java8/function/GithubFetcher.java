package java8.function;

import model.User;
import org.apache.log4j.Logger;
import util.MapUtil;
import java11.MyHttpClient;

import java.util.function.Function;

public class GithubFetcher {

    private static org.apache.log4j.Logger logger = Logger.getLogger(GithubFetcher.class);

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
