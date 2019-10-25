# core-java
## Function<T,R>
```
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
## Generic 
```
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
## Java 11 HttpClient
```

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