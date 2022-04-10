import org.junit.Test;
import static org.junit.Assert.*;


public class TestArrayDequeGold {
    StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

    @Test
    public void testStudentDeque() {

        int size = 0;
        int k = 0;
        StringBuilder msg = new StringBuilder("");
        while (true) {
            double randomNumber = StdRandom.uniform();
            if (randomNumber < 0.25) {
                sad1.addFirst(k);
                ads1.addFirst(k);
                msg.append("addFirst(" + k + ")\n");
                size++;
            } else if (randomNumber < 0.5) {
                sad1.addLast(k);
                ads1.addLast(k);
                msg.append("addLast(" + k + ")\n");
                size++;
            } else if (randomNumber < 0.75 && size > 0) {
                Integer studentAnswer = sad1.removeFirst();
                Integer correctAnswer = ads1.removeFirst();
                msg.append("removeFirst()\n");
                assertEquals(msg.toString(), correctAnswer, studentAnswer);
                size--;
            } else if (randomNumber < 1 && size > 0) {
                Integer studentAnswer = sad1.removeLast();
                Integer correctAnswer = ads1.removeLast();
                msg.append("removeLast()\n");
                assertEquals(msg.toString(), correctAnswer, studentAnswer);
                size--;
            }
            k++;
        }

    }
}