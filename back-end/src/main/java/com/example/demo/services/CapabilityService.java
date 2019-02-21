package com.example.demo.services;

import com.example.demo.domain.Capability;
import com.example.demo.exceptions.CapabilityException;
import com.example.demo.repositories.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

@Service
public class CapabilityService {
    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities(){
        return capabilityRepository.findAll();
    }

    public Capability findCapById(Long id){
        return capabilityRepository.findById(id)
                .orElseThrow(() -> new CapabilityException("Capability with ID: " +id +" Not found"));

    }

    public Capability saveCapability(Capability capability){
        return capabilityRepository.save(capability);
    }

    public ResponseEntity<?> errorMap(BindingResult result){
        var errorM= new HashMap<>();

        for(FieldError error: result.getFieldErrors()){
            errorM.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorM, HttpStatus.BAD_REQUEST);
    }

    public Capability updateCapability(Long id, Capability capability){
        return capabilityRepository.findById(id).map(
                cap->{
                    cap.setTechStack(capability.getTechStack());
                    cap.setNumOfDevelopers(capability.getNumOfDevelopers());
                    cap.setNumOfAvailableDevelopers(capability.getNumOfAvailableDevelopers());
                    return capabilityRepository.save(cap);
                }).orElseGet(()-> capabilityRepository.save(capability)
        );
    }

    public void deleteCapability(Long id){

        capabilityRepository.delete(
                capabilityRepository.findById(id)
                        .orElseThrow(()-> new CapabilityException("Capability with ID: "+id+" Not found"))
        );
    }
}
