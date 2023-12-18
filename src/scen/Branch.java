package scen;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляет собой ветвь сценария, содержащую название, описание и список выборов.
 */
class Branch {
    private String name;
    private String description;
    private List<Choice> choices;

    /**
     * Создает новый объект Branch с указанным названием, описанием и пустым списком выборов.
     *
     * @param name        название ветви
     * @param description описание ветви
     */
    public Branch(String name, String description) {
        this.name = name;
        this.description = description;
        this.choices = new ArrayList<>();
    }

    /**
     * Добавляет новый выбор в список выборов ветви.
     *
     * @param choice добавляемый выбор
     */
    public void addChoice(Choice choice) {
        choices.add(choice);
    }

    /**
     * Возвращает название ветви.
     *
     * @return название ветви
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание ветви.
     *
     * @return описание ветви
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает список всех выборов ветви.
     *
     * @return список выборов ветви
     */
    public List<Choice> getChoices() {
        return choices;
    }
}
