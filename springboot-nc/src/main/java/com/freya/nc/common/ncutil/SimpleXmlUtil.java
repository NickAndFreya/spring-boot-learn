package com.freya.nc.common.ncutil;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SimpleXmlUtil {
    private static final Logger logger = LoggerFactory.getLogger(SimpleXmlUtil.class);

    public static void setValue2ElementAttr(String f, String value) {
        File file = new File(f);
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(file);
            //获取根目录
            Element rootElement = doc.getRootElement();
            //获取根目录下的指定节点
            Element e = rootElement.element("variable");
            //获取指定节点
            Element e1 = e.element("attribute");
            logger.info("XML中第一个Attribute标签: {}", e1.toString());
            //获取指定属性
            Attribute attribute = e1.attribute("value");
            //设置属性值
            attribute.setValue(value);
            //格式化为缩进格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            //设置编码格式
            format.setEncoding("UTF-8");
            try {
                XMLWriter writer = new XMLWriter(new FileWriter(file), format);
                //写入数据
                writer.write(doc);
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
