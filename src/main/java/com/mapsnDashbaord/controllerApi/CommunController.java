package com.mapsnDashbaord.controllerApi;

import java.util.List;

import com.mapsnDashbaord.model.Commun;
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



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CommunController {
	
	private LocaliteServiceImpl localiteServiceImpl;

	public CommunController(LocaliteServiceImpl localiteServiceImpl) {
		super();
		this.localiteServiceImpl = localiteServiceImpl;
	}

	@PostMapping("/commune")
	public Commun saveCommun(@RequestBody Commun commun) {
		return localiteServiceImpl.saveCommun(commun);
	}
	
	@GetMapping("/communes")
	public List<Commun> findAllCommun() {
		return localiteServiceImpl.findAllCommun();
	}
	@GetMapping("/commune/{codCom}")
	public Commun findByCodCom(@PathVariable String codCom) {
		return localiteServiceImpl.findByCodeCom(codCom);
	}	
	@GetMapping("/commune/{name}")
	public Commun findByNameCom(@PathVariable String name) {
		return localiteServiceImpl.findByNameCom(name);
	}

	@DeleteMapping("/deleteCommune/{id}")
	public void deletRegion(@PathVariable Long id) {
		localiteServiceImpl.deletCommun(id);
	}

	@PutMapping("updateCommune")
	public Commun updateCommun(@RequestBody Commun commun) {
		return localiteServiceImpl.updateCommun(commun);
	}
}
