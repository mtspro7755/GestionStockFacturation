package sn.edu.ugb.ipsl.ing2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.edu.ugb.ipsl.ing2.entity.Stock;
import sn.edu.ugb.ipsl.ing2.entity.StockId;
import sn.edu.ugb.ipsl.ing2.service.StockService;

import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping()
    public Iterable<Stock> getStocks(){
        return stockService.getAllStocks();
    }

    @GetMapping("/stock/{magasinId}/{produitId}")
    public Optional<Stock> getStock(@PathVariable Long magasinId, @PathVariable Long produitId){
        StockId id = new StockId();
        id.setMagasinId((int) Math.toIntExact(magasinId));
        id.setProduitId((int) Math.toIntExact(produitId));
        return stockService.getStock(id);
    }

    @PostMapping("/create")
    public Stock saveStock(@RequestBody Stock stock){
        return stockService.saveStock(stock);
    }

    @PutMapping("/update")
    public Stock updateStock(@RequestBody Stock stock){
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/delete/{magasinId}/{produitId}")
    public void deleteStock(@PathVariable Long magasinId, @PathVariable Long produitId){
        StockId id = new StockId();
        id.setMagasinId((int) Math.toIntExact(magasinId));
        id.setProduitId((int) Math.toIntExact(produitId));
        stockService.deleteStock(id);
    }
}
