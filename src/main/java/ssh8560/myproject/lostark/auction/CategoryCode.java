package ssh8560.myproject.lostark.auction;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryCode {
    아뮬렛(170300),
    무기(180000),
    투구(190010),
    상의(190020),
    하의(190030),
    장갑(190040),
    어깨(190050),
    장비(10000),
    어빌리티스톤(30000),
    목걸이(200010),
    귀걸이(200020),
    반지(200030),
    팔찌(200040),
    장신구(200000),
    보석(210000);

    private final int code;

    CategoryCode(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
