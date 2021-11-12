package com.mapsnDashbaord.controllerApi;

import java.util.List;

import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.service.LocaliteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/api")
@CrossOrigin("*")
@RestController
public class DepController {

	private LocaliteServiceImpl localiteServiceImpl;

	public DepController(LocaliteServiceImpl localiteServiceImpl) {
		super();
		this.localiteServiceImpl = localiteServiceImpl;
	}

	@PostMapping("/departement")
	public Departement saveDepartement(@RequestBody Departement departement) {
		return localiteServiceImpl.saveDepartemnt(departement);
	}

	@PostMapping("/departement/addArronToDep")
	public void addArronToDep(@PathVariable String codedep, @PathVariable String CodeArron) {
		localiteServiceImpl.addArronToDepartement(codedep, CodeArron);
	}

	@GetMapping("/departements")
	public List<Departement> findAllDepartement() {
		return localiteServiceImpl.findAllDepartement();
	}

	@GetMapping("/departement/{codDepartement}")
	public Departement findByCodDepartement(@PathVariable String codDepartement) {
		return localiteServiceImpl.findByCodeDep(codDepartement);
	}
	
	@GetMapping("/departement/{name}")
	public Departement findByNameDepartement(@PathVariable String name) {
		return localiteServiceImpl.findByNameDepart(name);
	}

	@DeleteMapping("/deleteDepartement/{id}")
	public void deleteDepartement(@PathVariable Long id) {
		localiteServiceImpl.deletDepartement(id);
	}

	@PutMapping("updateDepartement")
	public Departement updateDepartement(@RequestBody Departement departement) {
		return localiteServiceImpl.updateDepartement(departement);
	}
}
