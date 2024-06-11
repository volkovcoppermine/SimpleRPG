public abstract class Entity {
    protected String name;
    protected int hp; //Здоровье
    protected int gold; //Золото
    protected int agility; //Ловкость
    protected int xp; //Опыт
    protected int power; //Сила атаки

    protected int critical; //Шанс критического удара (1 к critical)

    public int getHp() {
        return hp;
    }

    public int getGold() {
        return gold;
    }

    public int getXp() {
        return xp;
    }

    public Entity(String name) {
        this.name = name;
    }

    public int attack() {
        if ((int)(Math.round(Math.random() * critical)) == critical) return power * 2;
        return agility * 3 > (int)Math.round((Math.random() * 100)) ? power : 0;
    }

    public void damage(int damage) {
        this.hp = damage > hp ? 0 : hp - damage;
    }
}
