package helpers;

import java.util.Random;

public class RandomHelper {

    int randomH =(int)(Math.random()*10+1);

    public int getRandomH() {
        return randomH;
    }

    public int randomIntLimits(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
