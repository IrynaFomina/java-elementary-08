package org.demo.birds.application;

import org.demo.birds.entities.Bird;
import org.demo.birds.processor.IInfiniteLoopProcessor;
import org.demo.birds.processor.UserCommandProcessor;
import org.demo.birds.store.BirdStore;

public class BirdStoreApplication {

    public static void main(String[] args) {
//         IInfiniteLoopProcessor userCommandProcessor = new UserCommandProcessor(); //создать реальный объект
//         userCommandProcessor.processInLoop();
         NewBird newBird = new NewBird();
         newBird.start();
        NewBird1 newBird2 = new NewBird1();
        newBird2.start();
        RemoveBird removeBird = new RemoveBird();
        removeBird.start();
    }
}

class NewBird extends Thread{
    @Override
    public void run(){
        Bird bird = new Bird("aa", "qwe", 2d);
        BirdStore birdStore = BirdStore.of();
        birdStore.addBird(bird);
        try {
            sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName() + " : " + birdStore.toString());
    }
}

class NewBird1 extends Thread{
    @Override
    public void run(){
        Bird bird = new Bird("aa", "qwe", 3d);
        BirdStore birdStore = BirdStore.of();
        birdStore.addBird(bird);
        try {
            sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName() + " : "+ birdStore.toString());
    }
}

class RemoveBird extends Thread{
    @Override
    public void run(){
        Bird bird = new Bird("aa", "qwe", 2d);
        BirdStore birdStore = BirdStore.of();
        birdStore.deleteBird(bird);
        System.out.println(currentThread().getName() + " : " + birdStore.toString());
    }
}

