import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T,Case=0;

        T = in.nextInt();

        while(Case<T){
            int 층 = in.nextInt();
            int 호수 = in.nextInt();
            int[][] people = new int[층+1][호수+1];


            // 0 층 i 값 삽입
            for(int i =1; i <= 호수;i++){
                people[0][i] = i;
            }


            for(int 층변수 = 1 ; 층변수 < 층+1; 층변수++){
                for(int 호수변수 =1; 호수변수 <= 호수;호수변수++){
                    if(호수변수==1){
                        people[층변수][호수변수] = 1;
                    }
                    else {
                        people[층변수][호수변수] = people[층변수-1][호수변수] + people[층변수][호수변수-1];
                    }
                }
            }

            /*for(int f = 0 ;f < 층+1; f++){
                for(int i =1; i <= 호수;i++){
                    System.out.print(people[f][i]);
                }
                System.out.println();
            }*/
          
            System.out.println(people[층][호수]);



            Case++;

        }


    }
}