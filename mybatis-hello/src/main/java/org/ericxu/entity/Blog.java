package org.ericxu.entity;

import java.util.List;

public class Blog {

    public static String staticField = "fff";

    private Integer blogId;
    private String title;
    private Integer authorId;
    private List<Author> author;
    private List<Post> posts;


    public Blog() {
    }


    public Blog(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", author=" + author +
                ", posts=" + posts +
                '}';
    }
}
