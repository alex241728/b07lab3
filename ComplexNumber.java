package lab3;
import java.util.Objects;

/**
 * ComplexNumber is a class inherits SpecialNumber and implements Comparable.
 * This class implements methods of arithmetic operations for ComplexNumber
 * and implements a method of comparison between RationalNumber.
 * @author Wentao (Alex) Yang
 * @version 1.0
 */
public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>
{
    private double real;
    private double imaginary;


    /**
     * This method gets the real part of complex number.
     * @return      the real part of the complex number
     */
    public double getReal()
    {
        return real;
    }


    /**
     * This method gets the imaginary part of complex number.
     * @return      the imaginary part of the complex number
     */
    public double getImaginary()
    {
        return imaginary;
    }


    /**
     * This method constructs a ComplexNumber object with the providing real and imaginary.
     * @param real          the real part of a complex number
     * @param imaginary     the imaginary part of a complex number
     */
    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }


    /**
     * Adds a ComplexNumber to the calling ComplexNumber
     * @param sn                the ComplexNumber to be added
     * @return                  the ComplexNumber after addition
     * @throws Lab3Exception    if sn is not an instance of ComplexNumber
     */
    @Override
    public SpecialNumber add(SpecialNumber sn) throws Lab3Exception
    {
        if (sn instanceof ComplexNumber)
        {
            ComplexNumber cn = (ComplexNumber) sn;
            return new ComplexNumber(this.real + cn.real, this.imaginary + cn.imaginary);
        }

        // if sn is not an instance of ComplexNumber
        throw new Lab3Exception("Cannot add an incompatible type");
    }


    /**
     * Divides the calling ComplexNumber by an integer
     * @param num               the integer to divide the calling ComplexNumber
     * @return                  the ComplexNumber after division
     * @throws Lab3Exception    if the integer is zero
     */
    @Override
    public SpecialNumber divideByInt(int num) throws Lab3Exception
    {
        if (num == 0)
        {
            throw new Lab3Exception("Cannot divide by zero");
        }
        return new ComplexNumber(this.real/num, this.imaginary/num);
    }


    /**
     * This method compares the calling ComplexNumber with another ComplexNumber.
     * @param cn    the ComplexNumber to be compared.
     * @return      0 if the calling ComplexNumber is equal to rn; 1 if the calling ComplexNumber is greater than rn;
     *              -1 otherwise
     */
    @Override
    public int compareTo(ComplexNumber cn)
    {
        double epsilon = 1e-8;
        if (Math.abs(this.magnitude()-cn.magnitude()) < epsilon)
        {
            return 0;
        }
        else if (this.magnitude()-cn.magnitude() > epsilon)
        {
            return 1;
        }
        return -1;
    }


    /**
     * This method calculates the magnitude of the calling ComplexNumber.
     * @return      the magnitude of the calling ComplexNumber
     */
    private double magnitude()
    {
        return Math.sqrt(Math.pow(this.real, 2)+Math.pow(this.imaginary, 2));
    }


    /**
     * This method checks if the calling ComplexNumber is equal to an Object.
     * @param o     the Object to be compared with the calling ComplexNumber
     * @return      true if the two objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return this.imaginary == that.imaginary && this.real == that.real;
    }


    /**
     * This method generates a hashcode for the calling ComplexNumber
     * @return      the hashcode of the calling ComplexNumber
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(real, imaginary);
    }
}
