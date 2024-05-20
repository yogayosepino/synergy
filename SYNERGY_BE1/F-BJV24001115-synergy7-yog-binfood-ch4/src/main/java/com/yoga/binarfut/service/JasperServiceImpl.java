package com.yoga.binarfut.service;

import com.yoga.binarfut.payload.MenuJasperDto;
//import com.yoga.binarfut.payload.OrderDetailDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperServiceImpl implements JasperService {
    @Override
    public byte[] getMovieListReport(List<MenuJasperDto> menuJasperDtoList, String format) throws JRException {
        JasperReport jasperReport;

        try{
            jasperReport = (JasperReport) JRLoader
                    .loadObject(ResourceUtils.getFile("order-detail.jasper"));
        } catch (JRException | FileNotFoundException e) {
            try{
                File file = ResourceUtils.getFile("classpath:jasper/menu-detail.jrxml");
                jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
                JRSaver.saveObject(jasperReport,"order-detail.jasper");
            } catch (JRException | FileNotFoundException ex){
                throw new RuntimeException(ex);
            }
        }


        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(menuJasperDtoList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("total", String.valueOf(menuJasperDtoList.size()));
//        parameters.put("merchantName", String.valueOf(MovieListReportDtoList.size()));
//        parameters.put("dateTime", String.valueOf(MovieListReportDtoList.size()));

        JasperPrint jasperPrint;
        byte[] reportContent;

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            switch (format) {
                case "pdf" -> reportContent = JasperExportManager.exportReportToPdf(jasperPrint);
                case "xml" -> reportContent = JasperExportManager.exportReportToXml(jasperPrint).getBytes();
                default -> throw new RuntimeException();
            }
        }catch (JRException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return reportContent;
    }
}
