package br.com.clyvo.petguardian.service;

import br.com.clyvo.petguardian.dto.request.ClinicalHistoryRequest;
import br.com.clyvo.petguardian.dto.response.ClinicalHistoryResponse;
import br.com.clyvo.petguardian.entity.ClinicalHistory;
import br.com.clyvo.petguardian.entity.Pet;
import br.com.clyvo.petguardian.repository.ClinicalHistoryRepository;
import br.com.clyvo.petguardian.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicalHistoryService {

    private final ClinicalHistoryRepository repository;
    private final PetRepository petRepository;

    public ClinicalHistoryResponse create(ClinicalHistoryRequest request) {
        Pet pet = petRepository.findById(request.petId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));

        ClinicalHistory history = ClinicalHistory.builder()
                .temperature(request.temperature())
                .heartRate(request.heartRate())
                .activityLevel(request.activityLevel())
                .healthScore(request.healthScore())
                .description(request.description())
                .observations(request.observations())
                .pet(pet)
                .build();

        return toResponse(repository.save(history));
    }

    public List<ClinicalHistoryResponse> findByPet(Long petId) {
        return repository.findByPetIdOrderByRecordedAtDesc(petId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ClinicalHistoryResponse toResponse(ClinicalHistory history) {
        return new ClinicalHistoryResponse(
                history.getId(),
                history.getTemperature(),
                history.getHeartRate(),
                history.getActivityLevel(),
                history.getHealthScore(),
                history.getDescription(),
                history.getObservations(),
                history.getRecordedAt(),
                history.getPet().getName()
        );
    }
}