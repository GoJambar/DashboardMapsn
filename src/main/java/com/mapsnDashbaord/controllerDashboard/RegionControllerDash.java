package com.mapsnDashbaord.controllerDashboard;

import com.mapsnDashbaord.model.Region;
import com.mapsnDashbaord.repository.IRegionRepository;
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
@RequestMapping("/regions")
public class RegionControllerDash {

	@Autowired
	private IRegionRepository iRegionRepository;
	@Autowired
	private LocaliteServiceImpl localiteServiceImpl;
	
	@GetMapping("/list")
	public String allRegion(Model model)
	{
		model.addAttribute("listRegion", localiteServiceImpl.findAllRegion());
		return "admin/region/Region-list";
	}

	@GetMapping("/new")
	public String ShowForm(Region region)
	{
		return "admin/region/Region-form";
	}

	@PostMapping("/save")
	public String proceedForm(@ModelAttribute Region region ,Model model)
	{  
		localiteServiceImpl.saveRegion(region) ;
		return "redirect:/regions/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model)
	{
		Region region = localiteServiceImpl.getRegionById(id);
				
		model.addAttribute("region", region);
		return "admin/region/Region-edit";
	}
	
	
	@PostMapping("/update/{id}")
	public String updateRegion(@Validated Region region ,Model mode,@PathVariable("id") Long id)
	{
		//region = localiteServiceImpl.getRegionById(id);
		//region.setId(id);
		localiteServiceImpl.saveRegion(region);
		return "redirect:/regions/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRegion(@PathVariable("id") Long id)
	{
		localiteServiceImpl.deletRegion(id);
		return "redirect:/regions/list";
	}
	
}



