package first;

public class ControlConstructions {


    public void cycle (){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 10);
    }


    public void constructions() {

        if (10 > 20)  {
            System.out.println("10 > 20");
        } else {
            System.out.println("10 <= 20");
        }

        switch (10) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
        }
    }

}
