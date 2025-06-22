package sn.edu.ugb.ipsl.ing2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.edu.ugb.ipsl.ing2.entity.Stock;
import sn.edu.ugb.ipsl.ing2.entity.StockId;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, StockId> {

}
