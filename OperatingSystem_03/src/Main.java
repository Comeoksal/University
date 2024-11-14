import java.util.*;
import java.io.*;
class Process{
    private int S;
    private int Page_table[];
    public Process(int _ByteSize){
        S = _ByteSize;
    }
    public int get_S(){
        return S;
    }
    public void allocate_Pagetable(int _size){
        Page_table = new int[_size];
    }
    public void set_Pagetable(int page_num, int frame_num){
        Page_table[page_num] = frame_num;
    }
    public int get_Pagetable(int page_num){
        return Page_table[page_num];
    }
}
public class Main {
    static final int Memory_Size = 1024;
    static final int Page_Size = 16;
    static final int Frame_Size = Memory_Size/Page_Size;
    static final int Min_S_Size = 20;
    static final int Max_S_Size = 100;
    static boolean has_RestByte = true;
    static int Page_table[];
    static int Frame_table[];
    static Queue<Process> Process_List = new LinkedList<>();
    static void createProcess(){
        //프로세스 S의 크기 결정 20<=S<=100 (랜덤 함수 쓰기)
        int S = (int)(Math.random() * (Max_S_Size - Min_S_Size + 1)) + Min_S_Size;
        Process p1 = new Process(S);
        //while문 사용하여 S-=Page_Size 반복, 할당하고 남는 바이트가 있는지 boolean 변수로 체크
        // Frame_table의 인덱스 하나씩 (랜덤 함수)로 할당. 이때 해당 배열 값이 0(빈 프레임) 일 때만
        // 할당하고 아니면 (랜덤 함수)로 다른 인덱스로 다시 할당 반복(while문)
        // has_RestByte==true ->Page_Size만큼, has_RestByte==false -> S만큼 Fram_table의 배열에 입력
        while(true){
            if(!has_RestByte){
                break;
            }
            S-=Page_Size;
            if(S>=0){
                has_RestByte = true;
            }
            else{
                S+=Page_Size; //음수일 경우 뺀 바이트 수만큼 더해줌
                has_RestByte = false;
            }
            while(true){
                int index = (int)(Math.random() * Frame_Size);
                if(Frame_table[index]==0){
                    if(has_RestByte){
                        Frame_table[index] = Page_Size;
                        break;
                    }
                    else{
                        Frame_table[index] = S;
                        break;
                    }
                }
                else{
                    continue;
                }
            }
        }
    }
    static void terminateProcess(){
        
    }
    static void print_tables(){
        System.out.print("FrameTable(Used Index) : [ ");
        for(int i=0; i<Frame_Size; i++){
            if(Frame_table[i]!=0){
                System.out.print(i + "["+Frame_table[i] +"]" + " ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws IOException {
        Frame_table = new int[Frame_Size];
        Page_table = new int[Frame_Size];
        createProcess();
        print_tables();
        //각 프로세스 생성, 종료 시 마다 테이블들의 상태를 보여줌
        //for(int i=0; i<7; i++){
            //2개의 프로세스 생성
            /* createProcess();
            print_tables(); */
            //1개의 프로세스 종료
            /* terminateProcess();
            print_tables(); */
            //1개의 프로세스 생성
            /* createProcess();
            print_tables(); */
            //2개의 프로세스 종료
            /* terminateProcess();
            print_tables();
            terminateProcess();
            print_tables(); */
        //}
    }
}
