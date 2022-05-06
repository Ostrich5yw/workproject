//package com.example.workproject.util;
//
//
//import com.aspose.cells.Workbook;
//import com.aspose.words.License;
//import com.aspose.words.*;
//import com.aspose.words.Shape;
//import org.apache.tomcat.jni.Directory;
//import java.awt.*;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//
//public class asposeUtil {
//    public void toPdf(String sourcepath, String pdfpath){
//        try {
//            asposeUtil.doc2pdf(sourcepath,pdfpath);
//            //文件输出路径
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param excelPath 需要被转换的excel全路径带文件名
//     * @param pdfPath 转换之后pdf的全路径带文件名
//     */
//    public static void excel2pdf(String excelPath, String pdfPath) {
//        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
//            return;
//        }
//        try {
//            long old = System.currentTimeMillis();
//            Workbook wb = new Workbook(excelPath);// 原始excel路径
//            FileOutputStream fileOS = new FileOutputStream(new File(pdfPath));
//            wb.save(fileOS, com.aspose.cells.SaveFormat.PDF);
//            fileOS.close();
//            long now = System.currentTimeMillis();
////            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param wordPath 需要被转换的word全路径带文件名
//     * @param pdfPath 转换之后pdf的全路径带文件名
//     */
//    public static void doc2pdf(String wordPath, String pdfPath) {
//        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
//            return;
//        }
//        try {
//            long old = System.currentTimeMillis();
//            File file = new File(pdfPath); //新建一个pdf文档
//            FileOutputStream os = new FileOutputStream(file);
//            Document doc = new Document(wordPath); //Address是将要被转化的word文档
//            doc.save(os, com.aspose.words.SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
//            long now = System.currentTimeMillis();
//            os.close();
////            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); //转化用时
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public void addWaterMark(String sourcepath, String respath, String jpgpath) {
//        try {
//            Document document = new Document(sourcepath);
//            asposeUtil.WaterMarkMore(document, jpgpath);
//            //文件输出路径
//            document.save(respath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private static boolean getLicense() {
//        boolean result = false;
//        try {
//            InputStream is = asposeUtil.class.getClassLoader().getResourceAsStream("license.xml"); // license.xml应放在..\WebRoot\WEB-INF\classes路径下
//            System.out.println(is);
//            License aposeLic = new License();
//            aposeLic.setLicense(is);
////            com.aspose.cells.License cell = new com.aspose.cells.License();
////            cell.setLicense(is);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 为word文档添加水印
//     * @param doc word文档模型
//     * @param watermarkText 需要添加的水印字段
//     * @throws Exception
//     */
//    public static void insertWatermarkText(Document doc, String watermarkText) throws Exception {
//        Shape watermark = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);
//        //水印内容
//        watermark.getTextPath().setText(watermarkText);
//        //水印字体
//        watermark.getTextPath().setFontFamily("宋体");
//        //水印宽度
//        watermark.setWidth(100);
//        //水印高度
//        watermark.setHeight(20);
//        //旋转水印
//        watermark.setRotation(-40);
//        //水印颜色 浅灰色
//        watermark.getFill().setColor(Color.lightGray);
//        watermark.setStrokeColor(Color.lightGray);
//        //设置相对水平位置
//        watermark.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);
//        //设置相对垂直位置
//        watermark.setRelativeVerticalPosition(RelativeVerticalPosition.PAGE);
//        //设置包装类型
//        watermark.setWrapType(WrapType.NONE);
//        //设置垂直对齐
//        watermark.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置文本水平对齐方式
//        watermark.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        Paragraph watermarkPara = new Paragraph(doc);
//        watermarkPara.appendChild(watermark);
//        for (Section sect : doc.getSections())
//        {
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_PRIMARY);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_FIRST);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_EVEN);
//        }
//        System.out.println("Watermark Set");
//    }
//    /**
//     * 在页眉中插入水印
//     * @param watermarkPara
//     * @param sect
//     * @param headerType
//     * @throws Exception
//     */
//    private static void insertWatermarkIntoHeader(Paragraph watermarkPara, Section sect, int headerType) throws Exception{
//        HeaderFooter header = sect.getHeadersFooters().getByHeaderFooterType(headerType);
//        if (header == null)
//        {
//            header = new HeaderFooter(sect.getDocument(), headerType);
//            sect.getHeadersFooters().add(header);
//        }
//        header.appendChild(watermarkPara.deepClone(true));
//    }
//
//    /**
//     * 设置水印属性
//     * @param doc
//     * @param wmText
//     * @param left
//     * @param top
//     * @return
//     * @throws Exception
//     */
//    public static Shape ShapeMore(Document doc, String wmText, double left, double top)throws Exception{
////        Shape waterShape = new Shape(doc, ShapeType.TEXT_PLAIN_TEXT);
//        Shape waterShape = new Shape(doc, ShapeType.IMAGE);
//        waterShape.getImageData().setImage(wmText);
//        waterShape.setWidth(100.0);
//        waterShape.setHeight(100.0);
//        waterShape.setRotation(0);
//        waterShape.setFilled(true);
////        //水印内容
////        waterShape.getTextPath().setText(wmText);
////        //水印字体
////        waterShape.getTextPath().setFontFamily("宋体");
////        //水印宽度
////        waterShape.setWidth(40);
////        //水印高度
////        waterShape.setHeight(13);
////        //旋转水印
////        waterShape.setRotation(-40);
//        //水印颜色 浅灰色
//        /*waterShape.getFill().setColor(Color.lightGray);
//        waterShape.setStrokeColor(Color.lightGray);*/
//        waterShape.setStrokeColor(new Color(210,210,210));
//        //将水印放置在页面中心
//        waterShape.setLeft(left);
//        waterShape.setTop(top);
//        //设置包装类型
//        waterShape.setWrapType(WrapType.NONE);
//        return waterShape;
//    }
//
//    /**
//     * 插入多个水印
//     * @param mdoc
//     * @param wmText
//     * @throws Exception
//     */
//    public static void WaterMarkMore(Document mdoc, String wmText)throws Exception{
//        Paragraph watermarkPara = new Paragraph(mdoc);
////        for (int j = 0; j < 500; j = j + 100)
////        {
////            for (int i = 0; i < 700; i = i + 85)
////            {
////                Shape waterShape = ShapeMore(mdoc, wmText, j, i);
////                watermarkPara.appendChild(waterShape);
////            }
////        }
//        Shape waterShape = ShapeMore(mdoc, wmText, 155, 300);
//        watermarkPara.appendChild(waterShape);
//        for (Section sect : mdoc.getSections())
//        {
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_PRIMARY);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_FIRST);
//            insertWatermarkIntoHeader(watermarkPara, sect, HeaderFooterType.HEADER_EVEN);
//        }
//    }
//
//}
