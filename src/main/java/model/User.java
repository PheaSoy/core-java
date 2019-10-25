package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@AllArgsConstructor
public class User {

    private String name;
    private String blog;
    private String login;
}