package scen;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, отвечающий за управление сценариями.
 */
class ScenarioManager {
    private Map<String, Scenario> scenarios;

    /**
     * Конструктор класса.
     */
    public ScenarioManager() {
        this.scenarios = new HashMap<>();
    }

    /**
     * Метод для загрузки сценариев из заданной директории.
     *
     * @param directoryPath путь к директории с файлами сценариев
     * @throws FileNotFoundException если файл сценариев не найден
     */
    public void loadScenarios(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    Scenario scenario = null;
                    scenario = loadScenarioFromFile(file);
                    scenarios.put(scenario.getName(), scenario);
                }
            }
        }


    }


    /**
     * Метод для загрузки сценария из файла.
     *
     * @param file файл сценария
     * @return объект сценария
     * @throws FileNotFoundException если файл сценария не найден
     */
    private Scenario loadScenarioFromFile(File file)  {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String scenarioName = scanner.nextLine();
        Scenario scenario = new Scenario(scenarioName);

        while (scanner.hasNextLine()) {
            String branchLine = scanner.nextLine();
            String[] branchData = branchLine.split(":");
            Branch branch = new Branch(branchData[0], branchData[1]);

            while (scanner.hasNextLine()) {
                String choiceLine = scanner.nextLine();

                if (choiceLine.equals("-")) {
                    break;
                }
                String[] choiceData = choiceLine.split(":");
                Choice choice = new Choice(choiceData[0], choiceData[1]);
                branch.addChoice(choice);
            }

            scenario.addBranch(branch);
        }

        scanner.close();
        return scenario;
    }

    /**
     * Метод для отображения доступных сценариев.
     */
    public void displayScenarios() {
        System.out.println("Available scenarios:");
        for (String scenarioName : scenarios.keySet()) {
            System.out.println(scenarioName);
        }
    }

    /**
     * Метод для запуска выбранного сценария.
     *
     * @param scenarioName имя выбранного сценария
     * @param inputScanner сканер для получения пользовательского ввода
     */
    public void runScenario(String scenarioName, Scanner inputScanner) {
        Scenario scenario = scenarios.get(scenarioName);

        if (scenario != null) {
            List<Branch> branches = scenario.getBranches();
            Branch currentBranch = branches.get(0);
            while (true) {
                System.out.println(currentBranch.getDescription());
                List<Choice> choices = currentBranch.getChoices();

                for (int i = 0; i < choices.size(); i++) {
                    System.out.println((i + 1) + ". " + choices.get(i).getText());
                }
                int choiceIndex = inputScanner.nextInt();
                if (choiceIndex >= 1 && choiceIndex <= choices.size()) {
                    String nextBranchName = choices.get(choiceIndex - 1).getNextBranch();
                    int number = 0;

                    Pattern pattern = Pattern.compile("(\\d+)");
                    Matcher matcher = pattern.matcher(nextBranchName);
                    if (matcher.find()) {
                        number = Integer.parseInt(matcher.group(1));
                    } else {
                        System.out.println("game over!");
                        break;

                    }
                    currentBranch = branches.get(number - 1);
                } else {
                    System.out.println("Invalid choice. Please enter a valid choice.");
                }
            }
        }
    }
}

