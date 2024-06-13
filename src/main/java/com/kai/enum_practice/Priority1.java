package com.kai.enum_practice;

public enum Priority1 {
    MAX(10), HIGH(8), MEDIUM(5), LOW(3), MIN(1);  // 呼叫建構子

    private int value; // 儲存優先權值

    Priority1(int value) {  // 不為 public 的建構子
        this.value = value;
    }

    public int getValue() { // 自定義方法
        return value;
    }

    public static void main(String[] args) {
        for (Priority1 priority : Priority1.values()) {
            System.out.println(priority + " : " + priority.getValue());
        }
    }
}
