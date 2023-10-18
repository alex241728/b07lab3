package lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test2
{
    @Test
    void testRationalNumberAdd() throws Lab3Exception
    {
        RationalNumber r1 = new RationalNumber(1, 3);
        RationalNumber r2 = new RationalNumber(2, 3);
        SpecialNumber s = r1.add(r2);
        if (s instanceof RationalNumber)
        {
            RationalNumber r = (RationalNumber) s;
            assertEquals(9, r.getNumerator());
            assertEquals(9, r.getDenominator());
        }
    }

    @Test
    void testRationalNumberDivision1() throws Lab3Exception
    {
        RationalNumber r1 = new RationalNumber(1, 2);
        SpecialNumber s = r1.divideByInt(3);
        if (s instanceof RationalNumber)
        {
            RationalNumber r = (RationalNumber) s;
            assertEquals(1, r.getNumerator());
            assertEquals(6, r.getDenominator());
        }
    }

    @Test
    void testRationalNumberDivision2()
    {
        try
        {
            RationalNumber r1 = new RationalNumber(1, 2);
            SpecialNumber s = r1.divideByInt(3);
        }
        catch (Lab3Exception e)
        {
            assertEquals("Cannot divide by zero", e.message);
        }
    }

    @Test
    void testRationalNumberCompare1() throws Lab3Exception
    {
        RationalNumber r1 = new RationalNumber(1, 2);
        RationalNumber r2 = new RationalNumber(2, 3);
        RationalNumber r3 = new RationalNumber(1, 2);
        assertEquals(-1, r1.compareTo(r2));
        assertEquals(0, r1.compareTo(r3));
        assertEquals(1, r2.compareTo(r1));
    }

    @Test
    void testRationalNumberCompare2() throws Lab3Exception
    {
        RationalNumber r1 = new RationalNumber(2, 4);
        RationalNumber r2 = new RationalNumber(4, 6);
        RationalNumber r3 = new RationalNumber(1, 2);
        assertEquals(-1, r1.compareTo(r2));
        assertEquals(0, r1.compareTo(r3));
        assertEquals(1, r2.compareTo(r1));
    }

    @Test
    void testComplexNumberException()
    {
        try
        {
            RationalNumber r = new RationalNumber(1,1);
            ComplexNumber c = new ComplexNumber(1, 1);
            c.add(r);
        }
        catch (Lab3Exception e)
        {
            assertEquals("Cannot add an incompatible type", e.message);
        }
    }

    @Test
    void testComplexNumberAdd() throws Lab3Exception
    {
        ComplexNumber c1 = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(3, 5);
        SpecialNumber s = c1.add(c2);
        if (s instanceof ComplexNumber)
        {
            ComplexNumber c = (ComplexNumber) s;
            assertEquals(4, c.getReal());
            assertEquals(7, c.getImaginary());
        }
    }

    @Test
    void testComplexNumberDivision1() throws Lab3Exception
    {
        ComplexNumber c1 = new ComplexNumber(1, 2);
        SpecialNumber s = c1.divideByInt(2);
        if (s instanceof ComplexNumber)
        {
            ComplexNumber c = (ComplexNumber) s;
            assertEquals(0.5, c.getReal());
            assertEquals(1, c.getImaginary());
        }
    }

    @Test
    void testComplexNumberDivision2()
    {
        try
        {
            ComplexNumber c1 = new ComplexNumber(1, 2);
            c1.divideByInt(0);
        }
        catch (Lab3Exception e)
        {
            assertEquals("Cannot divide by zero", e.message);
        }
    }

    @Test
    void testComplexNumberCompare()
    {
        ComplexNumber c1 = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(2, 1);
        ComplexNumber c3 = new ComplexNumber(3, 9);
        assertEquals(-1, c1.compareTo(c3));
        assertEquals(0, c1.compareTo(c2));
        assertEquals(1, c3.compareTo(c1));
    }

    @Test
    void testComplexNumberEquals()
    {
        ComplexNumber r1 = new ComplexNumber(1,2);
        ComplexNumber r2 = new ComplexNumber(2,4);
        ComplexNumber r3 = new ComplexNumber(1,2);
        assertEquals(false, r1.equals(r2));
        assertEquals(r1, r3);
    }

    @Test
    void testComplexNumberHash()
    {
        ComplexNumber r1 = new ComplexNumber(1,2);
        ComplexNumber r2 = new ComplexNumber(2,4);
        ComplexNumber r3 = new ComplexNumber(1,2);
        assertEquals(false, r1.hashCode() == r2.hashCode());
        assertEquals(r1, r3);
    }
}
