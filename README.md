# Core Java Blocks

## Function<T,R> 
```java
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
```
## Generic Type 
```java
    public static <T> boolean compareObject( T t1, T t2){
        return t1.equals(t2);
    }

    public static <T extends Number> boolean compareNumber( T t1, T t2){
        return t1.equals(t2);
    }

    public static void main(String args[]){

        Assert.isTrue(compareObject(1,"2")); // Allow input String because there are no bound

        Assert.isTrue(compareNumber(1,1));// Not allow input String because there are bound T extends Number
    }
  ```
  ## Builder Pattern
  ```
      public static void main(String args[]){
        BankAccount bankAccount = new BankAccount.Builder(100L)
                .accountName("Phea Soy")
                .build();
        System.out.println("Bank account:"+bankAccount);
    }
}
```

## CompletableFuture Async
```java

public class CompleteAbleFuture1 {

    private static Logger logger = LogManager.getLogger(CompleteAbleFuture1.class);

    static CompletableFuture<String> fetchTheUser(String githubUsername) {
        logger.info("Fetch user from github");
        CompletableFuture completableFuture = CompletableFuture.completedFuture(MyHttpClient.send(githubUsername));
        return completableFuture;
    }

    static User convertJsonToObject(String userJsonString) {
        logger.info("Convert user from strong to com.soyphea.object");
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

    public static void main(String args[]) throws Exception {
        executeUserFromGithub("PheaSoy");
        logger.info("Start to sleep...");
        Thread.sleep(5000);
    }

}
```
## Http Client on Java11
```java

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
```

