package com.yoga.binarfut.repository;

import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
}
