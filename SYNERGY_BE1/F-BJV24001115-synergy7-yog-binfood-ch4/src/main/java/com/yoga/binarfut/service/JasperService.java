package com.yoga.binarfut.service;

//import com.example.xxwan.payload.MovieListReportDto;
import com.yoga.binarfut.payload.MenuJasperDto;
//import com.yoga.binarfut.payload.OrderDetailDto;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface JasperService {
    byte[] getMovieListReport(List<MenuJasperDto> menuJasperDtoList, String format) throws JRException;
}
