package paularnold;

public class Service {

    int id;
    String name;
    String description;
    Double price;

    public Service(String name, String description, Double price) {
        //id is generated
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public String getPriceAsString(){
        return String.valueOf(getPrice());
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}