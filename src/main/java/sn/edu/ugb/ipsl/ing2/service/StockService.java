package sn.edu.ugb.ipsl.ing2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.edu.ugb.ipsl.ing2.entity.Stock;
import sn.edu.ugb.ipsl.ing2.entity.StockId;
import sn.edu.ugb.ipsl.ing2.repository.StockRepository;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Optional<Stock> getStock(StockId id){
        return stockRepository.findById(id);
    }

    public Iterable<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public void deleteStock(StockId id){
        stockRepository.deleteById(id);
    }

    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }
}
