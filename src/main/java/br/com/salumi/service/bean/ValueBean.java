package br.com.salumi.service.bean;

public class ValueBean {

    private int key;
    private String value;

    public ValueBean() {
    }

    public ValueBean(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
