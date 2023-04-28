package ma.enset.patient_mvc;

import ma.enset.patient_mvc.entites.Patient;
import ma.enset.patient_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository)
    {
        return  args -> {
            patientRepository.save(
                    new Patient(null, "Hassan",new Date(),false,12));
            patientRepository.save(
                    new Patient(null, "Manal",new Date(),true,10));
            patientRepository.save(
                    new Patient(null, "Chifaa",new Date(),false,13));
            patientRepository.save(
                    new Patient(null, "Chamsse",new Date(),true,22));


            patientRepository.findAll().forEach(p->{System.out.println(p.getNom());});
        };
    }
}
