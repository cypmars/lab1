package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by User on 15/03/2017.
 */
@Controller
public class PostController {

    @Autowired
    private PublicationService publicationService;


    @RequestMapping(value = "/share",method = RequestMethod.POST)
    public String saveMessage(Post post) {
        System.out.println("share"+post);
        publicationService.post(post);
        return "redirect:/feed";
    }


    @RequestMapping(value = "/feed",method = RequestMethod.GET)
    public String showFeeds(Model model) {
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts", posts);
        return "feed";
    }

}
