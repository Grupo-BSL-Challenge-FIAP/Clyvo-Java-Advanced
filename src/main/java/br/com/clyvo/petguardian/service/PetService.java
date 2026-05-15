package br.com.clyvo.petguardian.service;

import br.com.clyvo.petguardian.dto.request.PetRequest;
import br.com.clyvo.petguardian.dto.response.PetResponse;
import br.com.clyvo.petguardian.entity.Pet;
import br.com.clyvo.petguardian.entity.Responsible;
import br.com.clyvo.petguardian.entity.Veterinarian;
import br.com.clyvo.petguardian.repository.PetRepository;
import br.com.clyvo.petguardian.repository.ResponsibleRepository;
import br.com.clyvo.petguardian.repository.VeterinarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository repository;
    private final ResponsibleRepository responsibleRepository;
    private final VeterinarianRepository veterinarianRepository;

    public PetResponse create(PetRequest request) {
        Responsible resp = responsibleRepository.findById(request.responsibleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Responsável não encontrado"));

        Veterinarian vet = veterinarianRepository.findById(request.veterinarianId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veterinário não encontrado"));

        Pet pet = Pet.builder()
                .name(request.name())
                .species(request.species())
                .breed(request.breed())
                .gender(request.gender())
                .birthDate(request.birthDate())
                .weight(request.weight())
                .currentStatus(request.currentStatus())
                .responsible(resp)
                .veterinarian(vet)
                .build();

        return toResponse(repository.save(pet));
    }

    public Page<PetResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toResponse);
    }

    public PetResponse findById(Long id) {
        Pet pet = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        return toResponse(pet);
    }

    private PetResponse toResponse(Pet pet) {
        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getBirthDate(),
                pet.getWeight(),
                pet.getCurrentStatus(),
                pet.getResponsible().getFullName(),
                pet.getVeterinarian().getFullName()
        );
    }
}