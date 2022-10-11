package kr.altumlab.homepage.domain.enums;

import kr.altumlab.homepage.enumer.BaseEnum;

public enum BoardType implements BaseEnum {
    BOARD("게시판"),
    ;

    String descr;

    private BoardType(String descr) {
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
