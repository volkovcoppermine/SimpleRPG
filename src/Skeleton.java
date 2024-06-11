public class Skeleton extends Entity {
    public Skeleton(String name) {
        super(name);
        /* Скелет
         * Не такой живучий и сильный, как гоблин, но более ловкий
         */
        this.hp = 20;
        this.agility = 20;
        this.gold = (int)(Math.round(Math.random() * 16));
        this.xp = 5 + (int)(Math.round(Math.random() * 10)); //5-15 единиц опыта
        this.power = 3;
        this.critical = 5;
    }
}
