package demo;

import javax.persistence.*;

@Entity
@Table(name = "alternative")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "alternative", nullable = false, unique = true)
    private String alternative;

    @Column(name = "count", nullable = false)
    private Long count;

    protected Alternative(){}

    public Alternative(final String alternative){
        this.alternative = alternative;
        this.count = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public String toString() {
        return alternative + " - " + count;
    }
}