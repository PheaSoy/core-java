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
