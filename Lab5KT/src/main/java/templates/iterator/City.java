package templates.iterator;

import java.util.ArrayList;

public class City implements Collection{

    private ArrayList<Sight> sights = new ArrayList<Sight>();

    @Override
    public Iterator getIterator() {
        return new SightIterator();
    }
    public void VisitCityExcursion()
    {
        Iterator CityIterator = getIterator();
        while (CityIterator.hasNext())
        {
            Sight sight = (Sight)CityIterator.next();
            System.out.println("Следующий пункт экскурсии:" + sight.getName());
            System.out.println("Находится по адресу:" + sight.getAddress());
            System.out.println("Об достопримечательности:" + sight.getDescription());
        }
    }
    private class SightIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < sights.size();
        }

        @Override
        public Object next() {
            return sights.get(index++);
        }

        @Override
        public Object first(){
            return sights.get(0);
        }

        @Override
        public Object getCurrentElement() {
            return sights.get(index);
        }
    }
}
