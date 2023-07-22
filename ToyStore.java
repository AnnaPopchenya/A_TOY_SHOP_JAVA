import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(String id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void updateWeight(String id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId().equals(id)) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void playGame() {
        Random random = new Random();
        for (Toy toy : toys) {
            double weight = toy.getWeight();
            for (int i = 0; i < weight; i++) {
                prizeToys.add(toy);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!prizeToys.isEmpty()) {
                int randomIndex = random.nextInt(prizeToys.size());
                Toy prizeToy = prizeToys.remove(randomIndex);
                prizeToy.decreaseQuantity();
                writeToFile(prizeToy.getName());
            }
        }
    }

    private void writeToFile(String toyName) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toyName + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}