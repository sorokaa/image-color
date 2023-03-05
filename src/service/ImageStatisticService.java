package service;

import static java.util.Collections.reverseOrder;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import model.DetailedImageStatistic;
import model.ImageStatistic;
import model.Request;

public class ImageStatisticService {

    public ImageStatistic parse(Request request) throws IOException {
        File file = new File(request.getFilePath());
        BufferedImage image = ImageIO.read(file);
        Rectangle imageBounds = image.getRaster().getBounds();
        long pixelsWatched = 0;
        Map<String, Long> colors = new HashMap<>();
        for (int i = 0; i < imageBounds.width; i++) {
            for (int j = 0; j < imageBounds.height; j += 2) {
                if ((i + j) % 2 == 0) {
                    int rgbColor = image.getRGB(i, j);
                    String hexColor = toRgbHex(Integer.toHexString(rgbColor));
                    colors.put(hexColor, colors.getOrDefault(hexColor, 0L) + 1);
                    pixelsWatched++;
                }
            }
        }
        ImageStatistic imageStatistic;
        if (request.isShowStatistic()) {
            Map<String, Double> statistic = getColorsStatistic(colors, pixelsWatched, request.getColorsLimit());
            imageStatistic = new DetailedImageStatistic(
                new HashMap<>(),
                statistic
            );

        } else {
            imageStatistic = new ImageStatistic();
        }
        imageStatistic.setDistinctColors((long) colors.size());
        imageStatistic.setColorPixelsCount(colors);
        return imageStatistic;
    }

    private String toRgbHex(String argb) {
        argb = argb.toUpperCase();
        int argbValue = Integer.parseUnsignedInt(argb, 16);
        int red = (argbValue >> 16) & 0xFF;
        int green = (argbValue >> 8) & 0xFF;
        int blue = argbValue & 0xFF;
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    private Map<String, Double> getColorsStatistic(Map<String, Long> colors, Long pixels, int limit) {
        Map<String, Double> result = colors.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> getValueInPercent(Double.valueOf(e.getValue()), pixels)
            ));
        result = result.entrySet().stream()
            .sorted(reverseOrder(Map.Entry.comparingByValue()))
            .limit(limit)
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> v1,
                LinkedHashMap::new
            ));
        return result;
    }

    private Double getValueInPercent(Double value, Long allValues) {
        return (value * 100) / allValues;
    }
}