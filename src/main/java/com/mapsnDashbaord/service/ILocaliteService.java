package com.mapsnDashbaord.service;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Commun;
import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.model.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface ILocaliteService {

	Region saveRegion(Region region);

	List<Region> findAllRegion();

	Region findByCodeRegion(String codeRegion);
	
	List<Region> findByNameRegion(String name);

	public Page<Region> findPaginated(String search, Pageable pageable);

	void deletRegion(Long id);
	public void SupprimerRegion(Region region);
	public Region getRegionById(long id);

	Region updateRegion(Region region);

	void addDepartToRegion(String codeRegion, String codeDepart);

	// department
	Departement saveDepartemnt(Departement departement);

	List<Departement> findAllDepartement();

	Departement findByCodeDep(String codedep);
	Departement findByNameDepart(String name);
	public Page<Departement> findPaginatedDepartement(String search, Pageable pageable);
	void deletDepartement(Long id);
	public void SupprimerDepartement(Departement depart);

	Departement updateDepartement(Departement region);

	void addArronToDepartement(String codeDepart, String codeArron);

//Arrondissement
	Arrondissement saveArrondissement(Arrondissement arrondissement);

	List<Arrondissement> findAllArrondissement();

	Arrondissement findByCodeArr(String codeArron);
	
	Arrondissement findByNameArron(String name);
	public Page<Arrondissement> findPaginatedArrondissement(String search, Pageable pageable);
	void deletArrondissement(Long id);
	public void SupprimerArron(Arrondissement arrondissement);

	Arrondissement updateArrondissement(Arrondissement arrondissement);

	void addCommToArron(String codeArron, String codeCom);

	// Commun
	Commun saveCommun(Commun commun);

	List<Commun> findAllCommun();

	Commun findByCodeCom(String codeCom);
	
	Commun findByNameCom(String name);
	public Page<Commun> findPaginatedCommun(String search, Pageable pageable);

	void deletCommun(Long id);
	public void SupprimerArron(Commun commun);

	Commun updateCommun(Commun commun);



}
