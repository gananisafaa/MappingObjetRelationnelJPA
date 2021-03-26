package ma.emsi.tp_jpa.repositories;

import ma.emsi.tp_jpa.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public Page<Patient> findByNameContains(String name, Pageable pageable);    public List<Patient> findByNameContainsAndSick(String name, boolean b);
    public List<Patient> findBySick(boolean b);
}
