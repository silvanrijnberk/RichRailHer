package UI;

public class UIEngineer {
    private UIBuilder uiBuilder;

    public UIEngineer(UIBuilder uiBuilder) {
        this.uiBuilder = uiBuilder;
    }

    public UI getUI() {
        return uiBuilder.getUi();
    }

    public void makeUI() {
        uiBuilder.buildCommanPanel();
        uiBuilder.buildWagonsPanel();
        uiBuilder.buildExecutePanel();
        uiBuilder.buildListener();
        uiBuilder.buildDraw();
    }
}
