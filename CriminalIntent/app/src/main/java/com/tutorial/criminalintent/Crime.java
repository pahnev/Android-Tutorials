package com.tutorial.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kirill on 2/13/15.
 */
public class Crime {
    private UUID ID;
    private String title;
    private Date date;
    private boolean solved;

    public Crime() {
        // Generate unique identifier
        ID = UUID.randomUUID();

        setDate(new Date());
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }


}
