package org.demo.birds.processor;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */

import org.demo.birds.entities.Bird;
import org.demo.birds.store.BirdStore;

import java.util.Scanner;

/**
 * 1) В бесконечном цикле просим пользователя ввести комманду:
 * <p>
 * Please, enter command:
 * a - add new Bird
 * s - search bird by name
 * l - search bird by living area
 * exit - terminate application
 * 2) пользователь вводит комманду.
 */
public class UserCommandProcessor implements IInfiniteLoopProcessor, IUserCommandProcessor, IBirdCreator {

    @Override
    public void processInLoop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter command:" + "\n" +
                    "a - add new Bird" + "\n" +
                    "s - search bird by name" + "\n" +
                    "l - search bird by living area" + "\n" +
                    "exit - terminate application");
            processUserCommand(scanner.nextLine(), scanner);

        }
    }


    /*           *   3) если введена комманда l:
     *       - запрашиваем у пользователя Please, enter bird living area to search
     *       - читаем введенное значение
     *       - находим объекты с такми living area в BirdStore, печатаем Find bird : ....
     **/
    @Override
    public void processUserCommand(String command, Scanner userInputReader) {
        switch (command) {
            case "a":
                BirdStore.of().addBird(createBird(userInputReader));
                break;
            case "s":
                System.out.println("Please, enter bird name to search");
                System.out.println(BirdStore.of().searchByName(userInputReader.nextLine()).toString());
                break;
            case "l":
                System.out.println("Please, enter bird living area to search");
                String aa = userInputReader.nextLine();
                System.out.println(aa);
                System.out.println(BirdStore.of().searchByLivingArea(aa).toString());
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Unknown command");
                break;
        }
    }

    @Override
    public Bird createBird(Scanner userInputReader) {
        System.out.println("Please, enter bird name");
        String name = userInputReader.next();
        System.out.println("Please, enter bird living area");
        String livingArea = userInputReader.next();
        System.out.println("Please, enter bird size");
        Double size = userInputReader.nextDouble();
        return new Bird(name, livingArea, size);
    }
}
