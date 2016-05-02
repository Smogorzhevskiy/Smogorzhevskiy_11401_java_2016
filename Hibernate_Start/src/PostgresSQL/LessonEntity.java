package PostgresSQL;

import javax.persistence.*;

/**
 * Created by User on 08.04.16.
 */
@Entity
@Table(name = "lesson", schema = "public", catalog = "postgres")
public class LessonEntity {
    private Integer id;
    private String title;
    private Integer teacherId;
    private Integer maxStud;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "teacher_id")
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "max_stud")
    public Integer getMaxStud() {
        return maxStud;
    }

    public void setMaxStud(Integer maxStud) {
        this.maxStud = maxStud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LessonEntity that = (LessonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (maxStud != null ? !maxStud.equals(that.maxStud) : that.maxStud != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (maxStud != null ? maxStud.hashCode() : 0);
        return result;
    }
}
