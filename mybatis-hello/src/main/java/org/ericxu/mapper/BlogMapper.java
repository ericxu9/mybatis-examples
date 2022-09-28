package org.ericxu.mapper;

import org.ericxu.entity.Blog;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectAll();
}
