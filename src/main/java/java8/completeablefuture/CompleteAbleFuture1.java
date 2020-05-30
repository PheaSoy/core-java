package java8.completeablefuture;

import java11.MyHttpClient;
import model.User;
import org.apache.log4j.Logger;
import util.MapUtil;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class CompleteAbleFuture1 {

    static Logger logger = Logger.getLogger(CompleteAbleFuture1.class);

    static CompletableFuture<String> fetchTheUser(String githubUsername) {
        logger.info("Fetch user from github");
        CompletableFuture completableFuture = CompletableFuture.completedFuture(MyHttpClient.send(githubUsername));
        return completableFuture;
    }

    static User convertJsonToObject(String userJsonString) {
        logger.info("Convert user from strong to object");
        return MapUtil.fromJsonString(userJsonString);
    }

    public static void saveUser(User user) {
        Objects.requireNonNull(user);
        logger.info("Saving the user");
    }

    static public void executeUserFromGithub(String githubUser) {
        fetchTheUser(githubUser).thenApplyAsync(str -> convertJsonToObject(str)).thenAcceptAsync(user -> saveUser(user))
                .handle(
                        (res, ex) -> {
                            if (ex != null) {
                                logger.error("Got Error :"+ex.getMessage());
                            }
                            return null;
                        }
                );
    }

    public static void handle(Throwable throwable) {

    }


    public static void main(String args[]) throws Exception {
        executeUserFromGithub("PheaSoy");
        logger.info("Start to sleep...");
        Thread.sleep(5000);


    }

}
