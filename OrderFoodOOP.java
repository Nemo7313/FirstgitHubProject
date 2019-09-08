
import java.util.ArrayList;
import java.util.Scanner;

public class OrderFoodOOP {
    public static void main(String[] args) {
        Order oder1 = new Order("张晴","红烧牛肉面 1份",12,"永安里15号楼",
                1,36.0);
        Order oder2 = new Order("李雯","烤肉拌饭 2份",14,"科原大厦304房间",
                0,38.0);
        ArrayList<Order> orders= new ArrayList<Order>();
        orders.add(oder1);
        orders.add(oder2);

        Food food1 = new Food("红烧牛肉面",32.0,0);
        Food food2 = new Food("烤肉拌饭",17.0,0);
        Food food3 = new Food("过桥米线",12.0,0);
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        Business business = new Business();

        int num = -1;//记录用户返回主菜单时输入的数字
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用”吃货联盟订餐系统“");
        do{
            business.showMainMenu();
            System.out.print("请选择： ");
            int choose = input.nextInt();
            switch(choose){
                case 1:
                    System.out.println("*******我要订餐*********");
                    business.newOrder(orders,foods);
                    break;
                case 2:
                    System.out.println("*******查看餐袋*********");
                    business.showOrders(orders);
                    break;
                case 3:
                    System.out.println("*******签收订单*********");
                    business.signOrder(orders);
                    break;
                case 4:
                    System.out.println("*******删除订单*********");
                    business.delOrder(orders);
                    break;
                case 5:
                    System.out.println("*******我要点赞*********");
                    business.showFoods(foods);
                    business.addPraise(foods);
                    break;
                case 6:
                    break;
                default:
                    break;
            }
            if(choose==6){
                break;
            }else{
                System.out.println("请输入0返回主菜单： ");
                num = input.nextInt();
            }
        }while(num==0);
        System.out.println("谢谢使用，欢迎下次光临！");
    }
}
