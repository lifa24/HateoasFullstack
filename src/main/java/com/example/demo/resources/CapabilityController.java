package com.example.demo.resources;

import com.example.demo.domain.Capability;
import com.example.demo.services.CapabilityService;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {
    private CapabilityService capabilityService;

    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping("/{id}")
    public Resource<?> getCapability(@PathVariable Long id){
        Capability capability = capabilityService.findCapById(id);

        return new Resource<>(capability,
                linkTo(methodOn(CapabilityController.class).getCapability(id)).withSelfRel());
    }
}
