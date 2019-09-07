package ChihuoLianMeng;

public class Order {
    String name;
    String dishMeg;
    int time;
    String address;
    int statu;
    double sumPrice;

    public Order(){}
    public Order(String name, String dishMeg, int time, String address, int statu, double sumPrice) {
        this.name = name;
        this.dishMeg = dishMeg;
        this.time = time;
        this.address = address;
        this.statu = statu;
        this.sumPrice = sumPrice;
    }

}
