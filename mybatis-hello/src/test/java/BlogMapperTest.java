import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
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

    // 当查询数据量过大时可能出现OOM，ResultHandler就会很好的解决这个问题，没查询一条数据就会调用一次 handleResult()
    @Test
    public void testResultHandler () {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ResultHandler<Blog> resultHandler = new ResultHandler<Blog>() {
                @Override
                public void handleResult(ResultContext<? extends Blog> resultContext) {
                    System.out.println(resultContext.getResultObject());
                }
            };
            sqlSession.getMapper(BlogMapper.class).testResultHandlerSelect(resultHandler);
        }
    }

    @Test
    public void testSelectBlogDetails() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            List<Blog> blogs = sqlSession.getMapper(BlogMapper.class).selectBlogDetails(100);
            System.out.println(blogs);
        }
    }
}
