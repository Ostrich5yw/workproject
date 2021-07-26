package com.example.workproject;

//import com.example.workproject.util.asposeUtil;
//import org.junit.jupiter.api.Test;
import com.example.workproject.util.mkDirUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import ws.schild.jave.EncoderException;
//import ws.schild.jave.info.MultimediaInfo;
//import ws.schild.jave.progress.EncoderProgressListener;
//import com.example.workproject.util.addWatermarkUtil;


@SpringBootTest
public class TestUtils {
    @Test
    public void test() {
        mkDirUtil.mkJsonFile("wohao", "file", "D:\\mapdirconfig");
    }
}
//    @Test
//    public void testaspose() {
//        String sourcepath = "C:\\Users\\PanGPanG5\\Desktop\\TestUtils.doc";
//        String respath = "C:\\Users\\PanGPanG5\\Desktop\\new.doc";
//        String pdfpath = "C:\\Users\\PanGPanG5\\Desktop\\new.pdf";
//        String jpgpath = "C:\\Users\\PanGPanG5\\Desktop\\LiGongDa.png";
//        asposeUtil asposeUtil = new asposeUtil();
////        asposeUtil.addWaterMark(sourcepath, respath, jpgpath);
//        asposeUtil.toPdf(respath, pdfpath);
//
//    }
//
////    @TestService
////    public void TestUtils() throws MalformedURLException, EncoderException {
////            String sourceFile = "C:\\Users\\PanGPanG5\\Desktop\\TestUtils.mp4";
////            String distFile = "C:\\Users\\PanGPanG5\\Desktop\\res.mp4";
////            String waterMark = "C:\\Users\\PanGPanG5\\Desktop\\tt.jpg";
////            //测试获取视频信息
////            MultimediaInfo info = addWatermarkUtil.testMediaInfo(sourceFile);
//////            System.out.println(JSON.toJSONString(info));
////            addWatermarkUtil.codecToMp4WithWaterMark(sourceFile, distFile, waterMark,new EncoderProgressListener() {
////                @Override
////                public void sourceInfo(MultimediaInfo info) {
////    //                    System.out.println(JSON.toJSONString(info));
////                }
////                @Override
////                public void progress(int permil) {
////                    System.out.println(permil);
////                }
////                @Override
////                public void message(String message) {
////                    System.out.println(message);
////                }
////            });
////
////            addWatermarkUtil.codecToMp4WithText(sourceFile, distFile,"wwwwwwwwwwwwwwwwww",new EncoderProgressListener() {
////                @Override
////                public void sourceInfo(MultimediaInfo info) {
//////                    System.out.println(JSON.toJSONString(info));
////                }
////                @Override
////                public void progress(int permil) {
////                    System.out.println(permil);
////                }
////                @Override
////                public void message(String message) {
////                    System.out.println(message);
////                }
////            });
////        addWatermarkUtil.codecToMp4WithText(distFile, sourceFile,"LLLLLLLLLLLLLLL",new EncoderProgressListener() {
////            @Override
////            public void sourceInfo(MultimediaInfo info) {
//////                    System.out.println(JSON.toJSONString(info));
////            }
////            @Override
////            public void progress(int permil) {
////                System.out.println(permil);
////            }
////            @Override
////            public void message(String message) {
////                System.out.println(message);
////            }
////        });
////        }
//}
