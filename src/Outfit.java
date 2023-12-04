public class Outfit implements Accessories {
    private boolean equipped=false;
    protected String cloth;
    protected int upHp;
    public Outfit(String cloth){
        this.cloth=cloth;
        this.upHp=calculateUpHp(cloth);
        this.equipped=true;
    }
    @Override
    public int calculateDamage(String cloth){
        return 0;
    }
    @Override
    public int calculateProtect(String cloth){
        return 0;
    }
    @Override
    public int calculateUpHp(String cloth) {
        switch (cloth){
            case "armor","a":
                return 15;
            case "magic cloak","m" :
                return 30;
        }
        return 0;
    }
}
