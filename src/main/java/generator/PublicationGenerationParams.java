package generator;

import java.util.Calendar;
import java.util.Date;

public class PublicationGenerationParams {

    private double minStockValue = 0D;
    private double maxStockValue = 1000D;
    private Date startingDate;
    private int daysBetween = 1;
    private int publicationCount = 10000;
    private double maxChangePercentage = 0.1D;

    public PublicationGenerationParams(double minStockValue, double maxStockValue, Date startingDate,
                                       int daysBetween, int publicationCount, double maxChangePercentage) {
        this.minStockValue = minStockValue;
        this.maxStockValue = maxStockValue;
        this.startingDate = startingDate;
        this.daysBetween = daysBetween;
        this.publicationCount = publicationCount;
        this.maxChangePercentage = maxChangePercentage;
    }

    public PublicationGenerationParams() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        startingDate = new Date(calendar.getTimeInMillis()); // 1 jan 2000
    }

    double getMinStockValue() {
        return minStockValue;
    }

    double getMaxStockValue() {
        return maxStockValue;
    }

    Date getStartingDate() {
        return startingDate;
    }

    int getDaysBetween() {
        return daysBetween;
    }

    int getPublicationCount() {
        return publicationCount;
    }

    double getMaxChangePercentage() {
        return maxChangePercentage;
    }
}
