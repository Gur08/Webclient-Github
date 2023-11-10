package co.learning.webclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    private String login;
    private long id;
    @JsonProperty("avatar_url")
    // to properly map the avatarurl
    private String avatarUrl;
    private String name;
    private String company;
    @JsonProperty("public_repos")
    private String publicRepo;

}
