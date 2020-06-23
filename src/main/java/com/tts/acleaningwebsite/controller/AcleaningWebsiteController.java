package com.tts.acleaningwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.acleaningwebsite.model.Scheduler;
import com.tts.acleaningwebsite.repository.ACleaningWebsiteRepository;



@Controller
public class AcleaningWebsiteController {
	@Autowired
	private ACleaningWebsiteRepository aCleaningRepository;
	@GetMapping(value="/")
	public String index(Scheduler scheduler) {
		return "scheduler/contactus";
	}
		
	
	@PostMapping(value="/")
	public String addNewScheduler(Scheduler scheduler, Model model) {
		Scheduler newScheduler = new Scheduler(scheduler.getFirstName(), scheduler.getLastName(), scheduler.getContactTel(), 
		scheduler.getAreaCode(), scheduler.getEmail(), scheduler.getPrefferedContactMethod(), 
		scheduler.isMayWeContactYou(), scheduler.getAdditionalInformation());
		aCleaningRepository.save(newScheduler);
		model.addAttribute("id", scheduler.getId());
		model.addAttribute("firstName", scheduler.getFirstName());
		model.addAttribute("lastName", scheduler.getLastName());
		model.addAttribute("contactTel", scheduler.getContactTel());
		model.addAttribute("areaCode", scheduler.getAreaCode());
		model.addAttribute("email", scheduler.getEmail());
		model.addAttribute("prefferedContactMethod", scheduler.getPrefferedContactMethod());
		model.addAttribute("mayWeContactYou", scheduler.isMayWeContactYou());
		model.addAttribute("additionalInformation", scheduler.getAdditionalInformation());
		model.addAttribute("scheduledDate", scheduler.getScheduledDate());
		
		
		return "scheduler/show";
	}
	
	@GetMapping(value="/scheduler")
	  public String allSchedulers(Model model) {
	    Iterable<Scheduler> schedulers = aCleaningRepository.findAll();
	    model.addAttribute("schedulers", schedulers);
	    return "scheduler/schedulerlists";
	  }
}
