import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(String name, int quantity, double weight) {
        Toy toy = new Toy(name, quantity, weight);
        toys.add(toy);
    }

    public void setWeight(String toyId, double weight) {
        Toy toy = findToyById(toyId);
        if (toy != null) {
            toy.setWeight(weight);
        }
    }

    public String findToyById(String toyId) {
        for (Toy toy : toys) {
            if (toy.getId().equals(toyId)) {
                return toy;
            }
        }
        return null;
    }

    public Toy getRandomToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomWeight <= cumulativeWeight) {
                return toy;
            }
        }

        return null; // Если нет игрушек или веса игрушек не заданы корректно
    }

    public void playToyRaffle(int numWinners) {
        try {
            FileWriter writer = new FileWriter("winners.txt");
            for (int i = 0; i < numWinners; i++) {
                Toy toy = getRandomToy();
                if (toy != null && toy.getQuantity() > 0) {
                    writer.write("Winner: " + toy.getName() + "\n");
                    toy.setQuantity(toy.getQuantity() - 1);
                } else {
                    writer.write("No winner\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
