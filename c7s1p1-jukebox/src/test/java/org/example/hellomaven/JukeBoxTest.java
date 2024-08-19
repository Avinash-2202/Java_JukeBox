package org.example.hellomaven;
import jukebox.DAOImpl.Details;
import jukebox.model.song;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class JukeBoxTest {
    @Test
    public void SearchsongTest() {
        ArrayList<song> list = Details.Searchsong(" Arabic Kuthu ");
        assertEquals(0, (list.size()));
    }

    @Test
    public void GenreTest() {
        ArrayList<song> list1 = Details.SearchByGenre(" Rock ");
        assertEquals(0, (list1.size()));
    }

    @Test
    public void artistTest() {
        ArrayList<song> list2;
        list2 = Details.SearchByArtist(" Yuvan  ");
        assertEquals( 0,(list2.size()));
    }

    @Test
    public void Songs() {
        ArrayList<song> list4 = Details.songs();
        assertEquals(6, (list4.size()));
    }
        @Test
    public void SearchsongTestFailure(){
            ArrayList<song> list = Details.Searchsong("Oru Malai ");
            assertNotEquals(1, (list.size()));
    }
    @Test
    public void GenreTestFailure() {
        ArrayList<song> list1 = Details.SearchByGenre("Anirudh");
        assertNotEquals(2, (list1.size()));
    }

    @Test
    public void artistTestFailure() {
        ArrayList<song> list2 = Details.SearchByArtist("rock ");
        assertNotEquals( 2,(list2.size()));
    }

    @Test
    public void SongsFailure() {
        ArrayList<song> list4 = Details.songs();
        assertNotEquals(1, (list4.size()));
    }
}