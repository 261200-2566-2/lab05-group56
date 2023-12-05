public class Player implements Character{
    private String name;
    protected int currentHp;
    protected int level;
    private Equipment currentEquip;
    private Outfit currentCloth;
    private double exp;
    public Player(String name,Equipment equipment){
        this.name=name;
        this.currentHp=calculateMaxHp();
        this.level=0;
        this.currentEquip=equipment;
        this.currentCloth=null;
        this.exp=0;
    }
    public void gainExp(double amount){
        this.exp +=amount;
        checklevelUp();

    }
    private void checklevelUp(){
        if(exp>=100){
            level++;
            exp=0; //reset
            currentHp=calculateMaxHp();
            System.out.println(name+" level up "+ level +" !");
        }
    }
    public Outfit wearing(String cloth){
        Outfit outfit = new Outfit(cloth);
        if(("a".equalsIgnoreCase(cloth) && this.getClass()==Warrior.class)
                || ("m".equalsIgnoreCase(cloth) && this.getClass()==Mage.class)) {
            currentHp += outfit.upHp;
            if (currentHp > calculateMaxHp()) {
                currentHp = calculateMaxHp();
            }
        }
        currentCloth=outfit;
        if(outfit.cloth.equals("a") || outfit.cloth.equals("armor")) {
            System.out.println(this.name + " is wearing armor" + " hp +" + outfit.upHp);
            System.out.println("---------------------------");
        }else if (outfit.cloth.equals("m") || outfit.cloth.equals("magic cloak")){
            System.out.println(this.name + " is wearing magic cloak" + " hp +" + outfit.upHp);
            System.out.println("---------------------------");
        }else{
            System.out.println("Not found this cloth");
            System.out.println("---------------------------");
        }
        return outfit;
    }
    public String getName(){
        return name;
    }
    public Equipment getCurrentEquip(){
        return currentEquip;
    }
    public void changeEquipment(String newEquip){
        this.currentEquip=new Equipment(newEquip);

    }
    public void receiveDamage(int damage){
        currentHp -= damage;
        if(currentHp<=0){
            currentHp=0;
            System.out.println("die");
        }
    }
    public void decreaseDamage(int protect){
        currentHp += protect;
        if(currentHp>calculateMaxHp()){
            currentHp=calculateMaxHp();
        }
    }
    @Override
    public int calculateMaxHp(){return 100;}
    @Override
    public void attack(Player target,Equipment currentEquip){
        gainExp(20);
        int damage = currentEquip.damage;
        target.receiveDamage(damage);
        System.out.println(target.getName() +" was attacked" + " -" + damage);
        System.out.println("---------------------------");
    }
    @Override
    public void protect(Player target,Equipment currentEquip){
        gainExp(15);
        int protect =currentEquip.protect;
        target.decreaseDamage(protect);
        System.out.println(target.getName() +" was protected" + " +" + protect);
        System.out.println("---------------------------");
    }
}
class Warrior extends Player {
    private String sword;
    public Warrior(String name,String sword){    //name->player
        super(name,new Equipment(sword));
        this.sword=sword;
        super.currentHp=calculateMaxHp();       //warrior hp>default
    }
    @Override
    public int calculateMaxHp(){
        return 100 + 15*level;
    }
}
class Mage extends Player {
    private String staff;
    public Mage(String name,String staff){
        super(name,new Equipment(staff));
        this.staff=staff;
        super.currentHp=calculateMaxHp();          //mage hp<default
    }
    @Override
    public int calculateMaxHp(){
        return 100 + 5*level;
    }
}
