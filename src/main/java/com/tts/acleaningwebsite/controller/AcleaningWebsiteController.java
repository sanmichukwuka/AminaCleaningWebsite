package com.tts.acleaningwebsite.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tts.acleaningwebsite.model.Scheduler;
import com.tts.acleaningwebsite.repository.ACleaningWebsiteRepository;



@Controller
public class AcleaningWebsiteController {
	@Autowired
	private ACleaningWebsiteRepository aCleaningRepository;
	
	@GetMapping(value="/index")
	public String getindex() {
		return "scheduler/index";
	}
	
	@GetMapping(value="/services")
	public String getServices() {
		return "scheduler/services";
	}
	
	@GetMapping(value="/aboutus")
	public String getInfo() {
		return "scheduler/aboutus";
	}
	
	@GetMapping(value="/")
	public String index(Scheduler scheduler) {
		return "scheduler/contactus";
	}
	
	@GetMapping(value="/contactus")
	public String index(Scheduler scheduler, Model model) {
		Iterable<Scheduler> schedulers = aCleaningRepository.findAll();
		model.addAttribute("schedulers", schedulers);
		return "scheduler/contactus";
	}
	
	@GetMapping(value = "/scheduler/{schedulerId}")
	public String showById(@PathVariable("schedulerId") Long schedulerId, Model model) {
		Optional<Scheduler> optionScheduler = aCleaningRepository.findById(schedulerId);
		Scheduler schedulerFound = optionScheduler.get();
		model.addAttribute("scheduler", schedulerFound);
		return "scheduler/show";
	}
	
	@GetMapping(value="/scheduler/new")	
	public String getNewSchedulerForm(Model model) {
		model.addAttribute("scheduler", new Scheduler());
		return "scheduler/show";
	}
	
	@PostMapping(value="/scheduler/new")
	public String createNewForm(Scheduler scheduler, Model model) {
		aCleaningRepository.save(scheduler);
		model.addAttribute("scheduler", scheduler);
		return "scheduler/show";
	}
	
	@GetMapping(value="/schedulers/{schedulerId}/edit")
	public String getEditForm(@PathVariable("schedulerId") Long schedulerId, Model model) {
		Optional<Scheduler> optionScheduler = aCleaningRepository.findById(schedulerId);
		Scheduler schedulerFound = optionScheduler.get();
		model.addAttribute("scheduler", schedulerFound);
		return "scheduler/edit";
	}
	
	@PostMapping(value="/schedulers/{schedulerId}/edit")
	public String updateScheduler(@PathVariable("schedulerId") Long schedulerId, Scheduler scheduler, Model model) {
		Optional<Scheduler> optionScheduler = aCleaningRepository.findById(schedulerId);
		Scheduler updateScheduler = optionScheduler.get();
		updateScheduler.setFirstName(scheduler.getFirstName());
		updateScheduler.setLastName(scheduler.getLastName());
		updateScheduler.setContactTel(scheduler.getContactTel());
		updateScheduler.setAreaCode(scheduler.getAreaCode());
		updateScheduler.setEmail(scheduler.getEmail());
		updateScheduler.setPrefferedContactMethod(scheduler.getPrefferedContactMethod());
		updateScheduler.setMayWeContactYou(scheduler.isMayWeContactYou());
		updateScheduler.setAdditionalInformation(scheduler.getAdditionalInformation());
		aCleaningRepository.save(updateScheduler);
		model.addAttribute("scheduler", updateScheduler);
		return "scheduler/show";
		
	}
	
//	@PostMapping(value="/")
//	public String addNewScheduler(Scheduler scheduler, Model model) {
//		Scheduler newScheduler = new Scheduler(scheduler.getFirstName(), scheduler.getLastName(), scheduler.getContactTel(), 
//		scheduler.getAreaCode(), scheduler.getEmail(), scheduler.getPrefferedContactMethod(), 
//		scheduler.isMayWeContactYou(), scheduler.getAdditionalInformation());
//		aCleaningRepository.save(newScheduler);
//		model.addAttribute("id", scheduler.getId());
//		model.addAttribute("firstName", scheduler.getFirstName());
//		model.addAttribute("lastName", scheduler.getLastName());
//		model.addAttribute("contactTel", scheduler.getContactTel());
//		model.addAttribute("areaCode", scheduler.getAreaCode());
//		model.addAttribute("email", scheduler.getEmail());
//		model.addAttribute("prefferedContactMethod", scheduler.getPrefferedContactMethod());
//		model.addAttribute("mayWeContactYou", scheduler.isMayWeContactYou());
//		model.addAttribute("additionalInformation", scheduler.getAdditionalInformation());
//		model.addAttribute("scheduledDate", scheduler.getScheduledDate());
//		
//		
//		return "scheduler/show";
//	}
//	
//	@GetMapping(value="/scheduler")
//	  public String allSchedulers(Model model) {
//	    Iterable<Scheduler> schedulers = aCleaningRepository.findAll();
//	    model.addAttribute("schedulers", schedulers);
//	    return "scheduler/schedulerlists";
//	  }
	
	@RequestMapping(value = "/schedulers/{schedulerId}/delete", method= RequestMethod.GET) 
	public String deleteScheduler(@PathVariable("schedulerId") Long schedulerId) {
		aCleaningRepository.deleteById(schedulerId);
		return "redirect:/schedulers";
	}
}
