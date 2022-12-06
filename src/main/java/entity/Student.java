package entity;

import entity.enumeration.GradeType;
import entity.enumeration.UniversityType;
import entity.loan.Loan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Student extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "fatherName")
    private String fatherName;

    @Column(name = "MotherName")
    private String MotherName;

    @Column(name = "identifierNumber")
    private String identifierNumber;

    @Column(name = "brithDate")
    private Long brithDate;

    @Column(name = "married" , nullable = false)
    private boolean married;

    @Column(name = "nationalId" , nullable = false, unique = true )
    private String nationalId; // nationalId = username'
    @Column(name = "password" , nullable = false, unique = true )
    private String password;

    @Column(name = "studentNumber" , nullable = false, unique = true )
    private String studentNumber;


    @Column(name = "university" , nullable = false )
    @OneToOne
    private University university;

    @Column(name = "UniversityType" , nullable = false )
    private UniversityType universityType;

    @Column(name = "gradeType" , nullable = false )
    private GradeType gradeType;

    @Column(name = "dateOfEntrance" , nullable = false )
    private String dateOfEntrance;

    @Column(name = "dormitoryResident" , nullable = false )
    private boolean dormitoryResident;

    @OneToMany
    private List<Loan> loans;


    @Override
    public void setId(Long id) {

    }

    @Override
    public Long getId() {
        return null;
    }
}