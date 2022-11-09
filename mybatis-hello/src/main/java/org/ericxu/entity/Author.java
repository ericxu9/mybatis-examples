package org.ericxu.entity;

public class Author {

    private Integer authorId;
    private String username;
    private String password;
    private String email;

    public Author() {
    }

    public Author(Integer authorId, String username, String password, String email) {
        this.authorId = authorId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
