package ma.emsi.tp_jpa;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(TpJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    patientRepository.save(new Patient(null, "Oumaima", new Date(), 2300, false));
    patientRepository.save(new Patient(null, "Houda", new Date(), 2760, false));
    patientRepository.save(new Patient(null, "Lahsen", new Date(), 3000, true));
    patientRepository.save(new Patient(null, "Aymane", new Date(), 4356, false));
    patientRepository.save(new Patient(null, "Khadija", new Date(), 7658, true));
    patientRepository.save(new Patient(null, "Hiba", new Date(), 9357, true));
    patientRepository.save(new Patient(null, "Mounia", new Date(), 2356, false));

        System.out.println("*************** FIND ALL ******************");
        Patient patient=patientRepository.findById(4L).get();
        System.out.println(patient.getName());
        System.out.println("*************** FIND BY Name ******************");
        Page<Patient> patientPage=patientRepository.findByNameContains("e", PageRequest.of(0, 2));
        patientPage.forEach(p-> {
            System.out.println(p.toString());
        });
        System.out.println("*************** FIND BY Sickness ******************");
        List<Patient> patients=patientRepository.findBySick(false);
        patients.forEach(p-> {
            System.out.println(p.toString());
        });

        System.out.println("*************** FIND BY Name AND Sickness ******************");
    patients=patientRepository.findByNameContainsAndSick("s",false);
    patients.forEach(p-> {
        System.out.println(p.toString());
    });

        System.out.println("*************** Delete By Id ******************");
    patientRepository.deleteById(3L);
    patientPage=patientRepository.findAll(PageRequest.of(0,3));
    System.out.println("Nombre de pages:"+ patientPage.getTotalPages());
    patientPage.getContent().forEach(p-> {
        System.out.println(p.toString());
    });
    }
}
