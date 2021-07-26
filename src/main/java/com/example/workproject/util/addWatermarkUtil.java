//package com.example.workproject.util;
//
//import ws.schild.jave.Encoder;
//import ws.schild.jave.EncoderException;
//import ws.schild.jave.MultimediaObject;
//import ws.schild.jave.encode.EncodingAttributes;
//import ws.schild.jave.encode.VideoAttributes;
//import ws.schild.jave.filtergraphs.OverlayWatermark;
//import ws.schild.jave.filters.DrawtextFilter;
//import ws.schild.jave.filters.helpers.Color;
//import ws.schild.jave.filters.helpers.OverlayLocation;
//import ws.schild.jave.info.MultimediaInfo;
//import ws.schild.jave.process.ProcessLocator;
//import ws.schild.jave.process.ProcessWrapper;
//import ws.schild.jave.process.ffmpeg.DefaultFFMPEGLocator;
//import ws.schild.jave.progress.EncoderProgressListener;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//public class addWatermarkUtil {
//    /**
//     * 获取音频基本信息
//     *
//     * @param path 文件路径|URL
//     * @throws EncoderException
//     */
//    public static MultimediaInfo testMediaInfo(String path) throws EncoderException, MalformedURLException {
//        MultimediaObject instance;
//        if (path.startsWith("http")) {
//            instance = new MultimediaObject(new URL(path));
//        } else {
//            instance = new MultimediaObject(new File(path));
//        }
//        return instance.getInfo();
//    }
//
//
//    /**
//     * 视频加图片水印
//     *
//     * @param sourceFile
//     * @param distFile
//     * @param waterMark
//     * @param pListener
//     * @throws EncoderException
//     */
//    public static void codecToMp4WithWaterMark(String sourceFile, String distFile, String waterMark, EncoderProgressListener pListener) throws EncoderException {
//        File sourceVideo = new File(sourceFile);
//        File watermark = new File(waterMark);
//        VideoAttributes vidAttr = new VideoAttributes();
//        vidAttr.addFilter(new OverlayWatermark(watermark, OverlayLocation.BOTTOM_RIGHT, -10, -10));
//        EncodingAttributes encAttr = new EncodingAttributes().setVideoAttributes(vidAttr);
//        File target = new File(distFile);
//        new Encoder().encode(new MultimediaObject(sourceVideo), target, encAttr, pListener);
//    }
//
//
//    /**
//     * 添加文字水印
//     *
//     * @param sourceFile
//     * @param distFile
//     * @param textWaterMark
//     * @param pListener
//     * @throws EncoderException
//     */
//    public static void codecToMp4WithText(String sourceFile, String distFile, String textWaterMark, EncoderProgressListener pListener) throws EncoderException {
//        File sourceVideo = new File(sourceFile);
//        File target = new File(distFile);
//        if (target.exists()) {
//            target.delete();
//        }
//        DrawtextFilter vf = new DrawtextFilter(textWaterMark, "(w-text_w)/2", "(h-text_h)/2", "宋体", 100.0, new Color("ffffff", "44"));
//        vf.setShadow(new Color("000000", "44"), 2, 2);
//        VideoAttributes videoAttributes = new VideoAttributes();
//        videoAttributes.addFilter(vf);
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setVideoAttributes(videoAttributes);
//        Encoder encoder = new Encoder();
//        encoder.encode(new MultimediaObject(sourceVideo), target, attrs, pListener);
//    }
//}
