package ua.Lysenko.Module1.ChessTask;

public class TaskChess {
    public static void main(String[] args) {
        ChessField originalPosition = new ChessField();
        ChessField intendedPosition = new ChessField1();
        //добавил еще один класс из-за разницы в запросе на ввод для текущей и следующей ячейкой

        originalPosition.setValues();
        intendedPosition.setValues();


        int diff = originalPosition.index - intendedPosition.index;
//        добавил переменную diff, чтоб не раздувать следущую строку
        if (Math.abs(diff) == 17 || Math.abs(diff) == 15 || Math.abs(diff) == 10 || Math.abs(diff) == 6) {
            System.out.println("Выбранное поле подходит");
        } else {
            System.out.println("Выбранное НЕ поле подходит");
        }

    }
}

