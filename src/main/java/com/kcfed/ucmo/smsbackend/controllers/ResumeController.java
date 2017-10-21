package com.kcfed.ucmo.smsbackend.controllers;

import com.kcfed.ucmo.smsbackend.models.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    private Resume resume;

    @RequestMapping(method = RequestMethod.GET)
    public String resumeForm(Model model) {
        if (resume == null)
            model.addAttribute("resume", new Resume());
        else
            model.addAttribute("resume", resume);

        return "resumeFromTemplate";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String helloTwitter(@ModelAttribute("resume") Resume resume, Model model) {

        if (resume.getName().equals("")) {
            resume.setName("Allen Anthes");
            resume.setAddress("418 Swallow St");
            resume.setPhone("(904)451-7620");
            resume.setEmail("abanthes@gmail.com");
            resume.setLinkedIn("linkedin/in/Allen-Anthes");
            resume.setRepository("github.com/AllenAnthes");

            resume.setPosition("Intelligence Analyst");
            resume.setCompany("National Security Agency");
            resume.setStartDate("Oct 2013");
            resume.setEndDate("Aug 2016");

            resume.setUniversity("University of Central Missouri");
            resume.setProgram("Bachelor of Science");
            resume.setDegree("Computer Science");
        }
        this.resume = resume;
        model.addAttribute("resume", resume);

        return "resumeFromTemplate";
    }
}
