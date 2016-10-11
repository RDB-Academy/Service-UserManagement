package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author fabiomazzone
 */
@Entity
public class Session extends Model {
    @Id
    String id;

    @ManyToOne
    Profile profile;

    DateTime createdAt;
}
