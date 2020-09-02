package userone;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomUseListRepository extends CrudRepository<RoomUseList, Long> {

    List<RoomUseList> findByBookingId(Long bookingId);
    List<RoomUseList> findByBookingId(Long bookingId);

}