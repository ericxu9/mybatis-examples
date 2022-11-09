package ognl;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.ericxu.entity.Author;
import org.ericxu.entity.Blog;
import org.ericxu.entity.Post;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OgnlTest {

    private static Blog blog;
    private static Author author;
    private static List<Post> posts;
    private static OgnlContext context;

    @Before
    public void start() {
        author = new Author(1, "tom", "123456", "email");
        Post post = new Post();
        post.setContent("postContent");
        posts = new ArrayList<>();
        posts.add(post);

        blog = new Blog(1);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        blog.setAuthor(authors);
        blog.setPosts(posts);


        // 将 blog 设置为 root
        context = new OgnlContext();
        context.put("blog", blog);
        context.setRoot(blog);
    }

    @Test
    public void test1() throws OgnlException {
        Author author2 = new Author(2, "username2", "password2", "email2");
        context.put("author", author2);

        // blog 的author属性
        Object obj = Ognl.getValue(Ognl.parseExpression("author"), context, context.getRoot());
        System.out.println(obj); // [Author{authorId=1, username='tom', password='123456', email='email'}]

        obj = Ognl.getValue(Ognl.parseExpression("author[0].username"), context, context.getRoot());
        System.out.println(obj); // tom

        // #author 表示需要操作的对象不是root，而是OgnlContext中 key 为 author的对象
        obj = Ognl.getValue(Ognl.parseExpression("#author.username"), context, context.getRoot());
        System.out.println(obj); // username2

    }

    @Test
    public void test2() throws OgnlException {
        Object obj = Ognl.getValue(Ognl.parseExpression("author[0].getEmail()"), context, context.getRoot());
        System.out.println(obj); // email

        // 静态变量
        obj = Ognl.getValue(Ognl.parseExpression("@org.ericxu.entity.Blog@staticField"), context, context.getRoot());
        System.out.println(obj); // fff
    }
}
