import java.util.Scanner;

public class Game {
    static Player player;
    private static boolean inGame = true;
    public static final int POTION_PRICE = 10;
    public static final int POTION_HP = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя игрока:");
        player = new Player(in.nextLine());

        while (inGame) {
            System.out.println("""
                    Куда вы хотите пойти?
                    1. К торговцу
                    2. В тёмный лес
                    3. Выйти из игры
                    """);
            String s = in.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверная команда. Введите номер варианта.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (player.heal(POTION_HP, POTION_PRICE)) {
                        System.out.printf("Здоровье: %d; Золото: %d%n", player.getHp(), player.getGold());
                    } else System.out.println("Недостаточно золота для покупки зелья");
                    break;
                case 2:
                    Battle battle = new Battle(player);
                    Thread battleThread = new Thread(battle);
                    battleThread.start();
                    try {
                        battleThread.join();
                    } catch (InterruptedException e) {
                        System.out.println("Внутренняя ошибка игры. Выход...");
                        inGame = false;
                    }

                    if (player.getHp() <= 0) {
                        System.out.println("Вы погибли. Игра окончена");
                        inGame = false;
                    }
                    break;
                case 3:
                    System.out.println("Выход из игры...");
                    inGame = false;
                    break;
                default:
                    System.out.println("Выберите 1, 2 или 3");
                    break;
            }
        }

    }
}
