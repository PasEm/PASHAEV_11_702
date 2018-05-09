public class User {
    private String password;
    private String name;
    private int id;
    private int coins;

    public User(String password, String name, int id) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.coins = 0;
    }

    public User() {
        this.name = "DEFAULT_NAME";
        this.password = "DEFAULT_PASSWORD";
        this.id = 0;
        this.coins = Integer.MAX_VALUE;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCoins() {
        return coins;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
