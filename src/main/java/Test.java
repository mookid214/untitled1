public class Test {
    public static void main(String[] args) {

    Bus blue = new Bus();
    Taxi a = new Taxi();
    Taxi b = new Taxi();


    System.out.println("blue의 차번호 확인 : " + blue.carNum);
    System.out.println("a의 차번호 확인 : " + a.carNum);
    System.out.println("b의 차번호 확인 : " + b.carNum);
    blue.drive();
    a.drive();
    a.fuel = 5;
    blue.setSpeed(100);
    a.setSpeed(20);
    blue.take(20);
    a.take(3);
    blue.statusCheck();
    a.statusCheck();
    a.setDestination("부산", 5);

    }
}

class Transport {
    static int num = 0;
    int carNum;
    int fuel;
    int speed;
    int fare;
    int maxPassenger;
    int currentPassenger;
    boolean status;

    Transport (){
        fuel = 100;
        speed = 0;
        currentPassenger = 0;
        num++;
    }

    public void drive(){
        if ( fuel >= 10) {
            status = true;
            System.out.println("운행을 시작합니다. 기름 : " + fuel);
        } else {
            status = false;
            System.out.println("주유량을 확인해주세요. 기름 : " + fuel);
        }
    }
    public void setSpeed (int num){
        if ( fuel >= 10 ){
            speed = num;
            System.out.println("속도를 설정합니다. 현재 속도 : " + speed);
        } else {
            System.out.println("주유량을 확인해주세요. 기름 : " + fuel);
        }
    }

    public void take (int num){
        if(maxPassenger >= currentPassenger + num && status){
            currentPassenger += num;
            System.out.println("운행을 시작합니다. 승객 수 : " + currentPassenger);
        } else if (!status){
            System.out.println("운행중이 아닙니다.");
        } else {
            System.out.println("탑승 인원을 초과했습니다.");
        }
    }

}

class Bus extends Transport {
    Bus (){
        super();
        status = true;
        maxPassenger = 30;
        fare = 1000;
        carNum = num++;
    }

    public void statusCheck () {
        if (status) {
            System.out.println("운행중");
        } else {
            System.out.println("차고지행");
        }
    }


}

class Taxi extends Transport {
    int distance;
    int fareDis;
    String destination;

    Taxi (){
        super();
        status = false;
        maxPassenger = 4;
        fare = 3000;
        distance = 1;
        fareDis = 1000;
        carNum = num;
        destination = "없음";
    }

    public void statusCheck () {
        if (status) {
            System.out.println("일반");
        } else {
            System.out.println("탑승 불가");
        }
    }

    public void setDestination (String destination, int distance){
        this.destination = destination;
        this.distance = distance;
        System.out.println(destination + " 까지의 거리는 " + distance + "이고 요금은 " +
                (fare + fareDis * distance) + "원 입니다.");
    }

}