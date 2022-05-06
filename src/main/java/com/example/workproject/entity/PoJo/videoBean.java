package com.example.workproject.entity.PoJo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("videostable")
public class videoBean {
    private String dwdm;
    private String dwmc;
    private long znjgdm;
    private String znjgmc;
    private long znjgfzdm;
    private String znjgfzmc;
    private long czydm;
    private String czymc;
    private long assetid;
    private String assettype;
    private String assetname;
    private String asseturl;
    private String assetscsj;
    private String assetcjsj;
    private String assetscxgsj;
    private String assetfldm;
    private String assettc;
    private String assetyz;
    private String assetzy;
    private long assetmj;
    private long assetsybz;
    private long assetzfbz;
    private long assetsize;
    private long assetbqbz;
    private long assetxzbz;
    private long assetshbz;
    private long assetdacbz;
    private long videowidth;
    private long videoheigh;
    private long samplerate;
    private String channeltype;
    private long totaltime;
    private long xcspbz;
    private long zmbz;
    private String zmyy;
}
