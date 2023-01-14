package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Room;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends BaseRepository<Room> {
}
