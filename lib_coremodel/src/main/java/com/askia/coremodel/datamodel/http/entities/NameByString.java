package com.askia.coremodel.datamodel.http.entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create bt she:
 *
 * @date 2020/9/23
 */
public class NameByString implements Serializable {

    private String name;
    private String code;
    private String card;

    public NameByString(String msgs) {
        int index = msgs.indexOf("_");
        int lasindex = msgs.lastIndexOf("_");
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(msgs);
        if (index == lasindex) {
            if (index == -1) {
                this.name = msgs;
                this.code = msgs;
                this.card = "";
            } else {
                if (m.find()) {
                    this.name = msgs.substring(0, index);
                    this.code = msgs.substring(index);
                    this.card = "";
                } else {
                    this.name = msgs.substring(0, index);
                    this.code = msgs.substring(0, index);
                    this.card = msgs.substring(index);
                }
            }
        } else {
            this.name = msgs.substring(0, index);
            this.code = msgs.substring(index, lasindex);
            this.card = msgs.substring(lasindex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
