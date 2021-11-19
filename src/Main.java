import java.util.Scanner;

/* Администратор отеля*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // создали новый экземпляр scanner-a типа Scaner System.in для ввода с консоли различных команд Администратором
        Hotel hotel = new Hotel(new Room[]{     // создаем новый hotel типа Hotel , куда в Массив сразу, через запятую, пишем Новые Комнаты
                new Room(11,2,true,true,true),
                new Room(12,3,true,true,true),
                new Room(13,2,true,true,true),
                new Room(14,1,false,true,true),
                new Room(21,4,false,false,false),
                new Room(22,3,false,true,false),
                new Room(23,4,false,false,false),
                new Room(24,4,true,true,false),
                new Room(31,4,true,true,true),
                new Room(32,1,false,true,false),
                new Room(33,1,false,false,false),
                new Room(34,4,true,true,false)
        });
        String help = "*--------*\n"+
                "exit = выход из программы\n"+
                "getFreeRooms = получить список свободных комнат\n"+
                "help = вывод подсказки\n"+
                "reserve [номер комнаты] = забронировали кон=мнату\n"+
                "getReservedRooms = показать забронированные комнаты\n"+
                "*--------*";
        System.out.println(help);
        String command = scanner.nextLine();    // создали текстовую переменную command и назначили ей ожидание получения ввода с консоли (scanner.nextLine())
        while (!command.equals("exit")){     // пока переменная command не получила значение exit (пока пользователь не ввел exit) - запускаем цикл (т.е. постоянно ждем ввод exit, т.е. постоянно "мониторим" ввод с консоли
            if (command.equals("getFreeRooms")) {
                hotel.getFreeRooms();   // у метода hotel типа Hotel в классе Hotel.java написан метод getFreeRooms - к нему и обращаемся
            }else if (command.indexOf("reserve") == 0) {    // ищи в Интернет как работает команда indexOf !!
                String[] splitted = command.split(" ");     // команда split делит нашу строку (в н.с. - command) по символу "пробел" (" ") и возвращает Массив из двух элементов - значения "до" и "после" символа пробел
                // Этот то массив мы и записываем в нашу новую переменную splitted (у нее тип Массив: [])
                // в примере мы разбираем строку, команду что ввел пользователь, например "reserve 13": получили Массив ["reserve","13"]
                int roomNumber = Integer.parseInt(splitted[1]);     // мы вытащили из массива splitted второй элемент, преобразовали его в Число и присвоили переменной roomNumber
                hotel.reserve(roomNumber);
            }else if (command.equals("getReservedRooms")) {    // проверяем на наричие зарезервированных комнат
                hotel.getReservedRooms();
            }else if (command.equals("help")) {
                System.out.println(help);
            }else{
                System.out.println("Введена неизвестная команда!");
            }
            command = scanner.nextLine();   // снова вызываем scanner - т.е. ждем что напишет пользователь в консоли
        }
    }
}
