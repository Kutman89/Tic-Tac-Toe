import java.util.Scanner;
public class Tic_Tac_Toe {
    //Массив для крестиков и ноликов
    static char[][] pole = {
        {'#','#','#'},
        {'#','#','#'},
        {'#','#','#'}
    };
    //Игрок
    static char player = 'X';

    //Вывод поля
    public static void out_pole() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) // Первый цикл
        {
            System.out.print(i + " "); // Печатаем номер строки
            for (int l = 0; l < 3; l++) //Второй цикл
            {
                System.out.print(pole[i][l] + (l < 2 ? " | " : "")); // Печатаем символ и разделитель
            }
            System.out.println();
            if (i < 2) {System.out.println("  ----------");}
        }
    }

    //Метод проверки победителя
    public static boolean player_win()
    {
        //Условие по диагонали
        if((pole[0][0] == player && pole[1][1] == player && pole[2][2] == player)||
                (pole[0][2] == player && pole[1][1] == player && pole[2][0] == player)){
            return true;
        }
        //Условие по горизонтали и вертикали
        for(int i = 0; i < 3; i++){
            if((pole[i][0] == player && pole[i][1] == player && pole[i][2] == player)||
                    (pole[0][i] == player && pole[1][i] == player && pole[2][i] == player)){
                return true;
            }
        }
        return false;
    };

    public static void main(String[] args)
    {
        out_pole();
        //Инициализация всех нужных переменных
        Scanner inp = new Scanner(System.in);
        byte draw = 0;

        //Игра
        while(true)
        {
            //Получение данныз
            System.out.println("Введите строку и столбец: ");
            byte n1 = inp.nextByte();
            byte n2 = inp.nextByte();
            //Проверка на ничью
            if (++draw == 9)
            {
                pole[n1][n2] = player;
                out_pole();
                System.out.println("Ничья");
                break;
            }
            //Условия на занятность поля
            if(pole[n1][n2] == '#') {
                pole[n1][n2] = player;
                out_pole();

                //Условия на побдителя
                if(player_win())
                {
                    System.out.println("Победил игрок: " + player);
                    break;
                }
                //Смена игрока
                player = player == 'X' ? '0' : 'X';
            }
            else{
                System.out.println("Error: это поле занято");
                draw--;
            }
        }
    }
}