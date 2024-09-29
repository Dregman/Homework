import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.FactorialCalculator;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = ".*отрицательных чисел.*")
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1);
    }
}