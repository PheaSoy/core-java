package com.soyphea.java8.optional;

import com.soyphea.java11.MyHttpClient;
import com.soyphea.model.User;
import com.soyphea.util.MapUtil;

import java.util.Optional;

public class Optional1 {


        public User getUser(String username) {

        String response = MyHttpClient.getUserFromGithub(username);
        if (response != null) {
            return MapUtil.fromJsonString(response);

        } else throw new NameExceededExample();

    }

    public User getUser2(String username) {
        Optional<String> response = Optional.ofNullable(MyHttpClient.getUserFromGithub(username));
        return response.map(rs -> MapUtil.fromJsonString(rs)).orElseThrow(NameExceededExample::new);
    }
}


class NameExceededExample extends RuntimeException {
    public NameExceededExample() {
    }

    public NameExceededExample(String message) {
        super(message);
    }

}