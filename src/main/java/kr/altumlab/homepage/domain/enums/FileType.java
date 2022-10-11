package kr.altumlab.homepage.domain.enums;

import kr.altumlab.homepage.enumer.BaseEnum;

public enum FileType implements BaseEnum {
    IMAGE("이미지"), ATTACH("첨부파일");

    String descr;

    private FileType(String descr) {
        this.descr = descr;
    }

    @Override
    public String getDescr() {
        return this.descr;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
