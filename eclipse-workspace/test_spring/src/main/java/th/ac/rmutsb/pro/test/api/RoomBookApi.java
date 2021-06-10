package th.ac.rmutsb.pro.test.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.rmutsb.pro.test.entity.BookRoomEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.repository.RoomBookRepository;

@RequestMapping("/book")
@RestController
public class RoomBookApi {
	
	@Autowired private RoomBookRepository regisReps;
	
	@GetMapping("/{id}")
    public BookRoomEntity getBook(@PathVariable(value= "id")Long Id) {
        return this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+Id+" "+"not found"));
    }
	
    @GetMapping("/lists")
    public List<BookRoomEntity> getRooms() {
        return this.regisReps.findAll();
    }
    
    @PostMapping
    public BookRoomEntity createBook(@RequestBody BookRoomEntity room) {
        return this.regisReps.save(room);
      }

    @DeleteMapping("/{id}")
    public BookRoomEntity deleteBook(@PathVariable(value= "id")Long Id) {
        BookRoomEntity book = this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
        this.regisReps.delete(book);
        return book;
    }
    
    @PutMapping("/{id}")
    public BookRoomEntity updateBook(@PathVariable (value= "id") Long Id, @RequestBody BookRoomEntity book) {
    	BookRoomEntity editbook = this.regisReps.findById(Id)
    		.orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
    	editbook.setEmail(book.getEmail());
    	editbook.setName(book.getName());
    	return this.regisReps.save(editbook);
    }



}