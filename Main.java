public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавление игрушек
        toyStore.addToy("Teddy Bear", 10, 30);
        toyStore.addToy("Barbie Doll", 5, 20);
        toyStore.addToy("Race Car", 3, 50);

         // Изменение веса игрушек
         toyStore.setWeight(toyStore.findToyById("123"), 40);

        

        // Розыгрыш игрушек
        toyStore.playToyRaffle(3);
    }
}
