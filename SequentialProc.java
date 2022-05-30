class Run1 {
    public void execute() {
        for (int i =0 ;i < 1000;i++) {
            System.out.println("Runner1 : "+ i);
        }
    }
}

class Run2 {
    public void execute() {
        for (int i =0 ;i < 1000 ;i++) {
            System.out.println("Runner2 : "+ i);
        }
    }
}

public class SequentialProc {
    public static void main(String[] args) {
Run1 run1 = new Run1();
Run2 run2 = new Run2();

          run1.execute();
          run2.execute();
    }
}
