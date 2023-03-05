package model;

public class Request {

    private String filePath;

    private boolean showStatistic;

    private int colorsLimit;

    public Request(String filePath, boolean showStatistic, int colorsLimit) {
        this.filePath = filePath;
        this.showStatistic = showStatistic;
        this.colorsLimit = colorsLimit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isShowStatistic() {
        return showStatistic;
    }

    public void setShowStatistic(boolean showStatistic) {
        this.showStatistic = showStatistic;
    }

    public int getColorsLimit() {
        return colorsLimit;
    }

    public void setColorsLimit(int colorsLimit) {
        this.colorsLimit = colorsLimit;
    }
}