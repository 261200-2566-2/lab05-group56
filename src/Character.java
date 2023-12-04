public interface Character {
    int calculateMaxHp();
    static Player create(String name,int listJob){
        Player player;
        switch (listJob){
            case 1:
                player = new Warrior(name,"sword");
                break;
            case 2:
                player = new Mage(name,"staff");
                break;
            default:
                throw new IllegalArgumentException("Invalid");          //ถ้าค่าที่ส่งเข้ามาไม่ใช่ 1 2
        }
        System.out.println("Your character is created !!!");
        return player;
    }
    void attack(Player target,Equipment currentEquip);
    void protect(Player target,Equipment currentEquip);

}
