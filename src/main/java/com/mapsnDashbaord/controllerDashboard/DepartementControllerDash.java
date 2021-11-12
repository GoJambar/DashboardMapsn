package com.mapsnDashbaord.controllerDashboard;

import java.util.List;

import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.model.Region;
import com.mapsnDashbaord.repository.DepRepository;
import com.mapsnDashbaord.service.LocaliteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/departements")
public class DepartementControllerDash {

	@Autowired
	private DepRepository depRepository;
	@Autowired
	private LocaliteServiceImpl localiteServiceImpl;

	@GetMapping("/list")
	public String allDepartement(Model model) {
		List<Region> regionList = localiteServiceImpl.findAllRegion();
		model.addAttribute("regionList", regionList);
		model.addAttribute("listDepartement", localiteServiceImpl.findAllDepartement());
		return "/admin/departement/List-departement";
	}

	@GetMapping("/new")
	public String ShowForm(Departement departement, Model model) {
		List<Region> regionList = localiteServiceImpl.findAllRegion();
		model.addAttribute("regionList", regionList);
		return "/admin/departement/Departement-form";
	}

	@PostMapping("/save")
	public String proceedForm(@ModelAttribute Departement departement, Model model) {
		
		localiteServiceImpl.saveDepartemnt(departement);
		return "redirect:/departements/list";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		
		List<Region> regionList = localiteServiceImpl.findAllRegion();
		model.addAttribute("regionList", regionList);
		
		Departement departement = depRepository.findById(id).get();
		model.addAttribute("departement", departement);
		return "/admin/departement/Departement-edit";
	}

	@PostMapping("/update/{id}")
	public String updateDepartement(@PathVariable("id") Long id, @Validated Departement departement) {
		localiteServiceImpl.saveDepartemnt(departement);
		return "redirect:/departements/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteDepartement(@PathVariable("id") Long id) {
		depRepository.deleteById(id);
		return "redirect:/departements/list";
	}

}
