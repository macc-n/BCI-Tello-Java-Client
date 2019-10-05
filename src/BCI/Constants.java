package BCI;

class Constants {
    private static final String[] actions = {
            "move-up",
            "move-down",
            "move-left",
            "move-right",
            "move-forward",
            "move-backward",
            "rotate-left",
            "rotate-right",
            "take-off",
            "land"};

    public static String getAction(int index) {
        return actions[index];
    }

    public static String[] getActions() {
        return actions;
    }
}
