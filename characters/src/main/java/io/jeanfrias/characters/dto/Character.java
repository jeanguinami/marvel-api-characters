
package io.jeanfrias.characters.dto;

import java.sql.Date;
import java.util.List;

public class Character {

    public Integer id;
    public String name;
    public String description;
    public Date modified;
    public String resourceURI;
    public List<Url> urls = null;
    public Image thumbnail;
    public ComicList comics;
    public StoryList stories;
    public EventList events;
    public SeriesList series;

}
