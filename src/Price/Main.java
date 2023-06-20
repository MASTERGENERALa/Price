package Price;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Price[] prices = new Price[2];
        Scanner scanner = new Scanner(System.in);

        // Введення даних про товари з клавіатури
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Введіть дані для товару №" + (i + 1));

            System.out.print("Назва товару: ");
            String productName = scanner.nextLine();

            System.out.print("Назва магазину: ");
            String storeName = scanner.nextLine();

            System.out.print("Вартість товару (у гривнях): ");
            double price = Double.parseDouble(scanner.nextLine());

            prices[i] = new Price(productName, storeName, price);
        }

        // Сортування за назвами магазинів
        Arrays.sort(prices, (p1, p2) -> p1.getStoreName().compareToIgnoreCase(p2.getStoreName()));

        System.out.print("Введіть назву магазину: ");
        String inputStoreName = scanner.nextLine();

        // Виведення інформації про товари, що продаються в введеному магазині
        boolean storeFound = false;
        System.out.println("Інформація про товари, що продаються в магазині " + inputStoreName + ":");
        for (Price price : prices) {
            if (price.getStoreName().equalsIgnoreCase(inputStoreName)) {
                System.out.println("Назва товару: " + price.getProductName());
                System.out.println("Вартість товару: " + price.getPrice() + " грн");
                storeFound = true;
            }
        }

        if (!storeFound) {
            System.out.println("Магазин " + inputStoreName + " не знайдено.");
        }
    }
}

