public class Track extends Thread {
    private boolean isFinish = false;
    private String name;
    private int serialNumber;
    private int speed;
    private int trackLength;
    private boolean status;
    private int distanceTraveled = 0;

    //вероятности
    private double probabilityOut = 0.2;
    private double probabilityAcceleration = 0.3;
    private double probabilityStop = 0.4;
    private double probabilitySlow = 0.5;

    public Track(String nameThread, String name, int serialNumber, int trackLength) {
        super(nameThread);
        this.name = name;
        this.serialNumber = serialNumber;
        this.trackLength = trackLength;
        status = true;
    }

    @Override
    public void run() {
        while ((!status) || (distanceTraveled == trackLength)) {
            double test = Math.random();
            setSpeed(test);
            distanceTraveled += speed;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (status) {
            System.out.println("name: " + name);
        } else {
            System.out.println("Horse lose " + name);
        }
    }

    private void setSpeed(double mathProbability) {
        System.out.println(mathProbability);
        if (mathProbability <= probabilityOut) {
            status = false;
            speed = 0;
        } else if (mathProbability <= probabilityAcceleration) {
            speed = 30;
        } else if (mathProbability <= probabilityStop) {
            speed = 0;
        } else if (mathProbability <= probabilitySlow) {
            speed = 10;
        } else {
            speed = 20;
        }
    }

}
