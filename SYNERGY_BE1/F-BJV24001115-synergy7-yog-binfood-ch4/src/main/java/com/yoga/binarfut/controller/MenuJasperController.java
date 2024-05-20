package com.yoga.binarfut.controller;

import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.payload.MenuJasperDto;
import com.yoga.binarfut.service.JasperService;
import com.yoga.binarfut.service.MenuService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menus")
public class MenuJasperController {
    @Autowired
    MenuService menuService;

    @Autowired
    JasperService jasperService;

    @GetMapping("/generate/{format}")
    public ResponseEntity<Resource> getAll(@PathVariable String format) throws JRException {
        //format: pdf, xlsx

        //Dapatkan list of movie
        List<Menu> menuList = menuService.getAll();
        List<MenuJasperDto> menuJasperDtoList = menuList.stream()
                .map(Menu::toDto)
                .toList();

        //convert list of movie menjadi array byte[] menggunakan jasperService
        byte[] reportContent = jasperService.getMovieListReport(menuJasperDtoList, format);

        //return ByteArrayResource
        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("menu-list." + format).build().toString())
                .body(resource);
    }
}
