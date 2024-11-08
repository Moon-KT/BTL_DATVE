package com.example.SB_Week9.entity;

import com.example.SB_Week9.entity.key.ComboOfferGiftKey;
import jakarta.persistence.*;

@Entity
@Table(name = "combo_offer_gift", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"combo_offer_id", "gift_id"})
})
public class ComboOffer_Gift {
    @EmbeddedId
    private ComboOfferGiftKey id;

    @ManyToOne
    @JoinColumn(name = "combo_offer_id", insertable = false, updatable = false)
    private ComboOffer comboOffer;

    @ManyToOne
    @JoinColumn(name = "gift_id", insertable = false, updatable = false)
    private Gift gift;
}
