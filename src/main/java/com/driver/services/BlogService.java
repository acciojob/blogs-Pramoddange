package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        Blog obj = new Blog(title, content);
        User x = userRepository1.findById(userId).get();
        obj.setPubDate(new Date());
        obj.setUser(x);
        List<Blog> arr = x.getBlogList();
        arr.add(obj);
        //x.setBlogList(arr);
        userRepository1.save(x);

        return obj;
        //create a blog at the current time

    }

    public void deleteBlog(int blogId) {

        blogRepository1.deleteById(blogId);

        //delete blog and corresponding images

    }
}