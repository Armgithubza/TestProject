package th.ac.rmutsb.pro.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.ac.rmutsb.pro.test.entity.BookRoomEntity;

@Repository
public interface RoomBookRepository extends JpaRepository<BookRoomEntity, Long>{

}
