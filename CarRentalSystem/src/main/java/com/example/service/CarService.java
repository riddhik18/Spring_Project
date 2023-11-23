package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Car;
import com.example.repository.CarRepository;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car existingCar = getCarById(id);

        if (existingCar != null) {
            // Update the fields of the existing car with the values from the updated car
            existingCar.setModel(updatedCar.getModel());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setYear(updatedCar.getYear());
            // Add other fields as needed

            // Save the updated car
            return saveCar(existingCar);
        }

        // Return null or throw an exception if the car with the given id is not found
        return null;
    }
}

