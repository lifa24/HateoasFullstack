package com.example.demo.services;

import com.example.demo.domain.Capability;
import com.example.demo.exceptions.CapabilityException;
import com.example.demo.repositories.CapabilityRepository;
import org.springframework.stereotype.Service;

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
}
