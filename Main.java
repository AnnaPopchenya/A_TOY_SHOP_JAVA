public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушек в магазин
        toyStore.addToy("1", "Teddy Bear", 5, 20);
        toyStore.addToy("2", "Doll", 10, 15);
        toyStore.addToy("3", "Toy Car", 8, 10);

        // Изменение веса игрушек
        toyStore.updateWeight("1", 30);
        toyStore.updateWeight("2", 20);
        toyStore.updateWeight("3", 10);

        // Розыгрыш игрушек
        toyStore.playGame();
    }
}