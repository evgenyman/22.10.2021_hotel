public class Room {
    private int roomNumber; // перечисляем нужные нам переменные
    private int sleepingPlace;
    private boolean wifi;
    private boolean wc;
    private boolean conditioner;
    private boolean reserved;   // true = занято, false = свободна

    public Room(int roomNumber, int sleepingPlace, boolean wifi, boolean wc, boolean conditioner) { // Создаем Конструктор для наших Комнат
        this.roomNumber = roomNumber;   // в this.roomNumber прилетело из входящего параметра roomNumber
        this.sleepingPlace = sleepingPlace;
        this.wifi = wifi;
        this.wc = wc;
        this.conditioner = conditioner;
//        this.reserved = reserved;
        this.reserved = false; // раз мы сдесь уже сразу задаем конкретное значение (false), то в элементы конструктора (стр.9) этот параметр можно не передавать
    }

    public void setReserved(boolean reserved) { // нам нужен Сеттер, т.к. мы будем периодически менять состояние Резерва
        this.reserved = reserved;
    }

    public int getRoomNumber() {    // Геттеры нам нужны все, т.к. мы все параметры будем запрашивать извне
        return roomNumber;
    }

    public int getSleepingPlace() {
        return sleepingPlace;
    }

    public boolean isWifi() {   // isWifi - "Изер" - потому, что у Булевых переменных метод Get превращается в Is (есть-ли true или false?)
        return wifi;
    }

    public boolean isWc() {
        return wc;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public boolean isReserved() {
        return reserved;
    }
}
