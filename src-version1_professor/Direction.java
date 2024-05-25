public enum Direction {
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
    IDLE {
        @Override
        public String toString() {
            return "0";
        }
    },
}
