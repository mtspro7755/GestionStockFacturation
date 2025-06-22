package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Employe;
import sn.edu.ugb.ipsl.ing2.service.EmployeService;

import java.util.Optional;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping()
    public Iterable<Employe> getEmployes(){
        return employeService.getEmployeAll();
    }

    @GetMapping("/employe/{id}")
    public Optional<Employe> getEmploye(@PathVariable Long id){
        try {
            return employeService.getEmploye(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @PostMapping("/create")
    public Employe saveEmploye(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);
    }

    @PutMapping("/update")
    public Employe updateEmploye(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
    }
}
