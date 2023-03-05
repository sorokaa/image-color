package model;

import java.util.HashMap;
import java.util.Map;

public class DetailedImageStatistic extends ImageStatistic {

    private Map<String, Double> colorsInPercentageStatistic = new HashMap<>();

    public DetailedImageStatistic() {
        super(new HashMap<>());
    }

    public DetailedImageStatistic(Map<String, Long> colorPixelsCount, Map<String, Double> colorsInPercentageStatistic) {
        super(colorPixelsCount);
        this.colorsInPercentageStatistic = colorsInPercentageStatistic;
    }

    public Map<String, Double> getColorsInPercentageStatistic() {
        return colorsInPercentageStatistic;
    }

    public void setColorsInPercentageStatistic(Map<String, Double> colorsInPercentageStatistic) {
        this.colorsInPercentageStatistic = colorsInPercentageStatistic;
    }
}