package com.example.personalFinanceTracker.notes;

import java.util.List;

// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    
    @Autowired
    private NotesRepository notesRepository;

    public void addNotes(Notes notes){
        notesRepository.save(notes);
    }
    public void deleteNotesById(int id){
        notesRepository.deleteById(id);
    }
    public void updateNotes(int id, Notes notes){
        Notes existing = getNotesById(id);
        if(notes.getNotes()!=null){
            existing.setNotes(notes.getNotes());
        }
        if(notes.getDate()!=null){
            existing.setDate(notes.getDate());
        }
        notesRepository.save(existing);
    }
    public Notes getNotesById(int id){
        return notesRepository.findById(id).orElseThrow(()->new RuntimeException("Notes not found"));
    }
    public List<Notes> getNotes(){
        return notesRepository.findAll();
    }
}
