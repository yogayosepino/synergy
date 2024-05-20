package com.yoga.binarfut.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yoga.binarfut.payload.MenuJasperDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu_item")
@SQLDelete(sql = "update menu_item set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer price;
    private boolean deleted = Boolean.FALSE;

    public MenuJasperDto toDto() {
        MenuJasperDto dto = new MenuJasperDto();

        dto.setName(name);
//        dto.setType(name);

        return dto;
    }

    public enum Type{
        FOOD, DRINK
    }

    @JsonIgnore
    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

}

