package com.mapsnDashbaord.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.mapsnDashbaord.model.Arrondissement;
import com.mapsnDashbaord.model.Commun;
import com.mapsnDashbaord.model.Departement;
import com.mapsnDashbaord.model.Region;
import com.mapsnDashbaord.repository.DepRepository;
import com.mapsnDashbaord.repository.IArrondissementRepository;
import com.mapsnDashbaord.repository.ICommunRepository;
import com.mapsnDashbaord.repository.IRegionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class LocaliteServiceImpl implements ILocaliteService {
	private IRegionRepository iRegionRepository;
	private DepRepository depRepository;
	private ICommunRepository communRepository;
	private IArrondissementRepository arrondissementRepository;
	

	public LocaliteServiceImpl(IRegionRepository iRegionRepository, DepRepository depRepository,
			ICommunRepository communRepository, IArrondissementRepository arrondissementRepository) {
		super();
		this.iRegionRepository = iRegionRepository;
		this.depRepository = depRepository;
		this.communRepository = communRepository;
		this.arrondissementRepository = arrondissementRepository;
	}

	@Override
	public Region saveRegion(Region region) {
		// TODO Auto-generated method stub
		return iRegionRepository.save(region);
	}

	@Override
	public List<Region> findAllRegion() {
		// TODO Auto-generated method stub
		return iRegionRepository.findAll();
	}

	@Override
	public Region findByCodeRegion(String codeRegion) {
		// TODO Auto-generated method stub
		return iRegionRepository.findByCodeRegion(codeRegion);
	}

	@Override
	public void deletRegion(Long id) {
		// TODO Auto-generated method stub
		iRegionRepository.deleteById(id);
	}

	@Override
	public Region updateRegion(Region region) {
		// TODO Auto-generated method stub
		return iRegionRepository.saveAndFlush(region);
	}

	@Override
	public void addDepartToRegion(String codeRegion, String codeDepart) {
		// TODO Auto-generated method stub
		Region region = iRegionRepository.findByCodeRegion(codeRegion);
		Departement departement = depRepository.findByCodeDep(codeDepart);
		if (region == null && departement == null) {
			System.out.println("not found codeRegion and codeDepart ");
		} else {
			departement.setCodeRegion(region);
			region.getDepart().add(departement);
		}

	}

	@Override
	public Departement saveDepartemnt(Departement departement) {
		// TODO Auto-generated method stub
		return depRepository.save(departement);
	}

	@Override
	public List<Departement> findAllDepartement() {
		// TODO Auto-generated method stub
		return depRepository.findAll();
	}

	@Override
	public Departement findByCodeDep(String codedep) {
		// TODO Auto-generated method stub
		return depRepository.findByCodeDep(codedep);
	}

	@Override
	public void deletDepartement(Long id) {
		// TODO Auto-generated method stub
		depRepository.deleteById(id);
	}

	@Override
	public Departement updateDepartement(Departement region) {
		// TODO Auto-generated method stub
		return depRepository.saveAndFlush(region);
	}

	@Override
	public void addArronToDepartement(String codeDepart, String codeArron) {
		// TODO Auto-generated method stub
		Departement departement = depRepository.findByCodeDep(codeDepart);
		Arrondissement arrondissement = arrondissementRepository.findByCodeAr(codeArron);
		if (departement == null && arrondissement == null) {
			System.out.println("not found codeRegion and codeDepart ");
		} else {
			arrondissement.setCodeAr(codeArron);
			departement.getArron().add(arrondissement);
		}

	}

	@Override
	public Arrondissement saveArrondissement(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		return arrondissementRepository.save(arrondissement);
	}

	@Override
	public List<Arrondissement> findAllArrondissement() {
		// TODO Auto-generated method stub
		return arrondissementRepository.findAll();
	}

	@Override
	public Arrondissement findByCodeArr(String codeArron) {
		// TODO Auto-generated method stub
		return arrondissementRepository.findByCodeAr(codeArron);
	}

	@Override
	public void deletArrondissement(Long id) {
		// TODO Auto-generated method stub
		arrondissementRepository.deleteById(id);
	}

	@Override
	public Arrondissement updateArrondissement(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		return arrondissementRepository.saveAndFlush(arrondissement);
	}

	@Override
	public void addCommToArron(String codeArron, String codeCom) {
		// TODO Auto-generated method stub
		Arrondissement arrondissement = arrondissementRepository.findByCodeAr(codeArron);
		Commun commun = communRepository.findByCodeCom(codeCom);
		if (arrondissement == null && commun == null) {

			System.out.println("not found codeRegion and codeDepart ");
		}
		{
			commun.setCodeCom(codeCom);
			arrondissement.getCommun().add(commun);

		}

	}

	@Override
	public Commun saveCommun(Commun commun) {
		// TODO Auto-generated method stub
		return communRepository.save(commun);
	}

	@Override
	public List<Commun> findAllCommun() {
		// TODO Auto-generated method stub
		return communRepository.findAll();
	}

	@Override
	public Commun findByCodeCom(String codeCom) {
		// TODO Auto-generated method stub
		return communRepository.findByCodeCom(codeCom);
	}

	@Override
	public void deletCommun(Long id) {
		// TODO Auto-generated method stub
		communRepository.deleteById(id);
	}

	@Override
	public Commun updateCommun(Commun commun) {
		// TODO Auto-generated method stub
		return communRepository.saveAndFlush(commun);
	}

	@Override
	public List<Region> findByNameRegion(String name) {
		// TODO Auto-generated method stub
		return iRegionRepository.findByNameContains(name);
	}

	@Override
	public Page<Region> findPaginated(String search, Pageable pageable) {

			List<Region> products = iRegionRepository.searchRegion(search); //repo.findAll();

			int pageSize = pageable.getPageSize();
			int currentPage = pageable.getPageNumber();
			int startItem = currentPage * pageSize;
			List<Region> list;

			if (products.size() < startItem) {
				list = Collections.emptyList();
			} else {
				int toIndex = Math.min(startItem + pageSize, products.size());
				list = products.subList(startItem, toIndex);
			}

			Page<Region> bookPage = new PageImpl<Region>(list, PageRequest.of(currentPage, pageSize), products.size());

			return bookPage;
	}

	@Override
	public Departement findByNameDepart(String name) {
		// TODO Auto-generated method stub
		return depRepository.findByNameContaining(name);
	}

	@Override
	public Page<Departement> findPaginatedDepartement(String search, Pageable pageable) {
		List<Departement> departements = depRepository.searchDepartement(search); //repo.findAll();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Departement> listDep;

		if (departements.size() < startItem) {
			listDep = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, departements.size());
			listDep = departements.subList(startItem, toIndex);
		}

		Page<Departement> bookPage = new PageImpl<Departement>(listDep, PageRequest.of(currentPage, pageSize), departements.size());

		return bookPage;
	}

	@Override
	public Arrondissement findByNameArron(String name) {
		// TODO Auto-generated method stub
		return arrondissementRepository.findByName(name);
	}

	@Override
	public Page<Arrondissement> findPaginatedArrondissement(String search, Pageable pageable) {
		List<Arrondissement> arrondissements = arrondissementRepository.searchArrondissement(search); //repo.findAll();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Arrondissement> listArron;

		if (arrondissements.size() < startItem) {
			listArron = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, arrondissements.size());
			listArron = arrondissements.subList(startItem, toIndex);
		}

		Page<Arrondissement> bookPage = new PageImpl<Arrondissement>(listArron, PageRequest.of(currentPage, pageSize), arrondissements.size());

		return bookPage;
	}

	@Override
	public Commun findByNameCom(String name) {
		// TODO Auto-generated method stub
		return communRepository.findByName(name);
	}

	@Override
	public Page<Commun> findPaginatedCommun(String search, Pageable pageable) {
		List<Commun> communes = communRepository.searchCommun(search); //repo.findAll();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Commun> listArron;

		if (communes.size() < startItem) {
			listArron = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, communes.size());
			listArron = communes.subList(startItem, toIndex);
		}

		Page<Commun> bookPage = new PageImpl<Commun>(listArron, PageRequest.of(currentPage, pageSize), communes.size());

		return bookPage;
	}

	@Override
	public void SupprimerRegion(Region region) {
		// TODO Auto-generated method stub
		iRegionRepository.delete(region);
	}

	@Override
	public void SupprimerDepartement(Departement depart) {
		// TODO Auto-generated method stub
		depRepository.delete(depart);
	}

	@Override
	public void SupprimerArron(Arrondissement arrondissement) {
		// TODO Auto-generated method stub
		arrondissementRepository.delete(arrondissement);
	}


	@Override
	public void SupprimerArron(Commun commun) {
		// TODO Auto-generated method stub
		communRepository.delete(commun);
	}

	 public Region getRegionById(long id) {
	        Optional<Region> optional=iRegionRepository.findById(id);
	        Region region=null;
	        if(optional.isPresent()) {
	        	region=optional.get();
	        }else {
	        	throw new RuntimeException("Region not found for id :: "+id);
	        }
	    return region;
	    }
}
