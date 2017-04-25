package com.hargeliya.controllers;


import com.hargeliya.entities.ThemeOption;
import com.hargeliya.repositories.ThemeOptionRepository;
import com.hargeliya.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/theme/{id:\\d+}/options")
public class ThemeOptionController {

    @Autowired
    private ThemeOptionRepository themeOptionRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@PathVariable long id, @ModelAttribute ThemeOption themeOption) {
        themeOption.setTheme(themeRepository.findOne(id));
        themeOptionRepository.save(themeOption);
        return new ModelAndView("redirect:/theme/" + id + "/view");
    }
}
