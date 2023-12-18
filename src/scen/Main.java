package scen;

import java.io.FileNotFoundException;
    import java.util.Scanner;

    /**
     * Главный класс программы, отвечающий за запуск и управление сценариями.
     */
    public class Main {
        /**
         * Основной метод программы.
         *
         * @param args аргументы командной строки
         * @throws FileNotFoundException если файл сценариев не найден
         */
        public static void main(String[] args) throws FileNotFoundException {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                ScenarioManager scenarioManager = new ScenarioManager();
                scenarioManager.loadScenarios("scenarios");

                scenarioManager.displayScenarios();

                Scanner inputScanner = new Scanner(System.in);
                System.out.println("Enter the name of the scenario to run:");
                String selectedScenario = inputScanner.nextLine();

                scenarioManager.runScenario(selectedScenario, inputScanner);
                System.out.println("Press q to exit or any other key to continue.");
                String exitCommand = scanner.nextLine();
                if (exitCommand.equals("q")) {
                    System.out.println("Exiting the program.");
                    break;
                }
            }
        }
    }
