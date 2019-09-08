
import java.util.ArrayList;
import java.util.Scanner;

public class Business {

    Scanner input = new Scanner(System.in);

    public void showOrders(ArrayList<Order> orders){
        System.out.println("序号\t订餐人\t\t餐品信息\t\t送餐日期\t送餐地址\t\t总金额\t\t订单状态");
        for(int i=0; i<orders.size();i++) {
            String status_Megs = (orders.get(i).status==0)?"已预定":"已完成";
            String time = orders.get(i).time+"点";
            String sumPrice = orders.get(i).sumPrice+"元";
            System.out.printf("%-5d\t%-5s\t%-5s\t\t%-5s\t\t%-10s\t%-5s\t\t%-5s\t\n",
                    i+1, orders.get(i).name, orders.get(i).dishMeg, time, orders.get(i).address,
                    sumPrice, status_Megs);
        }
    }

    public void showMainMenu(){
        System.out.println("***********************************");
        System.out.println("1, 我要订餐");
        System.out.println("2, 查看餐袋");
        System.out.println("3, 签收订单");
        System.out.println("4, 删除订单");
        System.out.println("5, 我要点赞");
        System.out.println("6, 退出系统");
        System.out.println("***********************************");
    }

    public void showFoods(ArrayList<Food> foods){
        System.out.printf("%-3s\t%-5s\t%-3s\t%-3s\n","序号","餐品名","单价","点赞数");
        for(int i=0; i<foods.size(); i++){
            String price = foods.get(i).price + "元";
            String praise = foods.get(i).praiseNum + "赞";
            System.out.printf("%-3d\t\t%-5s\t%-3s\t%-3s\n", i + 1, foods.get(i).dishName , price , praise);
        }
    }

    public void addPraise(ArrayList<Food> foods){
        System.out.print("请选择要点赞餐品的序号：");
        int num = input.nextInt();
        if(num>0 && num<=foods.size()) {
            foods.get(num - 1).praiseNum += 1;
            System.out.println("点赞成功！");
        }else{
            System.out.println("您所选择的餐品不存在");
        }
    }

    public void delOrder(ArrayList<Order> orders){
        System.out.print("请选择要删除的订单序号：");
        int num = input.nextInt();
        if(num<0 || num>orders.size()){
            System.out.println("您所选择的订单不存在！");
        } else if(orders.get(num-1).status==1) {
            System.out.println("已成功删除能选择的订单！");
            orders.remove(num-1);
        } else if(orders.get(num-1).status==0){
            System.out.println("不能删除未签收的订单！");
        }
    }

    public void signOrder(ArrayList<Order> orders){
        System.out.print("请选择要签收的订单序号：");
        int num = input.nextInt();

        if(num<0 || num>orders.size()){
            System.out.println("您所选择的订单不存在！");
        } else if(orders.get(num-1).status==1) {
            System.out.println("您选择的订单已完成签收，不能再次签收！");
        } else if(orders.get(num-1).status==0){
            System.out.println("您选择的订单已完成签收！");
            orders.get(num-1).status = 1;
        }

    }

    public void newOrder(ArrayList<Order> orders, ArrayList<Food> foods){
        showFoods(foods);
        Order newOrder = new Order();

        //获得订餐的餐品信息
        System.out.print("请选择餐品所定序号： ");
        int chooseDish = input.nextInt();
        System.out.print("请选择餐品所定份数： ");
        int chooseDishNum = input.nextInt();
        String dishMeg = foods.get(chooseDish-1).dishName + " " + chooseDishNum + "份";
        newOrder.dishMeg = dishMeg;

        //获得订餐人的姓名
        System.out.print("请填写订餐人姓名： ");
        String orderName = input.next();
        newOrder.name = orderName;

        //获得正确的配送时间
        int time = inputTime();
        newOrder.time = time;

        //获得配送地址
        System.out.print("请填写配送地址： ");
        String orderAdress = input.next();
        newOrder.address = orderAdress;

        //总金额 = 单价*份数  配送费为4元，餐品金额大于40元则免配送费
        int peiSong = 4;
        double dishPrice = foods.get(chooseDish-1).price * chooseDishNum;
        if (dishPrice > 40) {
            peiSong = 0;
        }
        double sumprice = dishPrice + peiSong;
        newOrder.sumPrice = sumprice;

        //订餐成功，显示餐品信息
        System.out.println("订餐成功！");
        System.out.println("您订单的餐品信息是：" + newOrder.dishMeg);
        System.out.println("订餐人：" + newOrder.name);
        System.out.println("配送时间：" + newOrder.time+"点");
        System.out.println("配送地址：" + newOrder.address);
        System.out.println("总金额为： " + newOrder.sumPrice+"元，配送费为："+peiSong+"元");

        orders.add(newOrder);
    }

    public int inputTime(){
        int orderTime;
        boolean flag = false;
        do {
            System.out.print("请填写订餐配送时间(10~20点整点配送)： ");
            orderTime = input.nextInt();
            if (orderTime < 10 || orderTime > 20) {
                System.out.println("对不起，请重新输入配送时间");
                flag = true;
            }else{
                flag = false;
            }
        } while (flag);
        return orderTime;
    }
}
