package com.yoga.binarfut.service;

import com.yoga.binarfut.exception.NotFoundIdException;
import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.MenuDto;
import com.yoga.binarfut.payload.MenuRequestDto;
import com.yoga.binarfut.payload.MenuResponseDto;
import com.yoga.binarfut.repository.MenuRepository;
import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu create(MenuResponseDto menuResponseDto) {
        return menuRepository.save(new Menu());
    }

    @Override
    public MenuResponseDto createMenu(MenuRequestDto menuRequestDto) {
        Merchant merchant = merchantRepository.findById(menuRequestDto.getMerchant())
                .orElseThrow(() -> new IllegalArgumentException("Merchant not found"));

        // Create a new MenuModel entity
        Menu menu = new Menu();
        menu.setName(menuRequestDto.getName());
        menu.setPrice(menuRequestDto.getPrice());
        menu.setType(menuRequestDto.getType());
        menu.setMerchant(merchant); // Associate the MenuModel with the fetched Merchant entity

        // Save the MenuModel entity
        menu = menuRepository.save(menu);

        // Create and return a MenuResponseDto based on the saved MenuModel
        MenuResponseDto menuResponseDto = new MenuResponseDto();
        menuResponseDto.setId(menu.getId());
        menuResponseDto.setName(menu.getName());
        menuResponseDto.setPrice(menu.getPrice());
        menuResponseDto.setType(menu.getType());
        menuResponseDto.setMerchant(menu.getMerchant().getId()); // Assuming getId() returns the UUID of the Merchant

        return menuResponseDto;
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public void softDeleteUser(UUID id) {
        Optional<Menu> menu = menuRepository.findById(id);

        menu.ifPresent(m -> {
            m.setDeleted(true);
            menuRepository.save(m);
        });
    }

    @Override
    public Menu patchMenu(UUID id, MenuDto menuDto) {
        Optional<Menu> optionalMenu = menuRepository.findById(id);

        if (optionalMenu.isEmpty()){
            throw new NotFoundIdException("User not found with id " + id);
        }
        Menu menu = optionalMenu.get();

        if (menuDto.getName() != null) {
            menu.setName(menuDto.getName());
        }
        if (menuDto.getPrice() != null) {
            menu.setPrice(menuDto.getPrice());
        }
        if (menuDto.getType() != null) {
            menu.setType(menuDto.getType());
        }
//        if (userDto.getRole() != null ){
//            menu.setRole(userDto.getRole());
//        }
        return menuRepository.save(menu);
    }

}
