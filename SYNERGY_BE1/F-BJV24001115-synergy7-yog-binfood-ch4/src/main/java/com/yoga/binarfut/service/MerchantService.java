package com.yoga.binarfut.service;

import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.MerchantDto;
import com.yoga.binarfut.payload.MerchantRequestDto;
import com.yoga.binarfut.payload.MerchantResponseDto;

import java.util.List;
import java.util.UUID;

public interface MerchantService {
    Merchant getById(UUID id);

    MerchantResponseDto create(MerchantRequestDto merchantRequestDto);

    //create
    List<Merchant> getAll();

    //delete
    void softDeleteUser(UUID id);

    //update
    Merchant patchMerchant(UUID id, MerchantDto merchantDto);
}
