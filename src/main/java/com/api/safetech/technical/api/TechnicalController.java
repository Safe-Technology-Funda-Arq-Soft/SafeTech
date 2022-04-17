package com.api.safetech.technical.api;

import com.api.safetech.technical.domain.service.TechnicalService;
import com.api.safetech.technical.mapping.TechnicalMapper;
import com.api.safetech.technical.resource.CreateTechnicalResource;
import com.api.safetech.technical.resource.TechnicalResource;
import com.api.safetech.technical.resource.UpdateTechnicalResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Technical")
@RestController
@RequestMapping("/api/v1/technicals")
@CrossOrigin
public class TechnicalController {

    @Autowired
    private TechnicalService technicalService;

    @Autowired
    private TechnicalMapper mapper;

    @Operation(summary = "Get Technicals", description = "Get All Technicals")
    @GetMapping
    public List<TechnicalResource> getAllTechnicals()
    {
        return mapper.toResource(technicalService.getAll());
    }

    @Operation(summary = "Get Technicals by Id", description = "Get Technicals by Id")
    @GetMapping("{technicalId}")
    public TechnicalResource getById(@PathVariable Long technicalId)
    {
        return mapper.toResource(technicalService.getById(technicalId));
    }

    @Operation(summary = "Create Technical", description = "Create Technical")
    @PostMapping
    public TechnicalResource createTechnical(@RequestBody CreateTechnicalResource request)
    {
        return mapper.toResource(technicalService.create(mapper.toModel(request)));
    }

    @Operation(summary = "Update Technical", description = "Update Technical by Id")
    @PutMapping("{technicalId}")
    public TechnicalResource updateTechnical(@PathVariable Long technicalId, @RequestBody UpdateTechnicalResource request)
    {
        return mapper.toResource(technicalService.update(technicalId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete technical", description = "Delete technical by Id")
    @DeleteMapping("{technicalId}")
    public ResponseEntity<?> deleteTechnical(@PathVariable Long technicalId)
    {
        return technicalService.delete(technicalId);
    }

    @Operation(summary = "Get Technicals by Email", description = "Get Technicals by Email")
    @GetMapping("email/{technicalEmail}")
    public TechnicalResource getByEmail(@PathVariable String technicalEmail)
    {
        return mapper.toResource(technicalService.getByEmail(technicalEmail));
    }

    @Operation(summary = "Get Technicals by First Name", description = "Get Technicals by First Name")
    @GetMapping("firstName/{firstName}")
    public List<TechnicalResource> getByFirstName(@PathVariable String firstName)
    {
        return mapper.toResource(technicalService.getByFirstName(firstName));
    }

    @Operation(summary = "Get Technicals by Last Name", description = "Get Technicals by Last Name")
    @GetMapping("lastName/{lastName}")
    public List<TechnicalResource> getByLastName(@PathVariable String lastName)
    {
        return mapper.toResource(technicalService.getByLastName(lastName));
    }
}
