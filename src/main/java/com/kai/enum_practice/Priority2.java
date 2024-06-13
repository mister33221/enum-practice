package com.kai.enum_practice;

import static java.lang.String.format;

public enum Priority2 {
    MAX(10) {
        public String toString() {
            return format("最高(%2d)", value);
        }
    },
    HIGH(8) {
        public String toString() {
            return format("高(%2d)", value);
        }
    },
    MEDIUM(5) {
        public String toString() {
            return format("中(%2d)", value);
        }
    },
    LOW(3) {
        public String toString() {
            return format("低(%2d)", value);
        }
    },
    MIN(1) {
        public String toString() {
            return format("最低(%2d)", value);
        }
    };

    protected int value; // 儲存優先權值

    Priority2(int value) {  // 不為 public 的建構子
        this.value = value;
    }

    public int getValue() { // 自定義方法
        return value;
    }

    public static void main(String[] args) {
        for (Priority2 priority : Priority2.values()) {
            System.out.println(priority);
        }
    }
}
