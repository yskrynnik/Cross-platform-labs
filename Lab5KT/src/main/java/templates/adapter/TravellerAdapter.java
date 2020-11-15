package templates.adapter;

import templates.adapter.Boat;
import templates.adapter.TravelCrossWater;

public class TravellerAdapter implements TravelCrossWater {
    private Boat boat;

    public Boat getBoat()
    {
        return boat;
    }
    public void changeBoat(Boat boat)
    {
        this.boat = boat;
    }

    public TravellerAdapter(Boat boat)
    {
        this.boat = boat;
    }

    @Override
    public void Swim() {
        boat.Swim();
        System.out.println("Водная дистанция пройдена!");
    }
}
