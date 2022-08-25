package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.entity.Specialization;
import com.main.service.ISpecializationService;

@Controller
@RequestMapping("/specialization")
public class SpecializationController {

	@Autowired
	private ISpecializationService specializationService;

	@GetMapping("/register")
	public String showRegisterPage() {
		return "specializationRegister";
	}

	@PostMapping("/save")
	public String addSpecialization(Specialization specialization, Model model) {

		Specialization specialization2 = specializationService.addSpecialization(specialization);
		String message = "Record created with (" + specialization2.getSpecId() + " )";
		model.addAttribute("message", message);
		return "specializationRegister";
	}

	@GetMapping("/all")
	public String getDetails(Model model,
			@RequestParam(required = false, value = "message") String message) {

		List<Specialization> list = specializationService.getAllDetails();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "specializationData";
	}

	@GetMapping("/delete")
	public String removeSpecialization(@RequestParam Integer id, RedirectAttributes attributes) {
		specializationService.remove(id);
		attributes.addAttribute("message", "specialization deleted with (" + id + " )");
		return "redirect:all";
	}

	@GetMapping("/checkout")
	public @ResponseBody String isFielsExists(@RequestParam String code) {
		String message = "";
		if (specializationService.isExistsSpecialization(code)) {
			message = code + " already exists";
		}
		return message;
	}

}
