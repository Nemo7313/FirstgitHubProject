
public class Order {
    String name;
    String dishMeg;
    int time;
    String address;
    int status;
    double sumPrice;

    public Order(){}
    public Order(String name, String dishMeg, int time, String address, int status, double sumPrice) {
        this.name = name;
        this.dishMeg = dishMeg;
        this.time = time;
        this.address = address;
        this.status = status;
        this.sumPrice = sumPrice;
    }

}
