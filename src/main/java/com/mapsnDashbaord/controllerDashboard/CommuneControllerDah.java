package com.mapsnDashbaord.controllerDashboard;

import java.util.List;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Commun;
import com.mapsnDashbaord.repository.ICommunRepository;
import com.mapsnDashbaord.service.LocaliteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/communes")
public class CommuneControllerDah {

	@Autowired
	private ICommunRepository communRepository;
	@Autowired
	private LocaliteServiceImpl localiteServiceImpl;
	
	@GetMapping("/list")
	public String allCommun(Model model) {
		List<Arrondissement> arrondissementList = localiteServiceImpl.findAllArrondissement();
		model.addAttribute("arrondissementList", arrondissementList);
		model.addAttribute("listCommun", localiteServiceImpl.findAllCommun());
		return "/admin/commun/List-commune";
	}

	@GetMapping("/new")
	public String ShowForm(Commun commun, Model model) {
		List<Arrondissement> arrondissementList = localiteServiceImpl.findAllArrondissement();
		model.addAttribute("arrondissementList", arrondissementList);
		return "/admin/commun/Commune-form";
	}

	@PostMapping("/save")
	public String proceedForm(@ModelAttribute Commun commun, Model model) {
		
		localiteServiceImpl.saveCommun(commun);
		return "redirect:/communes/list";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		
		List<Arrondissement> arrondissementList = localiteServiceImpl.findAllArrondissement();
		model.addAttribute("arrondissementList", arrondissementList);
		
		Commun commun = communRepository.findById(id).get();
		model.addAttribute("commun", commun);
		return "/admin/commun/Commune-edit";
	}

	@PostMapping("/update/{id}")
	public String updateCommun(@PathVariable("id") Long id, @Validated Commun commun) {
		localiteServiceImpl.saveCommun(commun);
		return "redirect:/communes/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteCommun(@PathVariable("id") Long id) {
		communRepository.deleteById(id);
		return "redirect:/communes/list";
	}
	
}



