public class Hotel {
    private Room[] rooms;   // создали Массив под наши комнаты

    public Hotel(Room[] rooms) { // создали Конструктор для Hotel. В него, привызове этого конструктора извне, должны "прилетать" параметры Комнат!
        this.rooms = rooms;
    }
    public void getFreeRooms(){     // создали публичный метод getFreeRooms, который будет отдавать нам список свободных комнат (используем в MAin)
        String result = "По данному запросу найдены комнаты: ";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (!room.isReserved()) result += room.getRoomNumber() + ", ";
        }
        System.out.println(result);
    }

    public void getFreeRooms(boolean wc, int sleepingPlace, boolean conditioner, boolean wifi, int seviceCount){
        String result = "По данному запросу найдены комнаты: ";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            int mark = 0;
            if (wc && room.isWc()) mark++;
            if (sleepingPlace != 0 && room.getSleepingPlace() == sleepingPlace) mark++;
            if (conditioner && room.isConditioner()) mark++;
            if (wifi && room.isWifi()) mark++;
            if(seviceCount == mark && !room.isReserved()){
                result += room.getRoomNumber()+", ";
            }
        }
        System.out.println(result);
    }

    public void reserve (int roomNumber) {  // создали метод, который на вход принимает int roomNumber. Будем его использовать в Main.java
        String result = "Ошибка! Номера не существуе.";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];   // создали переменную room куда будем сохранять найденную i-ую комнату при переборе Массива rooms
            if (room.getRoomNumber() == roomNumber && !room.isReserved()) {      // берем из room номер комнаты через getRoomNumber и сравниваем с нашмим roomNumber. А так же:
                // выясняем не занята ли она (одноврееменно!) - т.е. roomReserved НЕ равен True
                result = "Номер "+roomNumber+" успешно забронирован.";
                room.setReserved(true);     // пометили что теперь данная комната Забронирована
                break;      // раз комната нашлась и мы ее забронировали - нет смысла дальше продолжать Цикл перебора. Останавливаем Цикл.
            }else if (room.getRoomNumber() == roomNumber && room.isReserved()) {    // если нашли комнату но она занята:
                result = "Номер "+roomNumber+" занят.";
                break;
            }
        }
        System.out.println(result);
    }

    public void getReservedRooms() {
        String result = "Зарезервированные комнаты: ";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room.isReserved()) {
                result += room.getRoomNumber() + ",";
            }
        }
        System.out.println(result);
    }
}
