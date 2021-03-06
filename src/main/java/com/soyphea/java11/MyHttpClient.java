package com.soyphea.java11;

import com.soyphea.java8.exeption.GithubException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    static Logger logger = LogManager.getLogger(MyHttpClient.class);

    private static HttpClient client = HttpClient.newHttpClient();

    static private URI uri = URI.create("https://api.github.com/users/");

    public static String send(String githubUsername) {

        String response = null;

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri.resolve(githubUsername))
                    .build();
            HttpResponse<String> httpResponse = client.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            logger.info("HttpCode:" + httpResponse.statusCode() + " Http Body:" + httpResponse.body());

            if(httpResponse.statusCode()!=200){
                throw new GithubException("BOOM!");
            }
            response = httpResponse.body();
        } catch (Exception ex) {
            logger.error("Error occurred", ex);
        } finally {
            logger.info("Executed call finished.");
        }

        return response;
    }


    public static String getUserFromGithub(String githubUsername) {

        String response = null;

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri.resolve(githubUsername))
                    .build();
            HttpResponse<String> httpResponse = client.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            logger.info("HttpCode:" + httpResponse.statusCode() + " Http Body:" + httpResponse.body());
            response = httpResponse.body();
        } catch (Exception ex) {
            logger.error("Error occurred", ex);
        } finally {
            logger.info("Executed call finished.");
        }

        return response;
    }

}