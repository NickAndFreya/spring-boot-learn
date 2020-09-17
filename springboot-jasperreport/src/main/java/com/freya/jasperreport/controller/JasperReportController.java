package com.freya.jasperreport.controller;

import com.freya.jasperreport.entity.MonomerBase;
import com.freya.jasperreport.utils.JasperHelper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class JasperReportController {

    /**
     * 使用JavaBean数据源导出
     * @throws Exception
     */
    @RequestMapping("/exportPdf")
    public void exportPdf(final ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<MonomerBase> list = new ArrayList<>();
        MonomerBase monomerBase = new MonomerBase().setInspectUnit("test")
                .setNumber("ZJ100001").setBuildingHeight("100")
                .setContactPerson("nick").setContactPhone("110")
                .setTester("lucy").setInspectObject("避雷针");
        list.add(monomerBase);

        //模拟数据源
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        HashMap<String, Object> objectHashMap = new HashMap<>();
        //此处demo直接使用的磁盘绝对路径了,实际生产老实取文件路径
        File reporeFile = new File("D:\\privateworkspace\\spring-boot-learn\\springboot-jasperreport\\src\\main\\resources\\static\\jasperreport\\monomer_base.jasper");
        JasperHelper.showPdf("导出测试", reporeFile.getPath(), request, response, objectHashMap, jrDataSource);


    }
    /**
     * 使用JavaBean数据源导出
     * @throws Exception
     */
    @RequestMapping("/index")
    public void exportPdf_index(final ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<MonomerBase> list = new ArrayList<>();
        MonomerBase monomerBase = new MonomerBase().setInspectUnit("阿里巴巴")
                .setNumber("ZJ100001J");
        list.add(monomerBase);

        //模拟数据源
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
        HashMap<String, Object> objectHashMap = new HashMap<>();
        //此处demo直接使用的磁盘绝对路径了,实际生产老实取文件路径
        File reporeFile = new File("D:\\privateworkspace\\spring-boot-learn\\springboot-jasperreport\\src\\main\\resources\\static\\jasperreport\\index.jasper");
        JasperHelper.showPdf("导出测试", reporeFile.getPath(), request, response, objectHashMap, jrDataSource);


    }
}
