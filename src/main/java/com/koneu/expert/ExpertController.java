package com.koneu.expert;

import com.koneu.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aaron on 16-7-2.
 */

@Controller
@RequestMapping("/experts")
public class ExpertController extends BaseController {

    @Autowired
    private ExpertService expertService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("expert", new Expert());
        model.addAttribute("listExperts", expertService.getAll());
        return "expert";
    }

    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("expert") Expert p){

        if(p.getId() == null){
            //new person, add it
            this.expertService.insert(p);
        }else{
            //existing person, call update
            this.expertService.update(p);
        }

        return "redirect:/experts";

    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") String id){

        this.expertService.delete(id);
        return "redirect:/experts";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        model.addAttribute("expert", this.expertService.get(id));
        model.addAttribute("listExperts", this.expertService.getAll());
        return "expert";
    }
}
