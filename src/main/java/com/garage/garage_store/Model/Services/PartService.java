package com.garage.garage_store.Model.Services;

import com.garage.garage_store.DTO.PartRequest;
import com.garage.garage_store.DTO.PartResponse;
import com.garage.garage_store.Model.Entity.Part;
import com.garage.garage_store.Model.Repository.PartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    private final PartRepository repository;

    public PartService(PartRepository repository) { this.repository = repository; }

    public PartResponse savePart(PartRequest dto) {
        if(dto.id() != null && dto.name() != null && repository.existsByModel(dto.name())) {
            throw new RuntimeException("Já existe uma parte com esse modelo adicionando item a lista de peças...");
        }
        Part part = Part.builder()
                .name(dto.name())
                .model(dto.model())
                .quantity(dto.quantity())
                .price(dto.price())
                .build();
        Part savedPart = repository.save(part);

        return toResponse(savedPart);
    }
    public  List<PartResponse> findAll(){
        return repository.findAll()
                .stream()
                .map(part -> new PartResponse(
                        part.getId(),
                        part.getName(),
                        part.getPrice(),
                        part.getModel(),
                        part.getQuantity()
                )).toList();
    }
    public PartResponse findById(Integer id) {
        Part part = repository.findById(id).orElseThrow(() ->
                    new RuntimeException("Parte não encontrada")
                );
        return  new PartResponse(
                part.getId(),
                part.getName(),
                part.getPrice(),
                part.getModel(),
                part.getQuantity()
        );
    }
    public PartResponse updatePart(Integer id, PartRequest dto)
    {
        Part part = repository.findById(id).orElseThrow(
                () -> new RuntimeException("parte não encontrada")
        );

        if(dto.name() != null)
        {
            part.setName(dto.name());
        }
        if (dto.model() != null)
        {
            part.setModel(dto.model());
        }
        if (dto.price() != null) {
            part.setPrice(dto.price());
        }
        if (dto.quantity() != null) {
            part.setQuantity(dto.quantity());
        }

        Part updatedPart = repository.save(part);

        return toResponse(updatedPart);
    }

    public void deletePart(Integer id)
    {
        Part part = repository.findById(id)
                .orElseThrow(() ->
                            new RuntimeException("parte não encontrada")
                        );
        repository.delete(part);
    }
    private PartResponse toResponse(Part part)
    {
        return new PartResponse(
                part.getId(),
                part.getName(),
                part.getPrice(),
                part.getModel(),
                part.getQuantity()

        );
    }
}
