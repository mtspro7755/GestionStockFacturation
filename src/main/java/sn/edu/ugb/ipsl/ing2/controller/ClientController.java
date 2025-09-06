package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Client;
import sn.edu.ugb.ipsl.ing2.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")  // autorise Angular
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping()
    public Iterable<Client> getClients(){
        return clientService.getClientAll();
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClient(@PathVariable Long id){
        try {
            return clientService.getClient(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }



    @PostMapping("/create")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        Client createdClient=clientService.saveClient(client);
        return ResponseEntity.ok(createdClient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id,@RequestBody Client client){
        Client updatedClient=clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
