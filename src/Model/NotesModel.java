/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Note;
//import Forms.Panels.Notes;
import Library.DBManager;
import Library.State;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Huy Hys
 */
public class NotesModel {
    DBManager dBManager = new DBManager();
    
    public ArrayList<Note> getAllNotes(){
        
        ArrayList<Note> notes = new ArrayList<>();
        String sqlQuery = "SELECT * From notes where user_id = "+State.currentUser.getId();
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlQuery);
        
        for(HashMap row : dbData){
            
            notes.add(new Note(
                    (int)row.get("id"), row.get("title").toString(), row.get("content").toString()
            ));
        }
        return notes;
    }
    
    
    public boolean insertNotes(Note note){
        
        String sqlQuery = dBManager.securceSql(
                "INSERT INTO notes (user_id,title,content) VALUES({$1},{$2},{$3})",
                new String[]{State.currentUser.getId()+"",note.getTitle(),note.getContent()}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public boolean deleteNotes(int id){
        String sqlQuery = "DELETE From notes Where id = "+id;
        return dBManager.setQuery(sqlQuery);
    }
    
    public  boolean updateNotes(Note note){
        String sqlQuery = dBManager.securceSql(
                "UPDATE notes SET title={$1}, content={$2} where id={$3}",
                new String[]{
                    note.getTitle(),note.getContent(),note.getId()+""
                }
        );
        return dBManager.setQuery(sqlQuery);
    }
    
}
