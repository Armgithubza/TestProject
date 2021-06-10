package th.ac.rmutsb.pro.test.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import th.ac.rmutsb.pro.test.entity.RoomEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.RoomModel;
import th.ac.rmutsb.pro.test.repository.RoomRepository;

@RequestMapping("/room")
@RestController
public class RoomApi {

    @Autowired private RoomRepository reps;


    @GetMapping("/{id}")
    public RoomEntity getRoom(@PathVariable(value= "id")Long Roomid) {
        return this.reps.findById(Roomid)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+Roomid+" "+"not found"));
    }

    @GetMapping("/lists")
    public List<RoomEntity> getRooms() {
        return this.reps.findAll();
    }

    @GetMapping
    public Page<RoomEntity> getRoomsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.reps.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        return this.reps.save(room);
      }
    

    @DeleteMapping("/{id}")
    public RoomEntity deleteRoom(@PathVariable(value= "id")Long Roomid) {
        RoomEntity room = this.reps.findById(Roomid)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+Roomid+" "+"not found"));
        this.reps.delete(room);
        return room;
    }

    @PutMapping("/{id}")
    public RoomEntity updateRoom(@PathVariable (value= "id") Long Roomid, @RequestBody RoomEntity room) {
    	RoomEntity editroom = this.reps.findById(Roomid)
    		.orElseThrow(() -> new ResourceNotFoundException("room"+" "+Roomid+" "+"not found"));
    	editroom.setRoomName(room.getRoomName());
    	editroom.setAmount(room.getAmount());
    	editroom.setRoomPicture(room.getRoomPicture());
    	editroom.setRoomDetail(room.getRoomDetail());
    	return this.reps.save(editroom);
    }
}
