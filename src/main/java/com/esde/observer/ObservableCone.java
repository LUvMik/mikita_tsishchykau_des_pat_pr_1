package com.esde.observer;

import com.esde.entity.Cone;
import com.esde.entity.Point;
import com.esde.observer.api.Observable;
import com.esde.observer.api.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObservableCone extends Cone implements Observable {
    private final List<Observer> observers = new ArrayList<>();

    public ObservableCone(String id, Point base, Point apex, double radius) {
        super(id, base, apex, radius);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }

    @Override
    public void setBaseCenter(Point baseCenter) {
        super.setBaseCenter(baseCenter);
        notifyObservers();
    }

    @Override
    public void setApex(Point apex) {
        super.setApex(apex);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }
}