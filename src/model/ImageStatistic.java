package model;

import java.util.HashMap;
import java.util.Map;

public class ImageStatistic {

    private Long distinctColors;

    private Map<String, Long> colorPixelsCount = new HashMap<>();

    public ImageStatistic() {
        colorPixelsCount = new HashMap<>();
    }

    public ImageStatistic(Map<String, Long> colorPixelsCount) {
        this.colorPixelsCount = colorPixelsCount;
    }

    public Map<String, Long> getColorPixelsCount() {
        return colorPixelsCount;
    }

    public void setColorPixelsCount(Map<String, Long> colorPixelsCount) {
        this.colorPixelsCount = colorPixelsCount;
    }

    public Long getDistinctColors() {
        return distinctColors;
    }

    public void setDistinctColors(Long distinctColors) {
        this.distinctColors = distinctColors;
    }
}