public class Battle implements Runnable {
    private Player player;
    private Entity monster;

    public Battle(Player player) {
        this.player = player;
        this.monster = Math.round(Math.random()) > 0 ? new Goblin("Гоблин") : new Skeleton("Скелет");
    }

    @Override
    public void run() {
        int damage;

        boolean playerHp, monsterHp;

        while (true) {
            playerHp = player.getHp() > 0;
            monsterHp = monster.getHp() > 0;

            if ((playerHp || monsterHp) && !(playerHp && monsterHp)) break;

            damage = player.attack();
            monster.damage(damage);
            System.out.printf("%s атакует с силой %d%n", player.name, damage);
            damage = monster.attack();
            player.damage(damage);
            System.out.printf("%s атакует с силой %d%n", monster.name, damage);
        }

        if (player.getHp() > 0) {
            player.gainGold(monster.getGold());
            player.gainXp(monster.getXp());
            System.out.printf("%s получил %d золота и %d опыта%n", player.name, monster.getGold(), monster.getXp());
        }
    }
}
