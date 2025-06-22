package sn.edu.ugb.ipsl.ing2.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class StockId implements Serializable {

    private int magasinId;
    private int produitId;

    public StockId(int i, int i1) {
    }

    public StockId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return magasinId == stockId.magasinId && produitId == stockId.produitId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(magasinId, produitId);
    }
}
