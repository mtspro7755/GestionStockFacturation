package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Employe;
import sn.edu.ugb.ipsl.ing2.service.EmployeService;

import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "http://localhost:4200")  // autorise Angular
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
    public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe){
        Employe saveEmploye=employeService.saveEmploye(employe);
        return ResponseEntity.ok(saveEmploye);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable int id,@RequestBody Employe employe){
        Employe updateEmploye=employeService.updateEmploye(id,employe);
        return ResponseEntity.ok(updateEmploye);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
