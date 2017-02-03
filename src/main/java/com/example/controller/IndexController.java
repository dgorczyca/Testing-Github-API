package com.example.controller;

import com.example.domain.Repository;
import com.example.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dg on 31/01/2017.
 */
@Controller
public class IndexController {

    @Autowired
    RepositoryService repositoryService;

    @RequestMapping("/index")
    public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Test") String name) {
        model.addAttribute("name",name);
        return "index";
    }

    @ModelAttribute("repositories")
    public List<Repository> populateSeedStarters() {
        return repositoryService.getAllReposiotories();
    }
}