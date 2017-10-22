package com.kcfed.ucmo.smsbackend.controllers;

import com.kcfed.ucmo.smsbackend.models.Resume;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/facebookfeed")
public class FacebookController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private String[] words = {"next", "birthday", "drinks", "heavens to betsy", "darn", "dag nabbit", "drank", "drunk", "wasted" };

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String facebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/";
        }
        String [] fields = { "id","name","birthday","email","location","hometown","gender","first_name","last_name"};
        User user = facebook.fetchObject("me", User.class, fields);
        String name = user.getName();
        String birthday = user.getBirthday();
        String email = user.getEmail();
        String gender = user.getGender();
        String firstname = user.getFirstName();
        String lastname = user.getLastName();
        model.addAttribute("name",name );
        model.addAttribute("birthday",birthday );
        model.addAttribute("email",email );
        model.addAttribute("gender",gender);
        model.addAttribute("firstname",firstname);
        model.addAttribute("lastname",lastname);
        model.addAttribute("facebookProfile", facebook.fetchObject("me", User.class, fields));

        List<Post> posts = facebook
                .feedOperations()
                .getFeed()
                .stream()
                .filter(this::checkWords)
                .collect(Collectors.toList());

        PagedList<Post> testPosts = facebook.feedOperations().getFeed();

        model.addAttribute("feed", testPosts);
        model.addAttribute("resume", new Resume());
        return "facebook";
    }

    private boolean checkWords(Post post) {

        if (post.getMessage() != null) {
            String message = post.getMessage().toLowerCase();
            for (String word : words) {
                if (message.contains(word))
                    return true;
            }
        }
        if (post.getCaption() != null) {
            String caption = post.getCaption().toLowerCase();
            for (String word : words) {
                if (caption.contains(word))
                    return true;
            }
        }
        return false;
    }
}
