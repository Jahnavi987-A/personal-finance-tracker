package com.example.personalFinanceTracker.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/notes")
    public void addNotes(@RequestBody Notes notes){
        notesService.addNotes(notes);
    }
    @DeleteMapping("/deletenotes/{id}")
    public void deleteNotesById(@PathVariable int id){
        notesService.deleteNotesById(id);
    }
    @PatchMapping("/updatenotes/{id}")
    public void updateNotes(@PathVariable int id, @RequestBody Notes notes){
        notesService.updateNotes(id, notes);
    }
}
