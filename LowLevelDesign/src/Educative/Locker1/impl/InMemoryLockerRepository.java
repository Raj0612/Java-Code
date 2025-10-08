package Educative.Locker1.impl;

import Educative.Locker1.enums.LockerSize;
import Educative.Locker1.interfaces.LockerRepository;
import Educative.Locker1.model.Locker;

import java.util.*  ;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryLockerRepository implements LockerRepository {
    private final Map<String, Locker> store = new ConcurrentHashMap<>();

    @Override
    public Optional<Locker> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void save(Locker locker) {
        store.put(locker.getId(), locker);
    }

    @Override
    public List<Locker> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Locker> findAvailable(LockerSize size) {
        return store.values().stream()
                .filter(l -> l.getSize() == size && l.isAvailable())
                .toList();
    }
}
