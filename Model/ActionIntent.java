package Model;

public enum ActionIntent {
    ACCIDENTALLY {
        @Override
        public String toString() {
            return "случайно";
        }
    },
    ESPECIALLY {
        @Override
        public String toString() {
            return "специально";
        }
    };
}
