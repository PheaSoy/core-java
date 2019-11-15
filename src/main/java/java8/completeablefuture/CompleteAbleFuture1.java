package java8.completeablefuture;

import java11.MyHttpClient;
import model.User;
import org.apache.log4j.Logger;
import util.MapUtil;

import java.util.concurrent.CompletableFuture;

public class CompleteAbleFuture1 {

    static Logger logger = Logger.getLogger(CompleteAbleFuture1.class);

    static CompletableFuture<String> fetchTheUser(String githubUsername) {
        logger.info("Fetch user from github");
        CompletableFuture completableFuture = CompletableFuture.completedFuture(MyHttpClient.send(githubUsername));
        return completableFuture;
    }

    static CompletableFuture<User> convertJsonToObject(String githubUsername) {
        logger.info("Convert user from strong to object");
        return fetchTheUser(githubUsername).thenApplyAsync(resultString -> MapUtil.fromJsonString(resultString));
    }


    public static void saveUser(User user) {
        logger.info("Save user:" + user);
    }

    static public CompletableFuture executeUserFromGithub(String githubUser) {
        return convertJsonToObject(githubUser).thenAccept(us -> saveUser(us));
    }

    public static void main(String args[]) {
        executeUserFromGithub("sidarakeo");
    }

}
