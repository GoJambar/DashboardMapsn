package com.mapsnDashbaord.controllerDashboard;

import java.util.List;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.repository.IArrondissementRepository;
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
@RequestMapping("/arrondissements")
public class ArrondissementControllerDash {

	@Autowired
	private IArrondissementRepository arrondissementRepository;
	@Autowired
	private LocaliteServiceImpl localiteServiceImpl;

	@GetMapping("/list")
	public String allArrondissement(Model model) {
		
		model.addAttribute("listArrondissement", localiteServiceImpl.findAllArrondissement());
		return "/admin/arrondissement/List-arrondissement";
	}

	@GetMapping("/new")
	public String ShowForm(Arrondissement arrondissement, Model model) {
		List<Departement> departementList = localiteServiceImpl.findAllDepartement();
		model.addAttribute("departementList", departementList);
		return "/admin/arrondissement/Arrondissement-form";
	}

	@PostMapping("/save")
	public String proceedForm(@ModelAttribute Arrondissement arrondissement, Model model) {
		
		localiteServiceImpl.saveArrondissement(arrondissement);
		return "redirect:/arrondissements/list";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		
		List<Departement> departementList = localiteServiceImpl.findAllDepartement();
		model.addAttribute("departementList", departementList);
		
		Arrondissement arrondissement = arrondissementRepository.findById(id).get();
		model.addAttribute("arrondissement", arrondissement);
		return "/admin/arrondissement/Arrondissement-edit";
	}

	@PostMapping("/update/{id}")
	public String updateArrondissement(@PathVariable("id") Long id, @Validated Arrondissement arrondissement) {
		localiteServiceImpl.saveArrondissement(arrondissement);
		return "redirect:/arrondissements/list";
	}
 
	
	@GetMapping("/delete/{id}")
	public String deleteArrondissement(@PathVariable("id") Long id) {
		arrondissementRepository.deleteById(id);
		return "redirect:/arrondissements/list";
	}

}
