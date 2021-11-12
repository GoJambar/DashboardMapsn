package com.mapsnDashbaord.controllerApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.mapsnDashbaord.model.Region;
import com.mapsnDashbaord.repository.IRegionRepository;
import com.mapsnDashbaord.service.LocaliteServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RegionController {
	private IRegionRepository iRegionRepository;

	private LocaliteServiceImpl localiteServiceImpl;
	

	public RegionController(IRegionRepository iRegionRepository, LocaliteServiceImpl localiteServiceImpl) {
		super();
		this.iRegionRepository = iRegionRepository;
		this.localiteServiceImpl = localiteServiceImpl;
	}

	@PostMapping("/region")
	public Region saveRegion(@RequestBody Region region) {
		return localiteServiceImpl.saveRegion(region);
	}

	@PostMapping("/region/addDepToRegion")
	public void addDepToRegion(@PathVariable String codeRegion, @PathVariable String CodeDep) {
		localiteServiceImpl.addDepartToRegion(codeRegion, CodeDep);
	}

	

	@GetMapping("/regions")
	public List<Region> findAllRegion() {
		return localiteServiceImpl.findAllRegion();
	}

	@GetMapping("/region/{codRregion}")
	public Region findByCodeRegion(@PathVariable String codRregion) {
		return localiteServiceImpl.findByCodeRegion(codRregion);
	}
	
	@GetMapping("/regions/{name}")
	public List<Region> findByNameRegion(@PathVariable String name) {
		return localiteServiceImpl.findByNameRegion(name);
	}
	
	@GetMapping(path = "/region/imageRegion/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] image(@PathVariable Long id) throws IOException {
		Region region=iRegionRepository.findById(id).get();
		String photo=region.getPhoto();
		File file=new File(System.getProperty("user.home")+"/region/images/"+photo+".png");
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	

	@DeleteMapping("/deletRegion/{id}")
	public void deletRegion(@PathVariable Long id) {
		localiteServiceImpl.deletRegion(id);
	}

	@PutMapping("updateRegion")
	public Region updateRegion(@RequestBody Region region) {
		return localiteServiceImpl.updateRegion(region);
	}
}
