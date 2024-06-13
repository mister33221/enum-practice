package com.kai.enum_practice;

public enum Action1 implements Command{
    START, STOP, JUMP, SIT, RUN, WALK, SLEEP, EAT, DRINK, THINK;


    @Override
    public void execute() {
        switch (this) {
            case START -> System.out.println("開始");
            case STOP -> System.out.println("停止");
            case JUMP -> System.out.println("跳躍");
            case SIT -> System.out.println("坐下");
            case RUN -> System.out.println("跑步");
            case WALK -> System.out.println("走路");
            case SLEEP -> System.out.println("睡覺");
            case EAT -> System.out.println("吃飯");
            case DRINK -> System.out.println("喝水");
            case THINK -> System.out.println("思考");
            default -> System.out.println("無法辨識");
        }
    }

    public static void main(String[] args) {
        for (Action1 action : Action1.values()) {
            action.execute();
        }
    }
}
