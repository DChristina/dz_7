import java.util.Optional;

public enum SunSystem {
    Mercury(0, 50,2440,null,"Venus"),
    Venus(1, 42,6052,Mercury,"Earth"),
    Earth(2,78,6371,Venus,"Mars"),
    Mars(3,550,3390,Earth,"Jupiter"),
    Jupiter(4,651,69911,Mars,"Saturn"),
    Saturn(5,1446,58232,Jupiter,"Uranus"),
    Uranus(6,1622,25362,Saturn,"Neptune"),
    Neptune(7,0,15299,Uranus,null);

    private final int orderNumber;
    private final int distanceToNextPlanet;
    private final int radiusOfPlanet;
    private final int distanceToSun;
    private final SunSystem previousPlanet;
    private final String nextPlanet;


    SunSystem(int orderNumber, int distanceToNextPlanet, int radiusOfPlanet, SunSystem previousPlanet,String nextPlanet ){


        this.orderNumber = orderNumber;
        this.distanceToNextPlanet = distanceToNextPlanet;
        this.radiusOfPlanet = radiusOfPlanet;
        this.previousPlanet = previousPlanet;
        this.nextPlanet = nextPlanet;


        int distanceFromSunToFirstPlanet = 58;

        if (orderNumber==0){
            this.distanceToSun = distanceFromSunToFirstPlanet;
        } else {
            this.distanceToSun =previousPlanet.getDistanceToSun()+ previousPlanet.distanceToNextPlanet;
        }
    }


    public int getDistanceToNextPlanet() {
        return distanceToNextPlanet;
    }

    public int getDistanceToSun() {
        return distanceToSun;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getRadiusOfPlanet() {
        return radiusOfPlanet;
    }

    public SunSystem getPreviousPlanet() {
        return previousPlanet;
    }
    public String getNextPlanet() {
        return nextPlanet;
    }

}
