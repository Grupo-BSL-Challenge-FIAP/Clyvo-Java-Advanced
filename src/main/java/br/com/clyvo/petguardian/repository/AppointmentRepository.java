package br.com.clyvo.petguardian.repository;

import br.com.clyvo.petguardian.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPetIdOrderByAppointmentDateDesc(Long petId);
    List<Appointment> findByVeterinarianIdOrderByAppointmentDateDesc(Long veterinarianId);
}