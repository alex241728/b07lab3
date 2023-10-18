package lab3;
import java.util.List;

/**
 * SpecialNumber is an abstract base class for all special numbers.
 * Subclasses - RationalNumber and ComplexNumber - provide concrete implementations to this class.
 *
 * This class provides two abstract methods of arithmetic operations for SpecialNumber
 * and provides a static, concrete method for computing the average value of a list of SpecialNumber.
 *
 * @author Wentao (Alex) Yang
 * @version 1.0
 */
public abstract class SpecialNumber
{
    /**
     * Adds a SpecialNumber to the calling SpecialNumber
     *
     * @param sn                the SpecialNumber to be added
     * @return                  the SpecialNumber after addition
     * @throws Lab3Exception    if an error occurs during the addition
     */
    public abstract SpecialNumber add(SpecialNumber sn) throws Lab3Exception;


    /**
     * Divides the calling SpecialNumber by an integer
     * @param num               the integer to divide the calling SpecialNumber
     * @return                  the SpecialNumber after division
     * @throws Lab3Exception    if an error occurs during the division
     */
    public abstract SpecialNumber divideByInt(int num) throws Lab3Exception;


    /**
     *
     * @param list              a list of SpecialNumber
     * @return                  the average SpecialNumber of all the SpecialNumber in the input list
     * @throws Lab3Exception    if list is empty or an error occurs during computation
     */
    public static SpecialNumber computeAverage(List<SpecialNumber> list) throws Lab3Exception
    {
        // check if list is empty
        if (list == null || list.size() == 0)
        {
            throw new Lab3Exception("List cannot be empty");
        }

        // add up all the numbers in list
        SpecialNumber sum = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            sum = sum.add(list.get(i));
        }

        // return the average
        return sum.divideByInt(list.size());
    }
}
