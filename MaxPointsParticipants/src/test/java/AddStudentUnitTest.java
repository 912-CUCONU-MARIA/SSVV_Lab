import domain.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;
import validation.Validator;


public class AddStudentUnitTest {

    private StudentXMLRepository studentXMLRepository;

    @Before
    public void setup(){
        Validator<Student> studentValidator = new StudentValidator();
        studentXMLRepository=new StudentXMLRepository(studentValidator,"testStudents.xml");
    }

    @Test
    public void shouldAddStudent(){
        Student student=new Student("1","Mihai",932);
        studentXMLRepository.save(student);
        Assert.assertEquals(studentXMLRepository.findOne("1").getGrupa(), student.getGrupa());
    }

    @Test
    public void shouldNotAddStudentWhenIdExists(){
        Student student=new Student("1","Fake",999);
        Assert.assertNull(studentXMLRepository.save(student));
    }



}
