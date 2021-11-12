package com.mapsnDashbaord.controllerDashboard;//package com.mapsn.dashboard;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.mapsn.model.Region;
//import com.mapsn.repository.IRegionRepository;
//import com.mapsn.service.impl.LocaliteServiceImpl;
//import com.mapsn.serviceDashboard.impl.RegionService;
//
//@Controller
//@RequestMapping("/produit")
//public class RegionControllerTest {
//
//	@Autowired
//	private IRegionRepository iRegionRepository;
//	@Autowired
//	private LocaliteServiceImpl localiteServiceImpl;
//
//	private String add_edit_template = "/product/add-edit-product";
//	private String edit_template = "/product/edit-product";
//	private String list_template = "/product/list-product";
//	private String list_redirect = "redirect:/produit/list";
//
//	@GetMapping("/add")
//	public String addRegion(Region region, Model model) {
//
//		model.addAttribute("region", region);
////        List<RegionType> RegionTypes = RegionTypeService.listAll();
////        model.addAttribute("RegionTypes",RegionTypes);
////
//		return add_edit_template;
//	}
//
//	@GetMapping("/edit/{id}")
//	public String editRegion(@PathVariable("id") long id, Model model) {
//		Region Region = iRegionRepository.getById(id);
//		model.addAttribute("region", Region);
//
////        List<RegionType> RegionTypes = RegionTypeService.listAll();
////        model.addAttribute("RegionTypes",RegionTypes);
//
//		return edit_template;
//	}
//
//	@PostMapping("/save")
//	public String saveRegion(@Validated @ModelAttribute("Region") Region region, BindingResult result, Model model) {
//		model.addAttribute("region", region);
////        List<RegionType> RegionTypes = RegionTypeService.listAll();
////        model.addAttribute("RegionTypes",RegionTypes);
//
//		if (result.hasErrors()) {
//			return add_edit_template;
//		}
//
//		localiteServiceImpl.saveRegion(region);
//		return list_redirect + "?success";
//	}
//
//	@PostMapping("/update/{id}")
//	public String updateRegion(@Validated Region region ,Model mode,@PathVariable("id") Long id)
//	{
//		localiteServiceImpl.saveRegion(region);
//
//		return list_redirect + "?success";
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deleteRegion(@PathVariable("id") long id, Model model) {
//		localiteServiceImpl.deletRegion(id);
//
//		return list_redirect + "?deleted";
//	}
//
//	@GetMapping("/list")
//	public String listRegion(Model model) {
////        List<RegionType> RegionTypes = RegionTypeService.listAll();
////        model.addAttribute("RegionTypes",RegionTypes);
//
//		List<Region> listRegions = localiteServiceImpl.findAllRegion();
//		model.addAttribute("listRegions", listRegions);
//
//		return list_template;
//	}
//}