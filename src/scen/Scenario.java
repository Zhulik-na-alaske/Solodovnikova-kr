package scen;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет собой сценарий игры, содержащий название и список ветвей.
 */
class Scenario {
    private String name;
    private List<Branch> branches;

    /**
     * Создает новый объект Scenario с указанным названием и пустым списком ветвей.
     *
     * @param name название сценария
     */
    public Scenario(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    /**
     * Добавляет новую ветвь в список ветвей сценария.
     *
     * @param branch добавляемая ветвь
     */
    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    /**
     * Возвращает название сценария.
     *
     * @return название сценария
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает список всех ветвей сценария.
     *
     * @return список ветвей сценария
     */
    public List<Branch> getBranches() {
        return branches;
    }
}
