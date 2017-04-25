package com.hargeliya.controllers;


import com.hargeliya.entities.Theme;
import com.hargeliya.repositories.ThemeOptionRepository;
import com.hargeliya.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemeOptionRepository themeOptionRepository;

    /**
     * List theme
     *
     * @param all show themes
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public ModelAndView index(@RequestParam(required = false, defaultValue = "false") boolean all) {
        return new ModelAndView("theme/index")
                .addObject("all", all)
                .addObject("themes", all
                        ? themeRepository.findAll(new Sort(Sort.Direction.DESC, "createDate"))
                        : themeRepository.findByResolveDateIsNull(new Sort(Sort.Direction.DESC, "createDate")));
    }

    /**
     * Create new theme
     *
     * @param theme
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Theme theme) {
        theme.setCreateDate(new Date());
        theme = themeRepository.save(theme);

        return new ModelAndView("redirect:/theme/" + theme.getId() + "/view");
    }

    /**
     * Show theme
     *
     * @param id identity theme
     * @return
     */
    @RequestMapping("/{id:\\d+}/view")
    public ModelAndView view(@PathVariable long id) {
        Theme theme = themeRepository.findOne(id);

        return new ModelAndView("theme/view")
                .addObject("theme", theme)
                .addObject("themeOption", themeOptionRepository.findByThemeId(id));
    }

    /**
     * Closed theme
     *
     * @param id identity theme
     * @return
     */
    @RequestMapping("/{id:\\d+}/resolve")
    public ModelAndView resolve(@PathVariable long id) {
        themeRepository.resolveTicket(id);

        return new ModelAndView("redirect:/theme/" + id + "/view");
    }

    /**
     * Reopen theme
     *
     * @param id tdentity theme
     * @return
     */
    @RequestMapping("/{id:\\d+}/reopen")
    public ModelAndView reopen(@PathVariable long id) {
        themeRepository.reopenTicket(id);

        return new ModelAndView("redirect:/theme/" + id + "/view");
    }
}
