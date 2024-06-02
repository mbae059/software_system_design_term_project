package theClasses;

public enum ElevatorDirection {
    UP {
        @Override
        public String toString() {
            return "1";
        }
    },
    DOWN {
        @Override
        public String toString() {
            return "-1";
        }
    },
    STOP {
        @Override
        public String toString() {
            return "0";
        }
    },
}
