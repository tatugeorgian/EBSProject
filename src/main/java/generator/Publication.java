package generator;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Publication implements Serializable {

    static double stockMin;
    static double stockMax;
    private Company company;
    private double stockValue;
    private double change;
    private double variation;
    private Date date;
    private UUID uuid;

    public Publication(Company company, double stockValue, double change, Date date) {
        this.company = company;

        if (stockValue > stockMax) {
            this.stockValue = stockMax;
        } else if (stockValue < stockMin) {
            this.stockValue = stockMin;
        } else {
            this.stockValue = stockValue;
        }

        this.change = change;
        this.variation = Math.abs(this.change / this.stockValue);
        this.date = date;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "{" +
                "company=" + company.getCompanyName() +
                ", stockValue=" + stockValue +
                ", change=" + change +
                ", variation=" + variation +
                ", date=" + date.toString() +
                '}' + "\n";
    }

    public Company getCompany() {
        return company;
    }

    public double getStockValue() {
        return stockValue;
    }

    public double getChange() {
        return change;
    }

    public double getVariation() {
        return variation;
    }

    public Date getDate() {
        return date;
    }
}
