package prakhar.developed.quizzing.recyclerViewMCQ;

public class RecyclerViewModel {
    private final String lable;
    private final String optionKey1, optionKey2, optionKey3, optionKey4;

    public RecyclerViewModel(String lable, String optionKey1, String optionKey2, String optionKey3, String optionKey4) {
        this.lable = lable;
        this.optionKey1 = optionKey1;
        this.optionKey2 = optionKey2;
        this.optionKey3 = optionKey3;
        this.optionKey4 = optionKey4;
    }

    public String getLable() {
        return lable;
    }

    public String getOptionKey1() {
        return optionKey1;
    }

    public String getOptionKey2() {
        return optionKey2;
    }

    public String getOptionKey3() {
        return optionKey3;
    }

    public String getOptionKey4() {
        return optionKey4;
    }

}
