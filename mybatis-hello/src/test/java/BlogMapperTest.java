import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ericxu.entity.Blog;
import org.ericxu.mapper.BlogMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BlogMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectList() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<Blog> blogs = sqlSession.selectList("org.ericxu.mapper.BlogMapper.selectAll");
            System.out.println(blogs);
        }
    }

    @Test
    public void testSelectList2 () {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<Blog> blogs = sqlSession.getMapper(BlogMapper.class).selectAll();
            System.out.println(blogs);
        }
    }
}
