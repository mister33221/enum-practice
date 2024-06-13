package com.kai.enum_practice;

public enum Action2 implements Command{
//    特別值類別本體(Value-specific class body)語法??
    START {
        public void execute() {
            System.out.println("開始");
        }
    },
    STOP {
        public void execute() {
            System.out.println("停止");
        }
    },
    JUMP {
        public void execute() {
            System.out.println("跳躍");
        }
    },
    SIT {
        public void execute() {
            System.out.println("坐下");
        }
    },
    RUN {
        public void execute() {
            System.out.println("跑步");
        }
    },
    WALK {
        public void execute() {
            System.out.println("走路");
        }
    },
    SLEEP {
        public void execute() {
            System.out.println("睡覺");
        }
    },
    EAT {
        public void execute() {
            System.out.println("吃飯");
        }
    },
    DRINK {
        public void execute() {
            System.out.println("喝水");
        }
    },
    THINK {
        public void execute() {
            System.out.println("思考");
        }
    },
    UNKNOWN {
        public void execute() {
            System.out.println("無法辨識");
        }
    };

    public static void main(String[] args) {
        for (Action2 action : Action2.values()) {
            action.execute();
        }
    }


}
