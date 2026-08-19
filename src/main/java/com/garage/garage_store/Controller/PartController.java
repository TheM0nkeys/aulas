package com.garage.garage_store.Controller;

import com.garage.garage_store.DTO.PartRequest;
import com.garage.garage_store.DTO.PartResponse;
import com.garage.garage_store.Model.Services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {
    @Autowired
    private PartService service;

    @GetMapping("/get")
    public List<PartResponse> findAll() { return service.findAll();}

    @GetMapping("/get/{id}")
    public PartResponse findById(@PathVariable Integer id){return  service.findById(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public PartResponse save(@RequestBody PartRequest dto) { return service.savePart(dto);}

    @PutMapping("/save/{id}")
    public PartResponse udpate (
            @PathVariable Integer id,
            @RequestBody PartRequest dto
    ){
        return service.updatePart(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deletePart(id);
    }
}
