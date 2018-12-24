package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.AirCompany;
import ftn.isa.booking.reporistory.AirCompanyRepository;

@Service
public class AirCompanyService {
		
	@Autowired
	private AirCompanyRepository airCompanyRepository;
	
	 public void saveAirCompany(AirCompany airCompany) {
	    	airCompanyRepository.save(airCompany);
	    }
	 
	 public AirCompany getOne(Long id) {
	        return airCompanyRepository.findOneById(id);
	    }
	 
	 public void deleteById(Long id) {
	    	airCompanyRepository.deleteById(id);
	    }
	 
	 
	    
}
