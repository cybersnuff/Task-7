package web.CarDao;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
@Component
public class CarDao {
    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("BMW", 1, "Black"));
        carList.add(new Car("Lada", 2107, "Green"));
        carList.add(new Car("Reno", 2, "Pink"));
        carList.add(new Car("Skoda", 10, "Yellow"));
    }
    public List<Car> returnCar(){
        return carList;
    }
}
