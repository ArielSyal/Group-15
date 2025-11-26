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
            // Check if this thread can play this tone
            if ((thread == 1 && isThread1(current)) ||
                    (thread == 2 && isThread2(current))) {

                //System.out.println("Sounds/" + current + ".wav");
                fp.play("Sounds/" + current + ".wav");
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
        String[] simpleTones = {"do", "re", "mi", "fa", "sol", "la", "si", "do-octave"};
        PlayTone st = new PlayTone(simpleTones);

        Thread t1 = new Thread(){
            @Override
            public void run(){;
                while (true) {
                    try {
                        st.play(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                while (true) {
                    try {
                        st.play(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };


//        String[] littleStar = {"do", "do", "sol", "sol", "la", "la", "sol",
//                "fa", "fa", "mi", "mi", "re", "re", "do",
//                "sol", "sol", "fa", "fa", "mi", "mi", "re", "sol",
//                "sol", "fa", "fa", "mi", "mi", "re",
//                "do", "do", "sol", "sol", "la", "la", "sol",
//                "fa", "fa", "mi", "mi", "re", "re", "do"};
//        for (int i = 0; i < simpleTones.length; i++){
//            if(simpleTones[i].equals())
//        }
        t1.start();
        t2.start();
    }
}
