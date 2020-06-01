package generator;

import java.util.Date;

public class SubscriptionGenerationParams {

    private PublicationGenerationParams publicationParams;
    private double companyPercentage = 0.5D;
    private double stockValuePercentage = 0.5D;
    private double changePercentage = 0.5D;
    private double variationPercentage = 0.5D;
    private double datePercentage = 0.5D;
    private Date endDate;
    private int subscriptionCount = 3000;
    private double equalCompanyPercentage = 0.5D;

    public SubscriptionGenerationParams(PublicationGenerationParams publicationParams, Date endDate) {
        this.publicationParams = publicationParams;
        this.endDate = endDate;
    }

    public SubscriptionGenerationParams(PublicationGenerationParams publicationParams, double companyPercentage,
                                        double stockValuePercentage, double changePercentage, double variationPercentage,
                                        double datePercentage, Date endDate, int subscriptionCount, double equalCompanyPercentage) {
        this.publicationParams = publicationParams;
        this.companyPercentage = companyPercentage;
        this.stockValuePercentage = stockValuePercentage;
        this.changePercentage = changePercentage;
        this.variationPercentage = variationPercentage;
        this.datePercentage = datePercentage;
        this.endDate = endDate;
        this.subscriptionCount = subscriptionCount;
        this.equalCompanyPercentage = equalCompanyPercentage;
        validatePercentages();
    }

    private void validatePercentages() {
        if (companyPercentage + stockValuePercentage + changePercentage + variationPercentage + datePercentage < 1) {
            throw new RuntimeException("Percentage sum is not over 1");
        }
    }

    double getCompanyPercentage() {
        return companyPercentage;
    }

    public void setCompanyPercentage(double companyPercentage) {
        this.companyPercentage = companyPercentage;
        validatePercentages();
    }

    double getStockValuePercentage() {
        return stockValuePercentage;
    }

    public void setStockValuePercentage(double stockValuePercentage) {
        this.stockValuePercentage = stockValuePercentage;
        validatePercentages();
    }

    double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(double changePercentage) {
        this.changePercentage = changePercentage;
        validatePercentages();
    }

    double getVariationPercentage() {
        return variationPercentage;
    }

    public void setVariationPercentage(double variationPercentage) {
        this.variationPercentage = variationPercentage;
        validatePercentages();
    }

    double getDatePercentage() {
        return datePercentage;
    }

    public void setDatePercentage(double datePercentage) {
        this.datePercentage = datePercentage;
        validatePercentages();
    }

    PublicationGenerationParams getPublicationParams() {
        return publicationParams;
    }

    public void setPublicationParams(PublicationGenerationParams publicationParams) {
        this.publicationParams = publicationParams;
    }

    Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    int getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    double getEqualCompanyPercentage() {
        return equalCompanyPercentage;
    }

    public void setEqualCompanyPercentage(double equalCompanyPercentage) {
        this.equalCompanyPercentage = equalCompanyPercentage;
    }
}
