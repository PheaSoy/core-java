package java11;

import org.apache.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    static Logger logger = Logger.getLogger(MyHttpClient.class);

    private static HttpClient client = HttpClient.newHttpClient();

    static private URI uri = URI.create("https://api.github.com/users/");

    public static String send(String githubUsername) {
        HttpResponse<String> httpResponse = null;
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri.resolve(githubUsername))
                    .build();
            httpResponse = client.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            logger.info("HttpCode:" + httpResponse.statusCode() + " Http Body:" + httpResponse.body());
        } catch (Exception ex) {
            logger.error("Error occurred", ex);
        } finally {
            logger.info("Executed call finished.");
        }

        return httpResponse.body();
    }

}
