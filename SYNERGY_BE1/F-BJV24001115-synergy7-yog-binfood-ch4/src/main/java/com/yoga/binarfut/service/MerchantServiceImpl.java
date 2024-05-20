package com.yoga.binarfut.service;

import com.yoga.binarfut.exception.NotFoundIdException;
import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.MerchantDto;
import com.yoga.binarfut.payload.MerchantRequestDto;
import com.yoga.binarfut.payload.MerchantResponseDto;
import com.yoga.binarfut.repository.MerchantRepository;
import com.yoga.binarfut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Merchant getById(UUID id) {
        Optional<Merchant>merchantOptional =merchantRepository.findById(id);

        if (merchantOptional.isEmpty()){
            throw new RuntimeException("nothing");
        } else{
            return merchantOptional.get();
        }
    }

    @Override
    public MerchantResponseDto create(MerchantRequestDto merchantRequestDto) {
        User owner = userRepository.findById(merchantRequestDto.getOwner())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Merchant merchant = new Merchant();
        merchant.setName(merchantRequestDto.getName());
        merchant.setAddress(merchantRequestDto.getAddress());
//        merchant.setOpen(merchantRequestDto.);
        merchant.setOwner(owner);

        merchant = merchantRepository.save(merchant);

        MerchantResponseDto merchantResponseDto = new MerchantResponseDto();
        merchantResponseDto.setId(merchant.getId());
        merchantResponseDto.setName(merchant.getName());

        return merchantResponseDto;
    }

    @Override
    public List<Merchant> getAll() {
        return merchantRepository.findAll();
    }

    @Override
    public void softDeleteUser(UUID id) {
        Optional<Merchant> merchant = merchantRepository.findById(id);

        merchant.ifPresent(mer -> {
            mer.setDeleted(true);
            mer.setOpen(false);
            merchantRepository.save(mer);
        });
    }

    @Override
    public Merchant patchMerchant(UUID id, MerchantDto merchantDto) {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(id);

        if (optionalMerchant.isEmpty()){
            throw new NotFoundIdException("User not found with id " + id);
        }
        Merchant merchant = optionalMerchant.get();

        if (merchantDto.getName() != null) {
            merchant.setName(merchantDto.getName());
        }
        if (merchantDto.getAddress() != null) {
            merchant.setAddress(merchantDto.getAddress());
        }
//        if (menuDto.getType() != null) {
//            menu.setType(menuDto.getType());
//        }
//        if (userDto.getRole() != null ){
//            menu.setRole(userDto.getRole());
//        }
        return merchantRepository.save(merchant);
    }
}
