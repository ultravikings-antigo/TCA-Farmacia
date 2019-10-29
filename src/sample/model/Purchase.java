package sample.model;

import java.util.Date;

public class Purchase {

    private int id;
    private Provider provider;
    private Date date;
    private Float totalValue;

    public Purchase(int id, Provider provider, Date date, Float totalValue) {
        this.id = id;
        this.provider = provider;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Purchase(Provider provider, Date date, Float totalValue) {
        this.provider = provider;
        this.date = date;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Float totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "PurchaseDAO{" +
                "id=" + id +
                ", provider=" + provider +
                ", date=" + date +
                ", totalValue=" + totalValue +
                '}';
    }
}
