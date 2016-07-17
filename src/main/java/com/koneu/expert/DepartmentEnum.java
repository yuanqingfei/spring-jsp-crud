package com.koneu.expert;

/**
 * Created by aaron on 16-7-9.
 */
public enum DepartmentEnum {

    HEART(1, "心血管科"),
    BRAIN(2, "脑血管科"),
    DIGESTION(3, "消化科"),
    BREATH(4, "呼吸科"),
    TUMOR(5, "肿瘤科"),
    KIDNEY(6, "肾内科"),
    BONE(8, "骨科"),
    FACIAL(9, "五官科"),
    WOMEN(10, "妇科"),
    CHILDREN(11, "儿科"),
    CHINESE(12, "中医科"),
    LIVER(13, "肝胆外科"),
    URINARY(14, "泌尿外科"),
    ANORECTAL(15, "肛肠科"),
    MAMMARY(16, "乳腺科");


    private int id;

    private String name;

    DepartmentEnum(int id, String name){
        this.id = id;
        this.name = name;
    }
}
