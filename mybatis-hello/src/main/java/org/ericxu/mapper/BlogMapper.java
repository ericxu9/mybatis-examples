package org.ericxu.mapper;

import org.apache.ibatis.session.ResultHandler;
import org.ericxu.entity.Blog;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectAll();

    void testResultHandlerSelect(ResultHandler<Blog> handler);

    List<Blog> selectBlogDetails(Integer blogId);
}
