package com.nowcoder.community.service;

import com.nowcoder.community.mapper.DiscussPostMapper;
import com.nowcoder.community.mapper.UserMapper;
import com.nowcoder.community.pojo.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    DiscussPostMapper discussPostMapper;


    public List<DiscussPost> getDiscussPost(int userId, int start, int limit) {
        return discussPostMapper.selectDiscussPostByUserId(userId, start, limit);
    }

    public Integer getDiscussPostCount(int userId) {
        return discussPostMapper.getCountByUserId(userId);
    }
}
