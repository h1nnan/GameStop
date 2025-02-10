public class Game {
    private double price;
    private String name;
    private String devs;
    private boolean inStock;
    private String Rating;

    public Game(String name, double price, String devs, boolean inStock) {
        this.name = name;
        this.price = price;
        this.devs = devs;
        this.inStock = inStock;
        this.Rating = Rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevs() {
        return devs;
    }

    public void setDevs(String devs) {
        this.devs = devs;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }
}
