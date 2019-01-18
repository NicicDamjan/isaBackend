package ftn.isa.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.controller.airCompanyController.dto.AirlineConfigurationDTO;
import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.AirlineConfiguration;
import ftn.isa.booking.model.AirlineServices;
import ftn.isa.booking.reporistory.AirlineConfigurationRepository;
import ftn.isa.booking.reporistory.AirlineRepository;
import ftn.isa.booking.reporistory.AirlineServicesRepository;



@Service
public class AirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private AirlineServicesRepository airlineServicesRepository;
	
	@Autowired
	private AirlineConfigurationRepository airlineConfigurationRepository;
	
	
	public Airline findById(Long id) {
		return airlineRepository.findById((long) id).get();
	}

	public Airline save(Airline airline) {
		return airlineRepository.save(airline);
	}
	
	public Airline findByName(String name) {
		return airlineRepository.findByName(name);
	}
	
	public List<Airline> findAll(){
		return airlineRepository.findAll();
	}
	
	public AirlineServices saveService(AirlineServices service) {
		return airlineServicesRepository.save(service);
	}
	
	public AirlineServices editService(AirlineServices service) {
		
		return airlineServicesRepository.save(service);
	}

	public  List<AirlineServices> getAirlineServices(Long id){
        List<AirlineServices> services = new ArrayList<>();
        List<AirlineServices> allServices = airlineServicesRepository.findAll();
        for (AirlineServices as: allServices) {
            if (as.getAirline().getId() == id){
                services.add(as);
            }
        }
        return services;
    }

	public AirlineServices getOneService(Long id) {
		return airlineServicesRepository.findById(id).get();
	}

	public void removeService(Long id) {
		
		airlineServicesRepository.deleteById(id);
		
	}

	public void saveConfiguration(Long id, AirlineConfiguration ac) {

		AirlineConfiguration ac2 = airlineConfigurationRepository.save(ac);
		
		Airline aa = findById(id);
		
		aa.setAirlineConfiguration(ac2);
		
		save(aa);
		
	}

	public void editConfiguration(Long id, AirlineConfigurationDTO acDTO) {
		
		AirlineConfiguration a2 = airlineConfigurationRepository.findById(id).get();
		
		a2.setArange(acDTO.getArange());
		a2.setColumnsA(acDTO.getColumnsA());
		a2.setRowsA(acDTO.getRowsA());
		
		airlineConfigurationRepository.save(a2);
		
	}

	public AirlineConfiguration findConfiguration(Long id) {

			return airlineConfigurationRepository.findById(id).get();
		
	}

	public AirlineConfiguration findConfigurationByAirline(Long id) {
		// TODO Auto-generated method stub
		Airline ar = airlineRepository.findById(id).get();
		
		return ar.getAirlineConfiguration();
	}

	
	
}
