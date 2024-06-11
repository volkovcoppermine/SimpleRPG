public class Goblin extends Entity{
    public Goblin(String name) {
        super(name);
        /* Гоблин
         * Менее ловкий, чем скелет, но более сильный и живучий
         */
        this.hp = 50;
        this.agility = 2;
        this.gold = (int)(Math.round(Math.random() * 8));
        this.xp = 2 + (int)(Math.round(Math.random() * 6)); //5-15 единиц опыта
        this.power = 7;
        this.critical = 10;
    }
}
