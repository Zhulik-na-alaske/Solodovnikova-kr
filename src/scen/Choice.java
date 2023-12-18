package scen;

/**
 * Класс представляет собой выбор ветви сценария. Содержит текст выбора и название следующей ветви.
 */
class Choice {
    private String text;
    private String nextBranch;

    /**
     * Создает новый объект Choice с указанным текстом и названием следующей ветви.
     *
     * @param text       текст выбора
     * @param nextBranch название следующей ветви
     */
    public Choice(String text, String nextBranch) {
        this.text = text;
        this.nextBranch = nextBranch;
    }

    /**
     * Возвращает текст выбора.
     *
     * @return текст выбора
     */
    public String getText() {
        return text;
    }

    /**
     * Возвращает название следующей ветви.
     *
     * @return название следующей ветви
     */
    public String getNextBranch() {
        return nextBranch;
    }

}
