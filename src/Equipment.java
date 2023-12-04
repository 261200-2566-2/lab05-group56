public class Equipment implements Accessories{
    private boolean equipped=false;
    protected String weapon;
    protected int damage=10;
    protected int protect=5;    //default damage=10 protect=5
    public Equipment(String weapon){
        this.equipped=true;
        this.weapon=weapon;
        this.damage=calculateDamage(weapon);
        this.protect=calculateProtect(weapon);
    }
    @Override
    public int calculateDamage(String weapon){
        switch (weapon){
            case "sword","Sword" :
                return damage+15;
            case "staff","Staff" :
                return damage+10;
        }
        return 0;
    }
    @Override
    public int calculateProtect(String weapon){
        switch (weapon){
            case "shield","Shield" :
                return protect+5;
        }
        return 0;
    }
    @Override
    public int calculateUpHp(String weapon){
        return 0;
    }

}
