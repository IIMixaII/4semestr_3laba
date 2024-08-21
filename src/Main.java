import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {


    public static void main(String[] args) {
        System.out.print("Введите номер задания (от 1 до 10): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Выбрано задание 1");
                task1.main(args);
                break;
            case 2:
                System.out.println("Выбрано задание 2");
                Task2.main(args);
                break;
            case 3:
                System.out.println("Выбрано задание 3");
                Task3.main(args);
                break;
            case 4:
                System.out.println("Выбрано задание 4");
                Task4.main(args);
                break;
            case 5:
                System.out.println("Выбрано задание 5");
                Task5.main(args);

                break;
            case 6:
                System.out.println("Выбрано задание 6");
                Task6.main(args);
                break;
            case 7:
                System.out.println("Выбрано задание 7");
                Task7.main(args);
                break;
            case 8:
                System.out.println("Выбрано задание 8");
                Task8.main(args);
                break;
            case 9:
                System.out.println("Выбрано задание 9");

                break;
            case 10:
                System.out.println("Выбрано задание 10");
                Task10.main(args);
                break;
            case 11:
                System.out.println("Выбрано задание 10");
                task11.main(args);
                break;
            default:
                System.out.println("Неверный выбор");
        }

        scanner.close();
    }

    public class task1 {

        private static String makeTable(Map<String, String[]> data, int width) {
            List<List<String>> columns = new ArrayList<>();

            for (Map.Entry<String, String[]> entry : data.entrySet()) {
                List<String> column = new ArrayList<>();
                column.add(entry.getKey());
                column.add("-".repeat(width));
                column.addAll(Arrays.asList(entry.getValue()));
                columns.add(column);
            }

            StringBuilder table = new StringBuilder();
            int row_count = columns.get(0).size();

            for (int i = 0; i < row_count; i++) {
                for (List<String> column : columns) {
                    table.append(String.format("| %-" + width + "s ", column.get(i)));
                }
                table.append("|\n");
            }
            return table.toString();
        }

        public static void main(String[] args) {
            LinkedHashMap<String, String[]> table_data = new LinkedHashMap<>();

            // ----------------- Arguments -----------------
            double step = Math.PI / 15.0;
            double end = Math.PI;
            List<Double> values = new ArrayList<>();

            for (double value = Math.PI / 15.0; value <= end; value += step) {
                values.add(value);
            }
            table_data.put("x", values.stream().map(val -> String.format("%.5f", val)).toArray(String[]::new));

            // ----------------- sin(x) -----------------
            table_data.put(
                    "sin(x)", values.stream().map(Math::sin).map(val -> String.format("%.7e", val)).toArray(String[]::new)
            );

            // ------------ (e^x)/(x * lg(x)) -----------
            table_data.put("(e^x)/(x * lg(x))", values.stream().map(val -> {
                if (val == 0.0) {
                    return "0.0";
                }
                return String.format("%.7e", Math.exp(val) / (val * Math.log(val)));
            }).toArray(String[]::new));

            System.out.println(makeTable(table_data, 15));
        }
    }

    public class Task2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ввод числа строк и столбцов
            System.out.print("Введите количество строк: ");
            int rows = scanner.nextInt();
            System.out.print("Введите количество столбцов: ");
            int cols = scanner.nextInt();

            // Создание двумерного массива
            int[][] array = new int[rows][cols];

            // Ввод элементов массива
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.printf("Элемент [%d][%d]: ", i, j);
                    array[i][j] = scanner.nextInt();
                }
            }

            int maxNegative = findMaxNegative(array);

            if (maxNegative != Integer.MIN_VALUE) {
                System.out.println("Наибольший отрицательный элемент: " + maxNegative);
            } else {
                System.out.println("Отрицательных элементов нет.");
            }

            scanner.close();
        }

        public static int findMaxNegative(int[][] array) {
            int maxNegative = Integer.MIN_VALUE;

            for (int[] row : array) {
                for (int element : row) {
                    if (element < 0 && element > maxNegative) {
                        maxNegative = element;
                    }
                }
            }

            return maxNegative;
        }
    }


    public class Task3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Создание матрицы
            int[][] matrix = new int[3][3];

            // Ввод элементов матрицы
            System.out.println("Введите элементы матрицы 3x3:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf("Элемент [%d][%d]: ", i, j);
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Вывод исходной матрицы
            System.out.println("\nИсходная матрица:");
            printMatrix(matrix);

            // Упорядочивание элементов каждой строки по возрастанию
            sortRows(matrix);

            // Вывод матрицы после сортировки
            System.out.println("\nМатрица после сортировки:");
            printMatrix(matrix);

            scanner.close();
        }

        // Метод для упорядочивания элементов каждой строки по возрастанию
        public static void sortRows(int[][] matrix) {
            for (int[] row : matrix) {
                Arrays.sort(row);
            }
        }

        // Метод для вывода матрицы на экран
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }


    public class Task4 {

        private static class Circle {
            public int x;
            public int y;
            public int radius;

            public Circle(int x, int y, int radius) {
                this.x = x;
                this.y = y;
                this.radius = radius;
            }
        }

        private static int DefineResult(Circle circle1, Circle circle2){
            double distance = Math.sqrt(Math.pow(circle1.x - circle2.x, 2) + Math.pow(circle1.y - circle2.y, 2));
            if (distance == 0 && circle1.radius == circle2.radius){
                return 1;
            } else if (distance == circle1.radius + circle2.radius){
                return 2;
            } else if (distance < circle1.radius + circle2.radius){
                return 3;
            } else if (distance + circle1.radius <= circle2.radius){
                return 4;
            } else if (distance + circle2.radius <= circle1.radius){
                return 5;
            } else
                return 6;
        }

        public static void main(String[] args) {
            int x;
            int y;
            int radius;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координаты первой окружности: ");
            System.out.print("x: ");
            x = scanner.nextInt();
            System.out.print("y: ");
            y = scanner.nextInt();
            System.out.print("Радиус: ");
            radius = scanner.nextInt();
            Circle circle1 = new Circle(x, y, radius);

            System.out.println("\nВведите координаты второй окружности: ");
            System.out.print("x: ");
            x = scanner.nextInt();
            System.out.print("y: ");
            y = scanner.nextInt();
            System.out.print("Радиус: ");
            radius = scanner.nextInt();
            Circle circle2 = new Circle(x, y, radius);


            int result = DefineResult(circle1, circle2);

            switch (result) {
                case 2 -> System.out.println("Касаются");
                case 3 -> System.out.println("Пересекаются в двух точках");
                case 1 -> System.out.println("Совпадают");
                case 6 -> System.out.println("Не пересекаются");
                case 4 -> System.out.println("Первая окружность вложена во вторую");
                case 5 -> System.out.println("Вторая окружность вложена в первую");
                default -> System.out.println("Неизвестный результат");
            }
        }
    }

    public class Task5 {

        private static class Circle {
            public int x;
            public int y;
            public int radius;

            public Circle(int x, int y, int radius) {
                this.x = x;
                this.y = y;
                this.radius = radius;
            }
        }

        enum ResultType {
            TOUCHING,  // касаются
            INTERSECTING_AT_TWO_POINTS,  // пересекаются в двух точках
            COINCIDENT,  // совпадают
            NON_INTERSECTING,  // не пересекаются
            FIRST_CIRCLE_EMBEDDED,  // первая окружность вложена во вторую
            SECOND_CIRCLE_EMBEDDED  // вторая окружность вложена в первую
        }

        private static ResultType DefineResult(Circle circle1, Circle circle2){
            double distance = Math.sqrt(Math.pow(circle1.x - circle2.x, 2) + Math.pow(circle1.y - circle2.y, 2));
            if (distance == 0 && circle1.radius == circle2.radius){
                return ResultType.COINCIDENT;
            } else if (distance == circle1.radius + circle2.radius){
                return ResultType.TOUCHING;
            } else if (distance + circle1.radius <= circle2.radius){
                return ResultType.FIRST_CIRCLE_EMBEDDED;
            } else if (distance + circle2.radius <= circle1.radius){
                return ResultType.SECOND_CIRCLE_EMBEDDED;
            } else if (distance < circle1.radius + circle2.radius){
                return ResultType.INTERSECTING_AT_TWO_POINTS;
            } else
                return ResultType.NON_INTERSECTING;
        }

        public static void main(String[] args) {
            int x;
            int y;
            int radius;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координаты первой окружности: ");
            System.out.print("x: ");
            x = scanner.nextInt();
            System.out.print("y: ");
            y = scanner.nextInt();
            System.out.print("Радиус: ");
            radius = scanner.nextInt();
            Circle circle1 = new Circle(x, y, radius);

            System.out.println("\nВведите координаты второй окружности: ");
            System.out.print("x: ");
            x = scanner.nextInt();
            System.out.print("y: ");
            y = scanner.nextInt();
            System.out.print("Радиус: ");
            radius = scanner.nextInt();
            Circle circle2 = new Circle(x, y, radius);


            ResultType result = DefineResult(circle1, circle2);

            switch (result) {
                case TOUCHING -> System.out.println("Касаются");
                case INTERSECTING_AT_TWO_POINTS -> System.out.println("Пересекаются в двух точках");
                case COINCIDENT -> System.out.println("Совпадают");
                case NON_INTERSECTING -> System.out.println("Не пересекаются");
                case FIRST_CIRCLE_EMBEDDED -> System.out.println("Первая окружность вложена во вторую");
                case SECOND_CIRCLE_EMBEDDED -> System.out.println("Вторая окружность вложена в первую");
                default -> System.out.println("Неизвестный результат");
            }
        }
    }

    public class Task6 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите начальное значение интервала: ");
            double a = scanner.nextDouble();

            System.out.print("Введите конечное значение интервала: ");
            double b = scanner.nextDouble();

            // постоянный шаг
            double h = (b - a) / 100;

            double[] x = new double[101];
            double[] y = new double[101];

            // вычисление значений аргумента и функции на интервале
            for (int i = 0; i <= 100; i++) {
                x[i] = a + i * h;
                y[i] = Math.exp(x[i]) - Math.pow(x[i], 3);
            }

            double integral = integrateLeftRectangles(x, y);
            System.out.printf("\nЗначение интеграла: %.4f%n", integral);

            double exactIntegral = Math.exp(b) - b * b * b * b / 4 - Math.exp(a) + a * a * a * a / 4;
            System.out.printf("Точное значение интеграла: %.4f%n", exactIntegral);
        }

        public static double integrateLeftRectangles(double[] x, double[] y) {
            double integral = 0;

            for (int i = 0; i < x.length - 1; i++) {
                double width = x[i + 1] - x[i];
                double height = y[i];
                integral += width * height;
            }

            return integral;
        }
    }

    public class Task7 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите целое десятичное число: ");
            int dec = scanner.nextInt();

            boolean is_neg = false;
            if (dec < 0) {
                is_neg = true;
                dec = Math.abs(dec);
            }

            int base;
            do {
                System.out.print("Введите основание системы счисления (от 2 до 8 включительно): ");
                base = scanner.nextInt();
            } while (base < 2 || base > 8);

            String result = convertDecimalToBase(dec, base);
            if (is_neg) {
                result = "-" + result;
            }
            System.out.printf("Число %d в системе счисления с основанием %d: %s%n", dec, base, result);
        }

        public static String convertDecimalToBase(int dec, int base) {
            StringBuilder result = new StringBuilder();

            while (dec > 0) {
                result.insert(0, dec % base);
                dec /= base;
            }

            return result.toString();
        }
    }

    public class Task8 {

        public static double horner(double[] coeffs, double x) {
            int n = coeffs.length - 1;
            double polynomial = coeffs[n];
            for (int k = n - 1; k >= 0; k--) {
                polynomial = polynomial * x + coeffs[k];
            }
            return polynomial;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите значение переменной x: ");
            double x = scanner.nextDouble();

            System.out.print("Введите количество коэффициентов: ");
            int numCoeffs = scanner.nextInt();
            double[] coeffs = new double[numCoeffs];

            System.out.println("Введите коэффициенты по одному:");
            for (int i = 0; i < numCoeffs; i++) {
                System.out.print("Коэффициент " + (i + 1) + ": ");
                coeffs[i] = scanner.nextDouble();
            }

            double result = horner(coeffs, x);
            System.out.printf("Значение полинома при x = %.3f равно %.4f %n", x, result);
        }
    }

    public class Task10 {
        public static void main(String[] args) {
            String some = "Мои номера `220-30-40` и `8904-378-16-61` не считая служебных";

            Pattern pattern_one = Pattern.compile("(8|\\+7)[-\\(\\s]*(\\d{3}[-\\)\\s]*){2}\\d{2}[-\\)\\s]*\\d{2}");
            Pattern pattern_two = Pattern.compile("\\b[23][- ]?\\d{2}[- ]?\\d{2}[- ]?\\d{2}\\b");
            Matcher match_mob = pattern_one.matcher(some);
            Matcher match_home = pattern_two.matcher(some);

            while (match_mob.find()) {
                System.out.println(match_mob.group());
            }

            while (match_home.find()) {
                System.out.println(match_home.group());
            }
        }
    }
    public class task11 {
        public static void main(String[] args) {
            int num = Integer.parseInt(args[0]);

            System.out.println("\nВведенное число: " + num);
            System.out.println("Число в двоичной системе: " + Integer.toBinaryString(num));
            System.out.println("Число в восьмеричной системе: " + Integer.toOctalString(num));
            System.out.println("Число в шестнадцатеричной системе: " + Integer.toHexString(num));
        }
    }


}