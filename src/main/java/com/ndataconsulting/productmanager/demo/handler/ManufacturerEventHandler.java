package com.ndataconsulting.productmanager.demo.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.ndataconsulting.productmanager.demo.model.Manufacturer;

@Component
@RepositoryEventHandler(Manufacturer.class)
public class ManufacturerEventHandler {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@HandleBeforeCreate
	public void hanleBeforeCreate(Manufacturer m){
		//do a check to see if the name is a valid Manufacturer
		
		//auditing
		
		//only allow new manufacturers to be created in the active state.
		if(!m.getActive()){
			throw new IllegalArgumentException("New Manufacturers must be 'active'");
		}
	}
}
