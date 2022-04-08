//How to reach me: kydapropal@gmail.com or @H4mmer_T1me (telegram)

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShadesOfGrey {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String nameFormat = sc.nextLine();
        String imgName = name + "." + nameFormat;
        String name4Split = name + "#." + nameFormat;

        String[] name_arr = name4Split.split("#");
        //System.out.println(Arrays.toString(name_arr));

        //System.out.println(name_arr[name_arr.length-1]);

        try {
            // Открываю изображение
            File file = new File(imgName);
            BufferedImage image = ImageIO.read(file);

            // Создаю новое пустое изображение, такого же размера
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

            // Двойной цикл, чтобы обработать каждый пиксель
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {

                    // Получаю цвет текущего пикселя
                    Color color = new Color(image.getRGB(x, y));

                    // Получаю каналы этого цвета. значения от 0 до 255
                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();
                    //System.out.printf(" с:%d к:%d з:%d%n", blue,red, green);

                    // Применяю алгоритм для получения черно-белого изображения, как в телевидении раньше
                    int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                    //устанавливаем фильтр серого
                    int newBlue = grey;
                    int newRed = grey;
                    int newGreen = grey;

                    //  Cоздаю новый цвет
                    Color newColor = new Color(newRed, newGreen, newBlue);

                    // И устанавливаю этот цвет в текущий пиксель результирующего изображения
                    result.setRGB(x, y, newColor.getRGB());
                }
            }

            // Сохраняю результат в новый файл
            File output = new File(name_arr[name_arr.length - 2] + "_grey" + name_arr[name_arr.length - 1]);

            // Собираю имя файла и отдельно формат
            String[] formatArr = name_arr[name_arr.length - 1].split("");
            String format = "";
            for (int i = 1; i < formatArr.length; i++) {
                format += formatArr[i];
            }
            // чтобы передать формат в паарметры и не привязываться жестко к одному (во 2м аргументе)
            ImageIO.write(result, format, output);

        } catch (IOException e) {
            System.out.println("файл не найден или не удалось сохранить");
        }


    }
}
