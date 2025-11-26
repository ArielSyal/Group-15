class PlayTone{
    private String[] tones;
    private int index = 0;
    FilePlayer fp = new FilePlayer();

    public PlayTone(String[] t){
        this.tones = t;
    }

    public synchronized void play(int thread) throws InterruptedException {
        while(index < tones.length){
            String current = tones[index];

            //sync do-octave of both threads
            if (current.equals("do-octave")){
                notifyAll();
                System.out.print(current);
                fp.play("Sounds/" + current + ".wav");
                Thread.sleep(500);
                index++; // move to next tone
                notifyAll(); // wake up other thread
                return;

            }
            // Check if this thread can play this tone
            if ((thread == 1 && isThread1(current)) ||
                    (thread == 2 && isThread2(current))) {

                System.out.print(current + " ");
                fp.play("Sounds/" + current + ".wav");
                Thread.sleep(500);
                index++; // move to next tone
                notifyAll(); // wake up other thread
                return;
            } else {
                wait(); // not this thread's turn
            }
        }
    }

    public boolean isThread1(String s){
        return s.equals("do") || s.equals("mi") || s.equals("sol") || s.equals("si") || s.equals("do-octave");
    }

    public boolean isThread2(String s){
        return s.equals("re") || s.equals("fa") || s.equals("la") || s.equals("do-octave");
    }
}

public class FilePlayingThreads {
    public static void main(String[] args){
        //Task 1
        System.out.println("Task 1 Start");
        String[] simpleTones = {"do", "re", "mi", "fa", "sol", "la", "si", "do-octave"};

    
        PlayTone task1 = new PlayTone(simpleTones);
        
        Thread t1 = new Thread(){
            @Override
            public void run(){;
                for (String s : simpleTones) {
                    try {
                        task1.play(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (String s : simpleTones)  {
                    try {
                        task1.play(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
        System.out.println(" ");
        System.out.println("Task 1 Complete");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        //Task 2
        System.out.println("Task 2 Start");
        String[] littleStar = {"do", "do", "sol", "sol", "la", "la", "sol",
                                "fa", "fa", "mi", "mi", "re", "re", "do",
                                "sol", "sol", "fa", "fa", "mi", "mi", "re", "sol",
                                "sol", "fa", "fa", "mi", "mi", "re",
                                "do", "do", "sol", "sol", "la", "la", "sol",
                                "fa", "fa", "mi", "mi", "re", "re", "do"};

        PlayTone task2 = new PlayTone(littleStar);

        Thread t3 = new Thread(){
            @Override
            public void run(){;
                for (String s : littleStar) {
                    try {
                        task2.play(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run(){
                for (String s : littleStar)  {
                    try {
                        task2.play(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (Exception e) {
        }
        System.out.println(" ");
        System.out.println("Task 2 Complete");
        
    }
}

