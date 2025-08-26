package sn.edu.ugb.ipsl.ing2.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Client;
import sn.edu.ugb.ipsl.ing2.repository.ClientRepository;

import java.util.Optional;

@Service
@Data
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClient(final Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> getClientAll() {
        return clientRepository.findAll();
    }

    public void deleteClient(final Long id) {
        clientRepository.deleteById(id);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(int id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }
}
