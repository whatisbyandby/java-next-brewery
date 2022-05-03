package com.perkylab.brewery.dto;

import com.perkylab.brewery.domain.Hop;
import com.perkylab.brewery.domain.HopType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HopDto extends IngredientDto {

    private HopType hopType;
    private BigDecimal alpha;

    public HopDto() {

    }

    public HopDto(Hop hop) {
        super(hop);

        this.hopType = hop.getHopType();
        this.alpha = hop.getAlpha();
    }

    public Hop toHop() {
        Hop hop = new Hop();
        hop.setId(this.getId());
        hop.setName(this.getName());
        hop.setNotes(this.getNotes());
        hop.setOrigin(this.getOrigin());
        hop.setHopType(this.hopType);
        hop.setAlpha(this.alpha);

        return hop;
    }
}
