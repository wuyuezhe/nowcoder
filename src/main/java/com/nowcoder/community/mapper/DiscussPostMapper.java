package com.nowcoder.community.mapper;

import com.nowcoder.community.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPostByUserId(@Param("userId") Integer userId,
                                                @Param("start")Integer start,
                                                @Param("limit")Integer limit);

    Integer getCountByUserId(@Param("userId")Integer userId);
}
