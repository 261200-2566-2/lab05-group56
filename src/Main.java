// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("How many players do you have : ");
        int n = s.nextInt();
        s.nextLine();
        Player[] players = new Player[n];
        for(int i =0 ; i < n; i++){
            System.out.print("Please enter your name : ");
            String name = s.nextLine();
            System.out.print("Choose your Job [1] Warrior / [2] Mage : ");
            int num = s.nextInt();
            s.nextLine();       //แก้ การข้ามการรับข้อมูล
            System.out.print("What do you want to wearing ? [a] armor / [m] magic cloak : ");
            String cloth = s.nextLine();
//        System.out.print("Choose your equipment [1] sword / [2] staff : ");
//        int numEquip = s.nextLine();
            players[i] = Character.create(name, num);
            players[i].wearing(cloth);
        }

        // แสดงข้อมูลผู้เล่นทั้งหมด
        for (Player player : players) {
            System.out.println("[ " + player.getName() + " " + player.getClass() + " level : " + player.level + " hp : " + player.currentHp +" ]");

        }


        System.out.println("---------------------------");
        players[0].attack(players[1],players[0].getCurrentEquip());
        players[1].changeEquipment("shield");
        players[1].protect(players[1],players[1].getCurrentEquip());
        players[1].changeEquipment("staff");
        players[1].attack(players[0],players[1].getCurrentEquip());
        players[0].attack(players[1],players[0].getCurrentEquip());
        System.out.println(players[0].getName() + "'s hp : " + players[0].currentHp);
        System.out.println(players[1].getName() + "'s hp : " + players[1].currentHp);








        //for test
//        Player a = Character.create("a",1);             //สร้างตัวละคร มีชื่อและอาชีพ แต่ละอาชีพจะมีอาวุธเริ่มต้น
//        Player b = Character.create("b",2);
//        a.attack(b,a.getCurrentEquip());                            //a โจมตี b
//        System.out.println(a.getCurrentEquip().damage);             //ความแรงของวุธ
//        b.protect(a,b.getCurrentEquip());
//        b.attack(a,b.getCurrentEquip());
//        b.changeEquipment("shield");                        //เปลี่ยนอาวุธ
//        System.out.println(b.getCurrentEquip().weapon);             //เช้คว่าปัจจุบันใส่อะไร
//        b.protect(a,b.getCurrentEquip());
//        System.out.println(a.currentHp);                            //เช็คเลือด
//        System.out.println(b.currentHp);
//        a.wearing("armor");
//        b.wearing("armor");
//        System.out.println(a.currentHp);
//        System.out.println(b.currentHp);
//        b.wearing("magic clock");
//        System.out.println(a.currentHp);
//        System.out.println(b.currentHp);


    }
    //refer chatgpt https://chat.openai.com/share/0520ca72-f7ab-45a1-b399-232e7c7344c4
}