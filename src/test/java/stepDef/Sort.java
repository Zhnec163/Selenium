package stepDef;

public enum Sort {
    Поумолчанию("По умолчанию", 101),
    Дешевле("Дешевле", 1),
    Дороже("Дороже", 2),
    Подате("По дате", 104);
    private String value;
    private int id;

    Sort(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() { return value; }

    public int getId() { return id; }
}
