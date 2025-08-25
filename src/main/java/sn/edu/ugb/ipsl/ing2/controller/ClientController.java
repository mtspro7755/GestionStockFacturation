package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Client;
import sn.edu.ugb.ipsl.ing2.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
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
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
}
