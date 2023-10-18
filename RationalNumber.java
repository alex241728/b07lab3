package lab3;
import java.util.Objects;

/**
 * RationalNumber is a class inherits SpecialNumber and implements Comparable.
 * This class implements methods of arithmetic operations for RationalNumber
 * and implements a method of comparison between RationalNumber.
 *
 * @author Wentao (Alex) Yang
 * @version 1.0
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>
{
    private int numerator;
    private int denominator;


    /**
     * This method gets the numerator of the rational number.
     * @return      the numerator of the rational number
     */
    public int getNumerator()
    {
        return numerator;
    }


    /**
     * This method gets the denominator of the rational number.
     * @return      the denominator of the rational number
     */
    public int getDenominator()
    {
        return denominator;
    }


    /**
     * This method constructs a RationalNumber object with the providing numerator and denominator.
     * @param numerator         the numerator of the RationalNumber
     * @param denominator       the denominator of the RationalNumber
     * @throws Lab3Exception    if the denominator is zero or an error occurs
     */
    public RationalNumber(int numerator, int denominator) throws Lab3Exception
    {
        // check if the denominator is zero
        if (denominator == 0)
        {
            throw new Lab3Exception("Denominator cannot be zero");
        }

        // initiation
        this.numerator = numerator;
        this.denominator = denominator;
    }


    /**
     * Adds a RationalNumber to the calling RationalNumber
     * @param sn                the RationalNumber to be added
     * @return                  the RationalNumber after division
     * @throws Lab3Exception    if sn is not an instance of RationalNumber
     */
    @Override
    public SpecialNumber add(SpecialNumber sn) throws Lab3Exception
    {
        if (sn instanceof RationalNumber)
        {
            RationalNumber rn = (RationalNumber) sn;
            return new RationalNumber(this.numerator * rn.denominator + this.denominator * rn.numerator,
                    this.denominator * rn.denominator);
        }

        throw new Lab3Exception("Cannot add an incompatible type");
    }


    /**
     * Divides the calling RationalNumber by an integer
     * @param num               the integer to divide the calling SpecialNumber
     * @return                  the RationalNumber after division
     * @throws Lab3Exception    if the integer is zero
     */
    @Override
    public SpecialNumber divideByInt(int num) throws Lab3Exception
    {
        if (num != 0)
        {
            return new RationalNumber(this.numerator, this.denominator*num);
        }

        throw new Lab3Exception("Cannot divide by zero");
    }


    /**
     * This method compares the calling RationalNumber with another RationalNumber.
     * @param rn    the RationalNumber to be compared.
     * @return      0 if the calling RationalNumber is equal to rn; 1 if the calling RationalNumber is greater than rn;
     *              -1 otherwise
     */
    @Override
    public int compareTo(RationalNumber rn)
    {
        // the calling RationalNumber
        int sn = this.simplify().numerator;
        int sd = this.simplify().denominator;

        // RationalNumber rn
        int rnsn = rn.simplify().numerator;
        int rnsd = rn.simplify().denominator;

        // check if numerators and denominators are equal after simplifying
        if (sn == rnsn && sd == rnsd)
        {
            return 0;
        }

        // check less or greater
        double val = (double) sn / sd;
        double rnval = (double) rnsn / rnsd;
        if (val > rnval)
        {
            return 1;
        }
        return -1;
    }

    /**
     * This method simplifies the calling RationalNumber
     * @return      the RationalNumber after simplified
     */
    private RationalNumber simplify()
    {
        int n = this.numerator;
        int d = this.denominator;
        int gcd = gcd(n, d);
        try
        {
            return new RationalNumber(n/gcd, d/gcd);
        }
        catch (Lab3Exception e)
        {
            throw new RuntimeException(e);
        }
    }


    /**
     * This method finds the greatest common divisor (gcd) of two integers
     * @param a     one integer
     * @param b     another integer
     * @return      the greatest common divisor (gcd) of the two integers
     */
    private static int gcd(int a, int b)
    {
        while (a != b)
        {
            if (a < b)
            {
                b -= a;
            } else
            {
                a -= b;
            }
        }
        return a;
    }


    /**
     * This method checks if the calling RationalNumber is equal to an Object.
     *
     * @param o     the Object to be compared with the calling RationalNumber
     * @return      true if the two objects are equal and false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return this.compareTo(that) == 0;
    }


    /**
     *  This method generates a hashcode for the calling RationalNumber
     * @return      the hashcode of the calling RationalNumber
     */
    @Override
    public int hashCode()
    {
        int gcd = gcd(numerator, denominator);
        return Objects.hash(numerator/gcd, denominator/gcd);
    }
}
