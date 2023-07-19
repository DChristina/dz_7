
public enum SunSystem {
    Mercury( 50,2440,null),
    Venus( 42,6052,Mercury),
    Earth(78,6371,Venus),
    Mars(550,3390,Earth),
    Jupiter(651,69911,Mars),
    Saturn(1446,58232,Jupiter),
    Uranus(61622,25362,Saturn),
    Neptune(0,15299,Uranus);

    final int orderNumber;
    final int distanceToNextPlanet;
    final int radiusOfPlanet;
    final int distanceToSun;
    final SunSystem previousPlanet;
    private SunSystem nextPlanet;


    SunSystem( int distanceToNextPlanet, int radiusOfPlanet, SunSystem previousPlanet){

        this.distanceToNextPlanet = distanceToNextPlanet;
        this.radiusOfPlanet = radiusOfPlanet;
        int distanceFromSunToFirstPlanet = 58;

        if (previousPlanet == null){
            this.orderNumber = 1;
            this.distanceToSun = distanceFromSunToFirstPlanet;
            this.previousPlanet = null;
        } else {
            this.orderNumber = previousPlanet.orderNumber + 1;
            this.distanceToSun =previousPlanet.getDistanceToSun()+ previousPlanet.distanceToNextPlanet;
            this.previousPlanet = previousPlanet;
            this.previousPlanet.nextPlanet = this;
        }
    }
    SunSystem( int distanceToNextPlanet, int radiusOfPlanet){
        this(distanceToNextPlanet,radiusOfPlanet, null);
    }

    public int getDistanceToNextPlanet() { return distanceToNextPlanet; }

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
    public SunSystem getNextPlanet() {
        return nextPlanet;
    }

}
