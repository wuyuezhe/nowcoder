package com.nowcoder.community.controller;

import com.nowcoder.community.pojo.DiscussPost;
import com.nowcoder.community.pojo.Page;
import com.nowcoder.community.pojo.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String index(Model model, Page page){
        page.setTotalCount(discussPostService.getDiscussPostCount(0));
        page.setUrl("/index");

        List<DiscussPost> discussPosts = discussPostService.getDiscussPost(0, page.getStart(),
                page.getLimit());
        List<Map<String,Object>> list=new ArrayList<>();
        if (discussPosts.size()!=0){
            for (DiscussPost discussPost:discussPosts){
                Map<String,Object> map=new HashMap<>();
                User user = userService.getUserById(discussPost.getUserId());
                map.put("user",user);
                map.put("post",discussPost);
                list.add(map);
            }
        }
        model.addAttribute("discussPost",list);
        return "/index";
    }
}
