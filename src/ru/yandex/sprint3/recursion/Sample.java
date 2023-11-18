package ru.yandex.sprint3.recursion;

public class Sample {

    public static void main(String[] args) {
        new Sample().run(args);
    }

    private void run(String[] args){
        build(10);
    }

    private void build(int value){
        if (value<=0){
            return;
        }
        else{
            System.out.println(value);
            build(value - 1);
        }
    }

}
