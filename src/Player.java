public class Player extends Entity{
    public Player(String name) {
        super(name);
        this.hp = 100;
        this.agility = 10;
        this.gold = 0;
        this.xp = 0;
        this.power = 5;
        this.critical = 5;
    }

    public boolean heal(int hp, int gold) {
        if (gold > this.gold) return false;
        this.gold -= gold;
        this.hp += hp;
        return true;
    }

    public void gainGold(int gold) {
        this.gold += gold;
    }

    public void gainXp(int xp) {
        this.xp += xp;
    }
}
