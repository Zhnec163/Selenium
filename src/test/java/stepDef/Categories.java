package stepDef;

public enum Categories {
    оргтехника("Оргтехника и расходники", 99),
    ноутбуки("Ноутбуки", 98),
    планшеты("Планшеты и электронные книги", 96),
    телефоны("Телефоны", 84),
    аудиотехника("Аудио и видео", 32),
    фототехника("Фототехника", 105);
    private String value;
    private int id;

    Categories(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() { return value; }

    public int getId() { return id; }
}
