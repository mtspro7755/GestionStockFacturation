package sn.edu.ugb.ipsl.ing2.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Employe;
import sn.edu.ugb.ipsl.ing2.repository.EmployeRepository;

import java.util.Optional;

@Service
@Data
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Optional<Employe> getEmploye(final Long id) {
        return employeRepository.findById(id);
    }

    public Iterable<Employe> getEmployeAll() {
        return employeRepository.findAll();
    }

    public void deleteEmploye(final Long id) {
        employeRepository.deleteById(id);
    }

    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
}
