package com.nowcoder.community;

import com.nowcoder.community.mapper.DiscussPostMapper;
import com.nowcoder.community.pojo.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = CommnuityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    void testDiscussPostMapper(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPostByUserId(0, 0, 5);
        list.forEach(System.out::println);
        System.out.println(discussPostMapper.getCountByUserId(0));
    }





}
